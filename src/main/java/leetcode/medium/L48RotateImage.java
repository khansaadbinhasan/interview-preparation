package leetcode.medium;


import java.util.Arrays;
import java.util.Stack;

//[[1]]
//[[1,2],[3,4]]
//[[1,2,3],[4,5,6],[7,8,9]]
//[[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//[[5,1,9,11,13],[2,4,8,10,17],[13,3,6,7,6],[15,14,12,16,8],[15,14,12,16,1]]
public class L48RotateImage {

    public static void main(String[] args) {
        new L48RotateImage().run();
    }

    public void run(){
        rotate2(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }

    public void rotate(int[][] mat) {
        int N = mat.length;

        for (int j = 0; j < N / 2; j++) {

            for (int i = j; i < (N-j-1); i++) {

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
                }

            }


        }

    }

    public int[] getNext(int x, int y, int N){
        return new int[]{y, N-x-1};
    }


    public void rotate2(int[][] mat) {

        int start = 0;
        int end = mat.length-1;
        int N = mat.length;

        while( start <= end ){
            for( int j = start; j < end; j++ ){
                int[] ijN = getNext(start, j, N);

                int iN = ijN[0];
                int jN = ijN[1];
                int num = mat[start][j];
                int next = mat[iN][jN];

                while( !(iN == start && jN == j) ){
                    mat[iN][jN] = num;

                    ijN = getNext(iN, jN, N);
                    iN = ijN[0];
                    jN = ijN[1];

                    num = next;
                    next = mat[iN][jN];

                    if( iN == start && jN == j ) mat[iN][jN] = num;
                }


            }

            start++;
            end--;
        }
    }

}
