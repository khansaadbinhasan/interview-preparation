package interviews.ubankSDET;//You are given a grid representing a map of a city, where `1` represents a building and `0` represents an empty lot.
// The city has a special rule that you can only build a park in a block of empty lots (`0`s) that forms a perfect square.
// Write a function to find the size of the largest possible park you can build.
//
//
//[
//
//  [1, 0, 1, 0, 0],
//
//  [1, 0, 1, 1, 1],
//
//  [1, 0, 1, 1, 1],
//
//  [1, 1, 1, 1, 1]
//
//]
//
//
//
//Output: 1

//[
//
//  [0, 0, 1, 0],
//
//  [0, 0, 1, 1],
//
//  [1, 1, 0, 0],
//
//  [1, 1, 0, 0]
//
//]
//
//
//
//Output : 2

//DFS - O(n2) --> O(n2) --> O(N4)
public class UBank {

    //check for case with 0 empty spaces and all empty spaces
    public static void main(String[] args) {
        new UBank().run();
    }

    public void run(){
        System.out.println(getMaxParkingArea(new int[][]{
                {1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1}
        }));

        System.out.println(getMaxParkingArea(new int[][]{
                {0, 0, 1, 0},
                {0, 0, 1, 1},
                {1, 1, 0, 0},
                {1, 1, 0, 0}
        }));

        System.out.println(getMaxParkingArea(new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        }));
    }

    //  [1, 0, 1, 0, 0],
    //  [1, 0, 1, 1, 1],
    //  [1, 0, 1, 1, 1],
    //  [1, 1, 1, 1, 1]
    public int getMaxParkingArea(int[][] grid){
        int maxLen = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                maxLen = Math.max(maxLen, getSquareLen(grid, i, j));
//                System.out.println(i + " " + j + " " + getSquareLen(grid, i, j));
            }
        }

        return maxLen;
    }

    public int getSquareLen(int[][] grid, int i, int j){
        if( grid[i][j] != 0 ) return 0;
        int squareLen = 0;

        for (int len = 1; len <= grid.length; len++) {
            if( !isSquare(grid, i, j, len) ) return squareLen;
            squareLen = Math.max(len, squareLen);
        }

        return squareLen;
    }

    public boolean isSquare(int[][] grid, int i, int j, int len){
        if( i+len > grid.length || j+len > grid[i].length ) return false;

        for (int k = i; k < i+len; k++) {
            for (int l = j; l < j+len; l++) {
                if( grid[k][l] == 1 ) return false;
            }
        }

        return true;
    }
}
