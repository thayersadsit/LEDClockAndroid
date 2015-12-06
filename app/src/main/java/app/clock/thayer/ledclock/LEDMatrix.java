package app.clock.thayer.ledclock;

import java.util.Calendar;

/**
 * Created by thayer on 7/4/15.
 */
public class LEDMatrix {

    int[][] ledArray; //on or off matrix
    float[][] posArrayX; //matrix of x positions
    float[][] posArrayY; //matrix of y positions
    float width;//width of screen
    float height;//height of screen
    int columns; //number of LED columns
    int rows;//number of LED rows
    int radius;//radius of LEDs on board
    float distToBoxes;//distance to boxes
    float boxHeight;
    float boxWidth;
    int[][] boxArray; //on or off matrix
    float boxLineWidth;
    int[][][][] boxArrayPics;
    int[][][] boxArrayLimits; //first two are row column pairs last array is left top righ bottom
    int indexCounter;
    int smileCounter;
    Calendar dateTime;
    int minutes;
    int hours;

    String library;
    int[][][] libraryMatrices;

    public String word;
    int[][] wordMatrix;

    int[][] one = {
            {0, 0, 1, 0, 0},
            {0, 1, 1, 0, 0},
            {1, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {1, 1, 1, 1, 1}
    };

    int[][] two = {
            {0, 1, 1, 1, 0},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {0, 0, 0, 0, 1},
            {0, 1, 1, 1, 0},
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {1, 1, 1, 1, 1}
    };

    int[][] three = {
            {0, 1, 1, 1, 0},
            {1, 0, 0, 0, 1},
            {0, 0, 0, 0, 1},
            {0, 0, 1, 1, 0},
            {0, 0, 1, 1, 0},
            {0, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {0, 1, 1, 1, 0}
    };

    int[][] four = {
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1},
            {0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1}
    };

    int[][] five = {
            {1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {1, 1, 1, 1, 0},
            {0, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {0, 1, 1, 1, 0}
    };

    int[][] six = {
            {0, 1, 1, 1, 0},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 0},
            {1, 0, 1, 1, 0},
            {1, 1, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {0, 1, 1, 1, 0}
    };

    int[][] seven = {
            {1, 1, 1, 1, 1},
            {1, 0, 0, 0, 1},
            {0, 0, 0, 1, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 1, 1, 1, 0}
    };

    int[][] eight = {
            {0, 1, 1, 1, 0},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {0, 1, 1, 1, 0},
            {0, 1, 1, 1, 0},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {0, 1, 1, 1, 0}
    };
    int[][] nine = {
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}
    };




    int[][] space = {
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}
    };

    int[][] a = {
            {0, 0, 1, 0, 0},
            {0, 1, 0, 1, 0},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1}
    };

