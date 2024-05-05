package leetcode.easy;


//1
//2
//0
//0
//2
//2
//0
//1
//2
//3
//1
//2
//1
//1
//0
//0
//5
//5
//0
//4
public class L1030MatrixCellsDistanceOrder {

    public static void main(String[] args) {
        new L1030MatrixCellsDistanceOrder().run();
    }

    public void run(){
//        int[] a = new int[]{1,2,3};
//
//        swap(a, 1,2);
//
//        for (int i = 0; i < a.length; i++) {
//            System.out.println(a[i]);
//        }

        int[][] cellsMatrix = allCellsDistOrder(2, 2, 0, 1);

        for (int i = 0; i < cellsMatrix.length; i++) {
            System.out.println(cellsMatrix[i][0] + "," + cellsMatrix[i][1]);
        }
    }

    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] mat = new int[rows][cols];
        int[][] distArr = new int[rows*cols][2];
        int[] dist = new int[rows*cols];

        for( int i = 0; i < rows; i++ ){
            for( int j = 0; j < cols; j++ ){
                int x = Math.abs(rCenter-i);
                int y = Math.abs(cCenter-j);
                int distance = x + y;

                distArr[i*cols+j] = new int[]{i,j};
                dist[i*cols+j] = distance;
            }
        }

        for( int i = 0; i < rows*cols; i++ ){
            int minI = i;
            for( int j = i+1; j < rows*cols; j++ ){
                if( dist[j] < dist[minI] ){
                    minI = j;
                }
            }

            swap( dist, i, minI );
            swap( distArr, i, minI );
        }

        return distArr;
    }

    public void swap(int[] dist, int i, int pos){
        if( i == pos ) return;

        int temp = dist[i];
        dist[i] = dist[pos];
        dist[pos] = temp;
    }

    public void swap(int[][] distArr, int i, int pos){
        if( i == pos ) return;

        int[] temp = distArr[i];
        distArr[i] = distArr[pos];
        distArr[pos] = temp;
    }
}
