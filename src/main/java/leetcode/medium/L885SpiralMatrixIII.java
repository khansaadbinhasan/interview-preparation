package leetcode.medium;

//3
//1
//9
//20
//11
//15
//17
//13
public class L885SpiralMatrixIII {

    public static void main(String[] args) {
        new L885SpiralMatrixIII().run();
    }

    public void run(){

        int[][] mat = generateMatrix(3);

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] generateMatrix(int n) {

        int[][] mat = new int[n][n];
        int currDir = 1;
        int num = 1;
        int k = 1;
        int i = 0;
        int j = 0;

        while( num <= n*n )
        {
            mat[i][j] = num;

            int[] ij = getNextPos(i, j, n, currDir, k/4);
            i = ij[0];
            j = ij[1];

            if( ij[2] != currDir ){
                k++;
            }

            currDir = ij[2];
            num++;
        }

        return mat;
    }

    // currDir
    //1 is right
    //2 is down
    //3 is left
    //0 is up
    public int[] getNextPos(int i, int j, int n, int currDir, int k){
        if( currDir == 1 ){
            if( j < n-1-k ){
                j++;
                return new int[]{i,j,currDir};
            }

            currDir = (currDir+1) % 4;
        }


        if( currDir == 2 ){
            if(i < n-1-k){
                i++;
                return new int[]{i,j,currDir};
            }

            currDir = (currDir+1) % 4;
        }

        if( currDir == 3 ){
            if(j > k){
                j--;
                return new int[]{i,j,currDir};
            }

            currDir = (currDir+1) % 4;
        }

        if( currDir == 0 ){
            if(i > k){
                i--;
                return new int[]{i,j,currDir};
            }
            currDir = (currDir+1) % 4;
        }

        if( currDir == 1 ){
            if( j < n-1-k ){
                j++;
                return new int[]{i,j,currDir};
            }

            currDir = (currDir+1) % 4;
        }

        return new int[]{i,j,currDir};

    }


}
