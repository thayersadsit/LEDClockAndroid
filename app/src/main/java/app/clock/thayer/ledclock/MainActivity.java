package app.clock.thayer.ledclock;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.UUID;


public class MainActivity extends Activity implements View.OnTouchListener {

    MyBringBackSurface ourSurfaceView;
    float x,y;
    LEDMatrix ledMatrix;
    int[] mode=new int[2];
    int[] hoverMode=new int[2];
    long startTime;
    long endTime;

    private static final int REQUREST_ENABLE_BT=1;
    private static final String TAG="bluetooth2";
    private BluetoothAdapter btAdapter=null;
    private BluetoothSocket btSocket=null;
    private OutputStream outStream=null;
    private static final UUID MY_UUID= UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    private static String address="20:14:04:15:93:63";
    private ConnectedThread mConnectedThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        ourSurfaceView=new MyBringBackSurface(this);
        ourSurfaceView.setOnTouchListener(this);

        btAdapter=BluetoothAdapter.getDefaultAdapter();

        setContentView(ourSurfaceView);
    }

    private BluetoothSocket createBluetoothSocket(BluetoothDevice device) throws IOException{
        try {
            final Method m = device.getClass().getMethod("createInsecureRfcommSocketToServiceRecord", new Class[]{UUID.class});
            return (BluetoothSocket) m.invoke(device, MY_UUID);
        } catch(Exception e){
            Log.e(TAG, "Could not create insecure RFcomm Connection", e);
        }
        return device.createRfcommSocketToServiceRecord(MY_UUID);
    }


    @Override
    protected void onPause(){
        super.onPause();
        try{
            btSocket.close();
        }catch(IOException e2){
            errorExit("Fatal Error", "In onpause() and socket create failed");
        }

        ourSurfaceView.pause();

    }

    private class ConnectedThread extends Thread{
        private final OutputStream mmOutStream;

        public ConnectedThread(BluetoothSocket socket){
            OutputStream tmpOut=null;

            try {
                tmpOut = socket.getOutputStream();
            }catch(IOException e){}

            mmOutStream=tmpOut;


        }
        public void write(String message){
            Log.d(TAG,"...data to send: "+message+"...");
            byte[] msgBuffer=message.getBytes();
            try{
                mmOutStream.write(msgBuffer);
            }catch(IOException e){
                Log.d(TAG,"...Error data send: "+e.getMessage()+"...");
            }
        }
    }



    public void errorExit(String title,String message){
        Toast.makeText(getBaseContext(),title+" - "+message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume(){
        super.onResume();

        Log.d(TAG,"...onResume-try Connect...");
        BluetoothDevice device=btAdapter.getRemoteDevice(address);

        try{
            btSocket=createBluetoothSocket(device);
        }catch(IOException e){
            errorExit("Fatal Error","In onresume() and socket create failed");
        }
        btAdapter.cancelDiscovery();

        try{
            btSocket.connect();
            Log.d(TAG, "...Connection...ok");
        }catch(IOException e1){
            {
                try{
                    btSocket.close();
                } catch (IOException e2) {
                    errorExit("Fatal Error","In onresume() and socket create failed");
                }
            }
        }

        mConnectedThread=new ConnectedThread(btSocket);
        mConnectedThread.start();
        ourSurfaceView.resume();

    }

    public boolean onTouch(View v, MotionEvent event){
        int[] prevLed=new int[2];
        prevLed[0]=-1;
        prevLed[1]=-1;
        x=event.getX();
        y=event.getY();

        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                hoverMode=ledMatrix.rowColumnModeSelect(x,y);
                if(ledMatrix.ledLocation(y,x)[0]!=-1 && mode[0]==0 && mode[1]==1){
                    if(prevLed[0]!=ledMatrix.ledLocation(y,x)[0]&& prevLed[1]!=ledMatrix.ledLocation(y,x)[1]){
                        prevLed[0]=ledMatrix.ledLocation(y,x)[0];
                        prevLed[1]=ledMatrix.ledLocation(y,x)[1];

                        if(ledMatrix.getLED(prevLed[0],prevLed[1])==1) {
                            ledMatrix.setLED(prevLed[0], prevLed[1], 0);
                        } else{
                            ledMatrix.setLED(prevLed[0], prevLed[1], 1);
                        }
                    }

                }
                break;
            case MotionEvent.ACTION_MOVE:
                if(ledMatrix.ledLocation(y,x)[0]!=-1 && mode[0]==0 && mode[1]==1){
                    if(prevLed[0]!=ledMatrix.ledLocation(y,x)[0]&& prevLed[1]!=ledMatrix.ledLocation(y,x)[1]){
                        prevLed[0]=ledMatrix.ledLocation(y,x)[0];
                        prevLed[1]=ledMatrix.ledLocation(y,x)[1];

                        if(ledMatrix.getLED(prevLed[0],prevLed[1])==1) {
                            ledMatrix.setLED(prevLed[0], prevLed[1], 0);
                        } else{
                            ledMatrix.setLED(prevLed[0], prevLed[1], 1);
                        }
                    }

                }
                hoverMode=ledMatrix.rowColumnModeSelect(x,y);
                break;
            case MotionEvent.ACTION_UP:
                hoverMode=ledMatrix.rowColumnModeSelect(x,y);
                if(ledMatrix.rowColumnModeSelect(x,y)[0]!=5) {
                    mode = ledMatrix.rowColumnModeSelect(x, y);
                    ledMatrix.changeMode(mode);
                }
                break;
        }
        return true;

    }


    public class MyBringBackSurface extends SurfaceView implements Runnable {
        SurfaceHolder ourHolder;
        Thread ourThread = null;
        boolean isRunning = false;

        public MyBringBackSurface(Context context) {
            super(context);
            ourHolder = getHolder();
        }

        public void run() {
            boolean startInt=true;//allows start actions to take place

            while(isRunning) {
                if(!ourHolder.getSurface().isValid()){
                    continue;
                }
                Canvas canvas = ourHolder.lockCanvas();

                if(startInt){
                    ledMatrix=new LEDMatrix(8,32,canvas.getWidth(),canvas.getHeight());
                    startTime=System.currentTimeMillis()-1;
                    ledMatrix.createLetterLibrary();
                    startInt=false;
                }

                ledMatrix.setBox(hoverMode[0],hoverMode[1],1);


                endTime=System.currentTimeMillis();

                if(endTime-startTime>100){
                    ledMatrix.shiftLEDArray(mode);
                    startTime=System.currentTimeMillis();
                    mConnectedThread.write(ledArraytoText(ledMatrix));
                }



                drawCanvasBG(canvas,ledMatrix);
                if(hoverMode[0]==1 && hoverMode[1]==3) {
                    //mConnectedThread.write("t");
                }

            }
        }

        public void drawCanvasBG(Canvas canvas, LEDMatrix ledMatrix){

            canvas.drawRGB(0, 0, 0);

            float width = canvas.getWidth();
            float height = canvas.getHeight();

            drawBoxes(canvas,ledMatrix);

            drawLEDs(canvas, ledMatrix);

            ourHolder.unlockCanvasAndPost(canvas);
        }

        public void drawBoxes(Canvas canvas, LEDMatrix ledMatrix){
            Paint boxPaint=new Paint();
            boxPaint.setColor(Color.GRAY);
            Paint iconPaint=new Paint();
            canvas.drawRect(0, ledMatrix.getDistToBoxes(), ledMatrix.getWidth(), ledMatrix.getHeight(), boxPaint);
            ledMatrix.setBoxAreas();
            for(int i=0;i<2;i++){
                for(int j=0;j<4;j++){
                    if(ledMatrix.getBox(i,j)==1){
                        iconPaint.setColor(Color.GREEN);
                    }else{
                        iconPaint.setColor(Color.BLACK);
                    }
                    float top;
                    float left;
                    float right;
                    float bottom;
                    left=ledMatrix.getBoxAreas(i,j,0);
                    top=ledMatrix.getBoxAreas(i,j,1);
                    right=ledMatrix.getBoxAreas(i,j,2);
                    bottom=ledMatrix.getBoxAreas(i,j,3);
                    canvas.drawRect(left,top,right,bottom,iconPaint);


                    drawPics(i,j,top,left,right,bottom,ledMatrix,canvas);
                    //canvas.drawRect(left,ledMatrix.getDistToBoxes(),ledMatrix.getWidth(),ledMatrix.getHeight(),iconPaint);
                }
            }

        }

        public String ledArraytoText(LEDMatrix ledMatrix){
            String returnString="t";

            for(int m=0;m<4;m++){
                for(int i=0;i<8;i++){
                    for(int j=0;j<8;j++){
                        returnString=returnString+ledMatrix.getLED(j,i+8*m);

                    }

                }
            }
            return returnString;
        }

        public void drawPics(int i, int j,float top, float left, float right, float bottom, LEDMatrix ledMatrix, Canvas canvas){
            float radius=(bottom-top)/2/10;//radius of little circles
            float centerY=(bottom+top)/2;
            float centerX=(right+left)/2;
            float posIncrement=(bottom-top)/9;
            float leftsidecenter=(float)(centerX-3.5*posIncrement);
            float topsidecenter=(float)(centerY-3.5*posIncrement);
            Paint picPaint=new Paint();
            picPaint.setColor(Color.GRAY);

            for(int k=0;k<8;k++){
                for(int m=0;m<8;m++){
                    if(ledMatrix.getboxArrayPics(i,j,k,m)==1){
                        canvas.drawCircle(leftsidecenter+m*posIncrement,topsidecenter+k*posIncrement,radius,picPaint);
                    }
                }
            }



        }

        public void drawLEDs(Canvas canvas, LEDMatrix ledMatix){
            Paint paint=new Paint();


            for(int i=0; i<ledMatrix.getRows();i++){
                for(int j=0; j<ledMatrix.getColumns();j++) {
                    if(ledMatrix.getLED(i, j) == 1){
                        paint.setColor(Color.GREEN);
                    }else{
                        paint.setColor(Color.GRAY);
                    }

                    canvas.drawCircle(ledMatrix.getPosArrayY()[i][j], ledMatrix.getPosArrayX()[i][j],ledMatrix.getRadiusLED(),paint);

                }
            }
        }

        public void resume(){
            isRunning=true;
            ourThread=new Thread(this);
            ourThread.start();
        }

        public void pause(){
            isRunning=false;
            while(true){
                try{
                    ourThread.join();
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
                break;
            }
            ourThread=null;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
