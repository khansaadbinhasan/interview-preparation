package codingBlocks.arrays;

import java.util.Scanner;

public class DiagonalTraversal {

    public static void main(String[] args) {
        new DiagonalTraversal().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();
        int[][] matrix = new int[M][N];

        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                matrix[i][j] = sc.nextInt();

        int[] diagonallyTraversedMatrix = findDiagonalOrder(matrix);

        for (int i = 0; i < M*N; i++)
            System.out.print(diagonallyTraversedMatrix[i] + " ");

        System.out.println();
    }

    public int[] findDiagonalOrder(int[][] mat) {

        int M = mat.length;
        int N = mat[0].length;

        int[] diagonallyTraversedMatrix = new int[M*N];

        int i = 0;
        int j = 0;

        int diagDirection = 1;

        for (int k = 0; k < M*N; k++) {
            diagonallyTraversedMatrix[k] = mat[i][j];

            if ( (i == 0 && diagDirection == 1) || (j == N - 1 && diagDirection == 1) ||
                    (j == 0 && diagDirection == -1)  || (i == M - 1 && diagDirection == -1) ){

                int[] iNextJNextDiagDirection = getStartCoordsAndDiagDirection(i, j, M, N, diagDirection);

                i = iNextJNextDiagDirection[0];
                j = iNextJNextDiagDirection[1];
                diagDirection = iNextJNextDiagDirection[2];
            }

            else{
                int[] nextInextJ = getNextINextJ(i, j, diagDirection);

                i = nextInextJ[0];
                j = nextInextJ[1];
            }
        }


        return diagonallyTraversedMatrix;
    }

    public int[] getStartCoordsAndDiagDirection(int iCurr, int jCurr, int M, int N, int diagDirection){

        int iNext = iCurr + 1;
        int jNext = jCurr + 1;

        if( diagDirection == -1 ){
            if( iCurr == M - 1 ) iNext = iCurr;
            else if( jCurr == 0 ) jNext = jCurr;

            diagDirection = 1;
        }

        else if( diagDirection == 1 ){
            if( jCurr == N - 1 ) jNext = jCurr;
            else if( iCurr == 0 ) iNext = iCurr;

            diagDirection = -1;
        }

        return new int[] {iNext, jNext, diagDirection};
    }

    public int[] getNextINextJ(int iCurr, int jCurr, int diagDirection){

        int iNext = iCurr - 1;
        int jNext = jCurr + 1;

        if( diagDirection == -1 ){
            iNext = iCurr + 1;
            jNext = jCurr - 1;
        }

        return new int[]{iNext, jNext};
    }


}
