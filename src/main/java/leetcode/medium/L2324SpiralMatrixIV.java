package leetcode.medium;

//3
//5
//[3,0,2,6,8,1,7,9,4,2,5,5,0]
//1
//4
//[0,1,2]
//2
//2
//[1]
//1
//3
//[1,2,3]
//3
//1
//[5,6]
public class L2324SpiralMatrixIV {
     public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] mat = new int[m][n];
        int currDir = 1;
        int k = 1;
        int i = 0;
        int j = 0;
        int num = 1;

        while( head != null )
        {
            mat[i][j] = head.val;

            int[] ij = getNextPos(i, j, m, n, currDir, k/4);
            i = ij[0];
            j = ij[1];

            if( ij[2] != currDir ){
                k++;
            }

            currDir = ij[2];
            head = head.next;
            num++;
        }

        while( num <= m*n ){
            mat[i][j] = -1;

            int[] ij = getNextPos(i, j, m, n, currDir, k/4);
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
    //m rows, n cols
    public int[] getNextPos(int i, int j, int m, int n, int currDir, int k){
        if( currDir == 1 ){
            if( j < n-1-k ){
                j++;
                return new int[]{i,j,currDir};
            }

            currDir = (currDir+1) % 4;
        }


        if( currDir == 2 ){
            if(i < m-1-k){
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
