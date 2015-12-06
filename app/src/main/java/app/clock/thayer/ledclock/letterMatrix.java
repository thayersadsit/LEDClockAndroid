package app.clock.thayer.ledclock;

/**
 * Created by thayer on 7/19/15.
 */
public class letterMatrix {

    int[][] matrixLetter;

    public letterMatrix(String word){

        matrixLetter=new int[8][40+6*word.length()];


    }

    public String letter;

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

}