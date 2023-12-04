package leetcode.medium;

//[["X",".",".","X"],[".",".",".","X"],[".",".",".","X"]]
//[["."]]
//[["X"]]
//[["X",".",".","X"],[".","X",".","X"],[".","X",".","X"]]
//[["X",".",".","X"],[".","X",".","X"],[".",".",".","X"],[".",".",".","X"]]
//[["X","X","X"]]
public class L419BattleshipsInABoard {

    public static void main(String[] args) {
        new L419BattleshipsInABoard().run();
    }

    public void run(){
        System.out.println(countBattleships(new char[][]{{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}}));
        System.out.println(countBattleships(new char[][]{{'X','X','X'}}));
    }

    public int countBattleships(char[][] board) {

        int count = 0;

        for( int i = 0; i < board.length; i++ ){
            for( int j = 0; j < board[i].length; j++ ){

                if( board[i][j] == 'X' ){
                    count++;
                }

                int k = i;

                while( k < board.length && (board[k][j] == 'X' || board[k][j] == 'D') ){
                    board[k][j] = 'D';
                    k++;
                }

                k = j;

                while( k < board[i].length && (board[i][k] == 'X' || board[i][k] == 'D') ){
                    board[i][k] = 'D';
                    k++;
                }

            }
        }

        return count;

    }

}