    int[][] b = {
            {1, 1, 1, 1, 0},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 1, 1, 1, 0},
            {1, 1, 1, 1, 0},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 1, 1, 1, 0}
    };

    int[][] c = {
            {0, 1, 1, 1, 0},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 1},
            {0, 1, 1, 1, 0}
    };

    int[][] d = {
            {1, 1, 1, 0, 0},
            {1, 0, 0, 1, 0},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 1, 0},
            {1, 1, 1, 0, 0}
    };

    int[][] e = {
            {1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {1, 1, 1, 1, 1}
    };

    int[][] f = {
            {1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0}
    };

    int[][] g = {
            {0, 1, 1, 1, 0},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {1, 0, 1, 1, 1},
            {1, 0, 1, 0, 1},
            {1, 0, 0, 0, 1},
            {0, 1, 1, 1, 0}
    };

    int[][] h = {
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1}
    };

    int[][] i = {
            {1, 1, 1, 1, 1},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {1, 1, 1, 1, 1}
    };

    int[][] j = {
            {0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {0, 1, 1, 1, 0}
    };

    int[][] k = {
            {1, 0, 0, 0, 1},
            {1, 0, 0, 1, 0},
            {1, 0, 1, 0, 0},
            {1, 1, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {1, 0, 1, 0, 0},
            {1, 0, 0, 1, 0},
            {1, 0, 0, 0, 1}
    };

    int[][] l = {
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1}
    };

    int[][] m = {
            {1, 0, 0, 0, 1},
            {1, 1, 0, 1, 1},
            {1, 0, 1, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1}
    };
    int[][] n = {
            {1, 0, 0, 0, 1},
            {1, 1, 0, 0, 1},
            {1, 1, 0, 0, 1},
            {1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1},
            {1, 0, 0, 1, 1},
            {1, 0, 0, 1, 1},
            {1, 0, 0, 0, 1}
    };

    int[][] o = {
            {0, 1, 1, 1, 0},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {0, 1, 1, 1, 0}
    };

    int[][] p = {
            {1, 1, 1, 1, 0},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 1, 1, 1, 0},
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0}
    };

    int[][] q = {
            {0, 1, 1, 1, 0},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 1, 0, 1},
            {1, 0, 0, 1, 0},
            {0, 1, 1, 0, 1}
    };

    int[][] r = {
            {1, 1, 1, 1, 0},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 1, 1, 1, 0},
            {1, 0, 1, 0, 0},
            {1, 0, 0, 1, 0},
            {1, 0, 0, 0, 1}
    };

    int[][] s = {
            {0, 1, 1, 1, 0},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 0},
            {0, 1, 1, 1, 0},
            {0, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {0, 1, 1, 1, 0}
    };

    int[][] t = {
            {1, 1, 1, 1, 1},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0}
    };

    int[][] u = {
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {0, 1, 1, 1, 0}
    };


    int[][] v = {
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0}
    };

    int[][] w = {
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 1, 0, 1},
            {1, 1, 0, 1, 1},
            {1, 0, 0, 0, 1}
    };

    int[][] x = {
            {1, 0, 0, 0, 1},
            {1, 0, 0, 1, 1},
            {0, 1, 0, 1, 0},
            {0, 1, 1, 1, 0},
            {0, 1, 1, 1, 0},
            {0, 1, 0, 1, 0},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1}
    };

    int[][] y = {
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {0, 1, 0, 1, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0}
    };

    int[][] z = {
            {1, 1, 1, 1, 1},
            {0, 0, 0, 1, 1},
            {0, 0, 0, 1, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 1, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {1, 1, 1, 1, 1}
    };

    int[][] smiles = {
            {0, 0, 1, 1, 1, 1, 0, 0},
            {0, 1, 0, 0, 0, 0, 1, 0},
            {1, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 0, 1, 1, 0, 0, 1},
            {0, 1, 0, 0, 0, 0, 1, 0},
            {0, 0, 1, 1, 1, 1, 0, 0}
    };

    int[][] aliens = {
            {1, 0, 0, 0, 0, 0, 0, 1},
            {0, 1, 1, 1, 1, 1, 1, 0},
            {1, 1, 0, 1, 1, 0, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {0, 1, 0, 0, 0, 0, 1, 0},
            {0, 0, 1, 1, 1, 1, 0, 0},
            {1, 1, 0, 0, 0, 0, 1, 1},
            {1, 1, 0, 0, 0, 0, 1, 1}
    };
    int[][] quote = {
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0, 1, 1, 1},
            {0, 1, 1, 1, 0, 1, 1, 1},
            {0, 1, 1, 1, 0, 1, 1, 1},
            {0, 0, 1, 1, 0, 0, 1, 1},
            {0, 1, 1, 0, 0, 1, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0}
    };

    int[][] clock = {
            {0, 0, 0, 1, 1, 1, 0, 0},
            {0, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 1, 0, 0, 1},
            {0, 1, 0, 0, 1, 1, 0, 1},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 1, 0, 0, 0, 1, 0},
            {0, 0, 0, 1, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0}
    };

    int[][] sinWave = {
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 1, 0, 0},
            {1, 0, 0, 1, 0, 0, 1, 0},
            {1, 0, 0, 1, 0, 0, 1, 0},
            {0, 1, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0}
    };

    int[][] free = {
            {0, 1, 1, 1, 1, 1, 0, 0},
            {0, 1, 1, 1, 1, 1, 0, 0},
            {0, 1, 1, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 1, 0, 0},
            {0, 1, 1, 1, 1, 1, 0, 0},
            {0, 1, 1, 0, 0, 0, 0, 0},
            {0, 1, 1, 0, 0, 0, 0, 0},
            {0, 1, 1, 0, 0, 0, 0, 0}
    };

    int[][] arrow = {
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 1, 1, 0, 0, 0, 0},
            {0, 1, 1, 1, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {0, 1, 1, 1, 0, 0, 0, 0},
            {0, 0, 1, 1, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0}
    };




    int[][] ghost = {
            {0, 0, 1, 1, 1, 0, 0, 0},
            {0, 1, 1, 1, 1, 1, 0, 0},
            {1, 0, 1, 1, 0, 1, 1, 0},
            {1, 0, 0, 1, 0, 0, 1, 0},
            {1, 1, 1, 1, 1, 1, 1, 0},
            {1, 1, 0, 0, 0, 1, 1, 0},
            {1, 1, 1, 1, 1, 1, 1, 0},
            {1, 0, 1, 0, 1, 0, 1, 0}
    };

    int[][] blankArray={
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0}
    };

    int[][] arrowStart={
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,1 ,0 ,0 ,0 ,0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,1 ,1 ,0 ,0 ,0 ,0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,1 ,1 ,1 ,0 ,0 ,0 ,0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0 ,0 ,0 ,0 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0 ,0 ,0 ,0 ,1 ,1 ,1 ,1 ,1 ,1 ,1 ,1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,1 ,1 ,1 ,0 ,0 ,0 ,0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,1 ,1 ,0 ,0 ,0 ,0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,1 ,0 ,0 ,0 ,0}
    };

    int[][] smilesStart = {
            {0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0,0, 0, 1, 1, 1, 1, 0, 0, 0,0,0,0,0, 0, 1, 1, 1, 1, 0, 0},
            {0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0,0, 1, 0, 0, 0, 0, 1, 0, 0,0,0,0,0, 1, 0, 0, 0, 0, 1, 0},
            {1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0,1, 0, 1, 0, 0, 1, 0, 1, 0,0,0,0,1, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0,1, 0, 0, 0, 0, 0, 0, 1, 0,0,0,0,1, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0,1, 0, 1, 0, 0, 1, 0, 1, 0,0,0,0,1, 0, 1, 0, 0, 1, 0, 1 },
            {1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0,1, 0, 0, 1, 1, 0, 0, 1, 0,0,0,0,1, 0, 0, 1, 1, 0, 0, 1},
            {0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0,0, 1, 0, 0, 0, 0, 1, 0, 0,0,0,0,0, 1, 0, 0, 0, 0, 1, 0},
            {0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0,0, 0, 1, 1, 1, 1, 0, 0, 0,0,0,0,0, 0, 1, 1, 1, 1, 0, 0}
    };

    int[][] midSmile = {
            {0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0,0, 0, 1, 1, 1, 1, 0, 0, 0,0,0,0,0, 0, 1, 1, 1, 1, 0, 0},
            {0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0,0, 1, 0, 0, 0, 0, 1, 0, 0,0,0,0,0, 1, 0, 0, 0, 0, 1, 0},
            {1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0,1, 0, 1, 0, 0, 1, 0, 1, 0,0,0,0,1, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0,1, 0, 0, 0, 0, 0, 0, 1, 0,0,0,0,1, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0,1, 0, 0, 0, 0, 0, 0, 1, 0,0,0,0,1, 0, 0, 0, 0, 0, 0, 1 },
            {1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0,1, 0, 1, 1, 1, 1, 0, 1, 0,0,0,0,1, 0, 1, 1, 1, 1, 0, 1},
            {0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0,0, 1, 0, 0, 0, 0, 1, 0, 0,0,0,0,0, 1, 0, 0, 0, 0, 1, 0},
            {0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0,0, 0, 1, 1, 1, 1, 0, 0, 0,0,0,0,0, 0, 1, 1, 1, 1, 0, 0}
    };

    int[][] frownSmile = {
            {0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0,0, 0, 1, 1, 1, 1, 0, 0, 0,0,0,0,0, 0, 1, 1, 1, 1, 0, 0},
            {0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0,0, 1, 0, 0, 0, 0, 1, 0, 0,0,0,0,0, 1, 0, 0, 0, 0, 1, 0},
            {1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0,1, 0, 1, 0, 0, 1, 0, 1, 0,0,0,0,1, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0,1, 0, 0, 0, 0, 0, 0, 1, 0,0,0,0,1, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0,1, 0, 0, 1, 1, 0, 0, 1, 0,0,0,0,1, 0, 0, 1, 1, 0, 0, 1 },
            {1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0,1, 0, 1, 0, 0, 1, 0, 1, 0,0,0,0,1, 0, 1, 0, 0, 1, 0, 1},
            {0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0,0, 1, 0, 0, 0, 0, 1, 0, 0,0,0,0,0, 1, 0, 0, 0, 0, 1, 0},
            {0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0,0, 0, 1, 1, 1, 1, 0, 0, 0,0,0,0,0, 0, 1, 1, 1, 1, 0, 0}
    };

    int[][] sinwaveStart={
            {0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 ,1 ,1 ,1 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0},
            {0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,1 ,0 ,0 ,0 ,1 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0},
            {0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 ,0 ,0 ,0 ,0 ,0 ,1 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0},
            {1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0 ,0 ,0 ,0 ,0 ,0 ,0 ,1 ,0 ,0 ,0 ,0 ,0 ,0 ,0},
            {1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0 ,0 ,0 ,0 ,0 ,0 ,0 ,1 ,0 ,0 ,0 ,0 ,0 ,0 ,0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,1 ,0 ,0 ,0 ,0 ,0 ,1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,1 ,0 ,0 ,0 ,1 ,0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,1 ,1 ,1 ,0 ,0}
    };

    int[][] alienStart={
            {0, 0, 0, 0, 0, 0, 0, 0,1, 0, 0, 0, 0, 0, 0, 1,0, 0, 0, 0, 0, 0, 0, 0,1, 0, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 0, 0,0, 1, 1, 1, 1, 1, 1, 0,0, 0, 0, 0, 0, 0, 0, 0,0, 1, 1, 1, 1, 1, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0,1, 1, 0, 1, 1, 0, 1, 1,0, 0, 0, 0, 0, 0, 0, 0,1, 1, 0, 1, 1, 0, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 0,1, 1, 1, 1, 1, 1, 1, 1,0, 0, 0, 0, 0, 0, 0, 0,1, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 0,0, 1, 0, 0, 0, 0, 1, 0,0, 0, 0, 0, 0, 0, 0, 0,0, 1, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0,0, 0, 1, 1, 1, 1, 0, 0,0, 0, 0, 0, 0, 0, 0, 0,0, 0, 1, 1, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0,1, 1, 0, 0, 0, 0, 1, 1,0, 0, 0, 0, 0, 0, 0, 0,1, 1, 0, 0, 0, 0, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 0,1, 1, 0, 0, 0, 0, 1, 1,0, 0, 0, 0, 0, 0, 0, 0,1, 1, 0, 0, 0, 0, 1, 1}
    };

    int[][] pacManStart={
        {0, 0, 1, 1, 1, 0, 0, 0,0, 0, 1, 1, 1, 0, 0, 0,0, 0, 1, 1, 1, 0, 0, 0,0,0,0,0,0,0,0,0},
        {0, 1, 1, 1, 1, 1, 0, 0,0, 1, 1, 1, 1, 1, 0, 0,0, 1, 1, 1, 1, 1, 0, 0,0,0,1,1,1,0,0,0},
        {1, 0, 1, 1, 0, 1, 1, 0,1, 0, 1, 1, 0, 1, 1, 0,1, 0, 1, 1, 0, 1, 1, 0,0,1,1,1,1,1,0,0},
        {1, 0, 0, 1, 0, 0, 1, 0,1, 0, 0, 1, 0, 0, 1, 0,1, 0, 0, 1, 0, 0, 1, 0,0,0,1,1,1,1,1,0},
        {1, 1, 1, 1, 1, 1, 1, 0,1, 1, 1, 1, 1, 1, 1, 0,1, 1, 1, 1, 1, 1, 1, 0,0,0,0,1,1,1,1,0},
        {1, 1, 0, 0, 0, 1, 1, 0,1, 1, 0, 0, 0, 1, 1, 0,1, 1, 0, 0, 0, 1, 1, 0,0,0,1,1,1,1,1,0},
        {1, 1, 1, 1, 1, 1, 1, 0,1, 1, 1, 1, 1, 1, 1, 0,1, 1, 1, 1, 1, 1, 1, 0,0,1,1,1,1,1,0,0},
        {1, 0, 1, 0, 1, 0, 1, 0,1, 0, 1, 0, 1, 0, 1, 0,1, 0, 1, 0, 1, 0, 1, 0,0,0,1,1,1,0,0,0}

    };


    public LEDMatrix(int rowsI, int columnsI, float widthI, float heightI) {
        rows = rowsI;
        columns = columnsI;
        width = widthI;
        height = heightI;
        boxArray = new int[2][4];
        boxArrayPics = new int[2][4][8][8];
        setBoxArrayPics();


        int posIncrement = (int) (width) / (columns);
        distToBoxes = rows * posIncrement;
        boxHeight = (height - distToBoxes) / 2;
        boxWidth = width / 4;

        radius = posIncrement / 3;
        boxLineWidth = posIncrement / 8;


        ledArray = new int[rows][columns];
        posArrayX = new float[rows][columns];
        posArrayY = new float[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                posArrayX[i][j] = (float) (posIncrement / 2 + i * posIncrement);
                posArrayY[i][j] = (float) (posIncrement / 2 + j * posIncrement);
            }
        }

    }


