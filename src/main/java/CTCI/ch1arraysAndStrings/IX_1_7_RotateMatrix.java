package CTCI.ch1arraysAndStrings;

import java.util.Arrays;
import java.util.Stack;

//[[1]]
//[[1,2],[3,4]]
//[[1,2,3],[4,5,6],[7,8,9]]
//[[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//[[5,1,9,11,13],[2,4,8,10,17],[13,3,6,7,6],[15,14,12,16,8],[15,14,12,16,1]]
public class IX_1_7_RotateMatrix {

    public static void main(String[] args) {
        new IX_1_7_RotateMatrix().run();
    }

    public void run(){
//        int[][] mat = new int[][]{{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        int[][] mat = new int[][]{{1,2}, {3,4}};

        rotateMatrix(mat);

        printMatrix(mat);
    }

    public int[][] rotateMatrix(int[][] mat){

        int N = mat.length;

        for (int j = 0; j < N / 2; j++) {

            for (int i = j; i < (N-j) / 2; i++) {
//            for (int i = j; i < 1; i++) {

                Stack<int[]> st = new Stack();

                int iDash = j;
                int jDash = i;

                int currX = iDash;
                int currY = jDash;

                while( !Arrays.equals(getNext(iDash, jDash, N), new int[]{currX, currY})){

                    int[] ij = getNext(iDash, jDash, N);

                    iDash = ij[0];
                    jDash = ij[1];

                    st.push(new int[]{iDash,jDash});
                }

                int currXYVal = mat[currX][currY];


                while( !st.isEmpty() ){

                    int[] xy = st.pop();

                    mat[currX][currY] = mat[xy[0]][xy[1]];
                    mat[xy[0]][xy[1]] = currXYVal;

                    currX = xy[0];
                    currY = xy[1];

                printMatrix(mat);
                }

            }


        }


        return mat;
    }

    public int[] getNext(int x, int y, int N){
        return new int[]{y, N-x-1};
    }

    public void printMatrix(int[][] mat){
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print( mat[i][j] + " ");
            }

            System.out.println();
        }
        System.out.println();
    }

}
