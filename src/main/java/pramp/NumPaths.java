package pramp;

import java.io.*;
import java.util.*;


public class NumPaths {
        int[][] mat;

        //n = 4
        //-1, -1, -1, -1
        //-1, -1, -1, -1
        //-1, -1, -1, -1
        //0, 1, -1,  1
        int numOfPathsToDest(int n) {
            mat = new int[n][n];

            for( int i = 0; i < mat.length; i++ )
                Arrays.fill(mat[i], -1);

            mat[0][0] = 1;

            return numPaths(n-1,n-1);
        }

        //1, 0, 4
        int numPaths(int i, int j){
            if( mat[i][j] != -1 ) return mat[i][j];

            int numPath = 0;

            if( i - 1 >= 0 && i - 1 >= j ){
                numPath = numPaths(i-1, j);
            }

            if( j - 1 >= 0 && i >= j-1 ){
                numPath += numPaths(i, j-1);
            }

            return mat[i][j] = numPath;
        }

        public static void main(String[] args) {
            new NumPaths().run();
        }

        public void run() {
            System.out.println(numOfPathsToDest(4));
        }

    }

//The car must abide by the following two rules:
//it cannot cross the diagonal border. In other words, in every step the position (i,j) needs to maintain i >= j.
//See the illustration above for n = 5. In every step, it may go one square North (up), or one square East (right), but not both. E.g. if the car is at (3,1), it may go to (3,2) or (4,1).

//(4,4)
//(3,4), [(4,3)]
//right i --> i + 1
//up j --> j+1
//i >= j
//i, j --> (i-1,j) given that i-1 >= j
//and (i+1,j) given that i-1 >= j
//numPath +=
//base condition --> dest --> n,n --> 1
//number of path at start --> 0,0 --> result
//(0,0) --> 1
//(i,j) --> (i+1,j) + (i,j+1)