public void createLetterLibrary(){
    library=" ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    libraryMatrices=new int[library.length()][8][5];
    libraryMatrices[0]=space;
    libraryMatrices[1]=a;
    libraryMatrices[2]=b;
    libraryMatrices[3]=c;
    libraryMatrices[4]=d;
    libraryMatrices[5]=e;
    libraryMatrices[6]=f;
    libraryMatrices[7]=g;
    libraryMatrices[8]=h;
    libraryMatrices[9]=i;
    libraryMatrices[10]=j;
    libraryMatrices[11]=k;
    libraryMatrices[12]=l;
    libraryMatrices[13]=m;
    libraryMatrices[14]=n;
    libraryMatrices[15]=o;
    libraryMatrices[16]=p;
    libraryMatrices[17]=q;
    libraryMatrices[18]=r;
    libraryMatrices[19]=s;
    libraryMatrices[20]=t;
    libraryMatrices[21]=u;
    libraryMatrices[22]=v;
    libraryMatrices[23]=w;
    libraryMatrices[24]=x;
    libraryMatrices[25]=y;
    libraryMatrices[26]=z;
}

public void createWordMatrix(String wordE){
    word=wordE;
    wordMatrix=new int[8][6*word.length()];

    for(int count=0;count<word.length();count++) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                wordMatrix[i][6*count+j]=libraryMatrices[library.indexOf(word.charAt(count))][i][j];
            }
        }
    }
    indexCounter=0;

}

