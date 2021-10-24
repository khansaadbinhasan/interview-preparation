package leetcode.easy;

//2
//3
//[[0,1],[1,1]]
//2
//2
//[[1,1],[0,0]]

public class L1252CellsWithOddValuesInMatrix {

    public int oddCells(int m, int n, int[][] indices) {

        int[][] arr = new int[m][n];

        for( int[] index: indices ){
            applyIncrement(arr, index[0], index[1]);
        }

        int odds = 0;

        for( int i = 0; i < arr.length; i++ ){
            for( int j = 0; j < arr[i].length; j++ ){
                if( arr[i][j] % 2 != 0 ) odds++;
            }
        }

        return odds;
    }

    public int[][] applyIncrement(int[][] arr, int row, int col){

        for( int i = 0; i < arr[row].length; i++ ){
            arr[row][i]++;
        }

        for( int i = 0; i < arr.length; i++ ){
            arr[i][col]++;
        }

        return arr;
    }


}
