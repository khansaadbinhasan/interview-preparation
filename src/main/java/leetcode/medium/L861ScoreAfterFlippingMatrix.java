package leetcode.medium;

//[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
//[[0]]
//[[0,0,1,1],[1,0,1,0],[1,1,0,0],[1,1,1,1]]
//[[1]]
//[[0,1]]
//[[0,0,0],[1,1,1]]
public class L861ScoreAfterFlippingMatrix {

    public static void main(String[] args) {
        new L861ScoreAfterFlippingMatrix().run();
    }

    public void run(){
        System.out.println(matrixScore(new int[][]{{0,0,1,1},{1,0,1,0},{1,1,0,0}}));
    }

    public int matrixScore(int[][] grid) {

        for( int i = 0; i < grid.length; i++ ){
            if( grid[i][0] == 0 ){
                flipRow(grid, i);
            }
        }

        for( int i = 0; i < grid[0].length; i++ ){
            if( shouldFlipCol(grid, i) ){
                flipCol(grid, i);
            }
        }

        int sum = 0;

        for( int i = 0; i < grid.length; i++ ){
            for( int j = 0; j < grid[i].length; j++ ){
                double val = Math.pow(2, grid[i].length-1-j) * grid[i][j];
                sum += val;
            }
        }

        return sum;
    }

    public void flipRow(int[][] grid, int row){
        for( int i = 0; i < grid[row].length; i++ ){
            grid[row][i] = (grid[row][i]+1) % 2;
        }
    }

    public void flipCol(int[][] grid, int col){
        for( int i = 0; i < grid.length; i++ ){
            grid[i][col] = (grid[i][col]+1) % 2;
        }
    }

    public boolean shouldFlipCol(int[][] grid, int col){
        int num1s = 0;

        for( int i = 0; i < grid.length; i++ ){
            if( grid[i][col] == 1 ) num1s++;
        }

        return num1s < (grid.length-num1s);
    }

}