public void createTime(int hours, int minutes){

    for(int i=0;i<8;i++){
        for(int j=0;j<32;j++){
            if(j>0 && j<6 && hours>9){
                ledArray[i][j]=returnNumber(hours/10)[i][j-1];
            } else if(j>7 && j<13){
                ledArray[i][j]=returnNumber(hours%10)[i][j-8];
            } else if(j>16 && j<22){
                ledArray[i][j]=returnNumber(minutes/10)[i][j-17];
            } else if(j>24 && j<30){
                ledArray[i][j]=returnNumber(minutes%10)[i][j-25];
            }else {
                ledArray[i][j]=blankArray[i][j];
            };
        }
    }
    ledArray[2][15]=1;
    ledArray[5][15]=1;

}


public int[][] returnNumber(int num){
    if(num==0){
        return o;
    }else if(num==1){
        return one;
    }else if(num==2){
        return two;
    }else if(num==3){
        return three;
    }else if(num==4){
        return four;
    }else if(num==5){
        return five;
    }else if(num==6){
        return six;
    }else if(num==7){
        return seven;
    }else if(num==8){
        return eight;
    }else{
        return nine;
    }
}

public void changeMode(int[] mode){
    if(mode[0]==0 && mode[1]==0){
        dateTime = Calendar.getInstance();
        hours = dateTime.get(Calendar.HOUR);
        minutes=dateTime.get(Calendar.MINUTE);
        createTime(hours, minutes);
    }

    if(mode[0]==0 && mode[1]==1){
        for(int i=0;i<8;i++){
            for(int j=0;j<32;j++){
                ledArray[i][j]=blankArray[i][j];;
            }
        }

    }

    if(mode[0]==0 && mode[1]==2){
        for(int i=0;i<8;i++){
            for(int j=0;j<32;j++){
                ledArray[i][j]=arrowStart[i][j];;
            }
        }
    }

    if(mode[0]==0 && mode[1]==3){
        for(int i=0;i<8;i++){
            for(int j=0;j<32;j++){
                ledArray[i][j]=blankArray[i][j];;
            }
        }

        if(Math.random()<.1) {
            createWordMatrix("DRILL BABY DRILL");
        }else if(Math.random()<.2){
            createWordMatrix("LIFE IS LIKE A BOX OF CHOCOLATES");
        }else if(Math.random()<.3){
            createWordMatrix("TEXAS FOREVER");
        }else if(Math.random()<.4){
            createWordMatrix("GITTER DONE");
        }else if(Math.random()<.5){
            createWordMatrix("IM ON A ROLL LIKE COTTONELLE I WAS MADE FOR ALL OF THIS SHIT");
        }else if(Math.random()<.6){
            createWordMatrix("STARTED FROM THE BOTTOM NOW WE HERE");
        }else if(Math.random()<.7){
            createWordMatrix("I BE IN THE KITCHEN COOKIN PIES WITH MY BABY");
        }else if(Math.random()<.8){
            createWordMatrix("I LET HER RIDE SHOTTY WHILE WE DOING DONUTS LIKE A KRISPY CREME");
        }else if(Math.random()<.9){
            createWordMatrix("YOUR OLD DUDE HAS THE SWAG OF A SPELLING BEE");
        }
        else{
            createWordMatrix("WE ARE OFF LIKE A HERD OF WALRUSES");
        }
    }

    if(mode[0]==1 && mode[1]==0){
        for(int i=0;i<8;i++){
            for(int j=0;j<32;j++){
                ledArray[i][j]=pacManStart[i][j];;
            }
        }
    }

    if(mode[0]==1 && mode[1]==1){
        for(int i=0;i<8;i++){
            for(int j=0;j<32;j++){
                ledArray[i][j]=sinwaveStart[i][j];;
            }
        }


    }

    if(mode[0]==1 && mode[1]==2){
        for(int i=0;i<8;i++){
            for(int j=0;j<32;j++){
                ledArray[i][j]=smilesStart[i][j];
                smileCounter=0;
            }
        }
    }

    if(mode[0]==1 && mode[1]==3){
        for(int i=0;i<8;i++){
            for(int j=0;j<32;j++){
                ledArray[i][j]=alienStart[i][j];;
            }
        }
    }
}


    public void shiftLEDArray(int[] mode){

        if((mode[0]==0 && mode[1]==0)) {
            dateTime = Calendar.getInstance();
            hours = dateTime.get(Calendar.HOUR);
            minutes=dateTime.get(Calendar.MINUTE);
            createTime(hours, minutes);
        }

        if(mode[0]==0 && mode[1]==3){
            for (int j = 0; j < 32; j++) {
                for (int i = 0; i < 8; i++) {
                    if (j == 31) {
                        if (indexCounter < word.length()*6) {
                            ledArray[i][j] = wordMatrix[i][indexCounter];
                        } else {
                            ledArray[i][j] = 0;
                        }
                    } else {
                        ledArray[i][j] = ledArray[i][j + 1];
                    }
                }
            }
            indexCounter++;
        }
        if((mode[0]==1 && mode[1]!=2) || (mode[0]==0 && mode[1]==2)){
            int[] wrapColumn = new int[8];
            for (int i = 0; i < 8; i++) {
                wrapColumn[i] = ledArray[i][0];
            }

            for (int j = 0; j < 32; j++) {
                for (int i = 0; i < 8; i++) {
                    if (j == 31) {
                        ledArray[i][j] = wrapColumn[i];
                    } else {
                        ledArray[i][j] = ledArray[i][j + 1];
                    }
                }
            }
        }
        if(mode[0]==1 && mode[1]==2){
            if(smileCounter<5){
                for(int i=0;i<8;i++) {
                    for (int j = 0; j < 32; j++) {
                        ledArray[i][j] = smilesStart[i][j];

                    }
                }
            }
            if(smileCounter>4 && smileCounter<10){
                for(int i=0;i<8;i++) {
                    for (int j = 0; j < 32; j++) {
                        ledArray[i][j] = midSmile[i][j];

                    }
                }
            }
            if(smileCounter>9 && smileCounter<15){
                for(int i=0;i<8;i++) {
                    for (int j = 0; j < 32; j++) {
                        ledArray[i][j] = frownSmile[i][j];

                    }
                }
            }
            if(smileCounter>14 && smileCounter<20){
                for(int i=0;i<8;i++) {
                    for (int j = 0; j < 32; j++) {
                        ledArray[i][j] = midSmile[i][j];

                    }
                }
            }
            if(smileCounter<20){
                smileCounter++;
            }else{
                smileCounter=0;
            }


        }
    }

    public int[] ledLocation(float x, float y){
        int[] returnPair=new int[2];
        returnPair[0]=-1;
        returnPair[1]=-1;
        for(int i=0; i<8;i++){
            for(int j=0; j<32;j++){
               if(Math.abs(posArrayX[i][j]-x)<radius && Math.abs(posArrayY[i][j]-y)<radius) {
                   returnPair[0] = i;
                   returnPair[1] = j;
               }

            }
        }
        return returnPair;

    }

    public void setBoxAreas() {
        boxArrayLimits=new int[rows][columns][4];
        for(int i=0;i<2;i++) {
            for (int j = 0; j < 4; j++) {
                float top;
                float left;
                float right;
                float bottom;
                top = getDistToBoxes() + i * getBoxHeight() + getBoxLineWidth() / 2;
                left = j * getBoxWidth() + getBoxLineWidth() / 2;
                right = (j + 1) * getBoxWidth() - getBoxLineWidth() / 2;
                bottom = getDistToBoxes() + (i + 1) * getBoxHeight() - getBoxLineWidth() / 2;
                boxArrayLimits[i][j][0]=(int) left;
                boxArrayLimits[i][j][1]=(int) top;
                boxArrayLimits[i][j][2]=(int) right;
                boxArrayLimits[i][j][3]=(int) bottom;
            }
        }
    }

    public void setBoxArrayPics(){
        for(int i=0;i<2;i++){
            for(int j=0;j<4;j++){

                if(i==0 && j==0){
                    boxArrayPics[i][j]=clock;
                }

                if(i==0 && j==1){
                    boxArrayPics[i][j]=free;
                }

                if(i==0 && j==2){
                    boxArrayPics[i][j]=arrow;
                }

                if(i==0 && j==3){
                    boxArrayPics[i][j]=quote;
                }


                if(i==1 && j==0){
                    boxArrayPics[i][j]=ghost;
                }
                if(i==1 && j==1){
                    boxArrayPics[i][j]=sinWave;
                }
                if(i==1 && j==2){
                     boxArrayPics[i][j]=smiles;
                }
                if(i==1 && j==3){
                    boxArrayPics[i][j]=aliens;
                }
            }
        }

    }

    public int[] rowColumnModeSelect(float x, float y){
        int[] rowColumn=new int[2];
        setBoxAreas();
        rowColumn[0]=5;
        rowColumn[0]=5;

        for(int i=0;i<2;i++){
            for(int j=0;j<4;j++){
                if(x>(float)(boxArrayLimits[i][j][0]) && x<(float)(boxArrayLimits[i][j][2]) && y>(float)(boxArrayLimits[i][j][1])&& y<(float)(boxArrayLimits[i][j][3])){
                    rowColumn[0]=i;
                    rowColumn[1]=j;

                }
            }
        }

        return rowColumn;


    }


    public int getboxArrayPics(int i, int j, int k, int m){
        return boxArrayPics[i][j][k][m];
    }

    public int getRows(){
        return rows;
    }

    public int getColumns(){
        return columns;
    }

    public float[][] getPosArrayX(){
        return posArrayX;
    }

    public float[][] getPosArrayY(){
        return posArrayY;
    }
    public void setLED(int i, int j,int onOff){
        ledArray[i][j]=onOff;
    }
    public int getLED(int i, int j){
        return ledArray[i][j];
    }

    public int getRadiusLED(){
        return radius;
    }

    public float getBoxHeight(){
        return boxHeight;
    }

    public float getBoxWidth(){
        return boxWidth;
    }

    public float getDistToBoxes(){
        return distToBoxes;
    }

    public void setBox(int i, int j, int onOff){
        int oldRow=0;
        int oldColumn=0;
        for(int iC=0;iC<2;iC++){
            for(int jC=0;jC<4;jC++){
                if(boxArray[iC][jC]==1){
                    oldRow=iC;
                    oldColumn=jC;
                }
                boxArray[iC][jC]=0;
            }
        }
        if(i<5) {
            boxArray[i][j] = onOff;
        }else{
            boxArray[oldRow][oldColumn]=onOff;
        }
    }

    public int getBox(int i, int j){
        return boxArray[i][j];
    }

    public float getWidth(){
        return width;
    }

    public float getHeight(){
        return height;
    }

    public float getBoxAreas(int i, int j, int k){
        return boxArrayLimits[i][j][k];
    }

    public float getBoxLineWidth(){return boxLineWidth;}

}
