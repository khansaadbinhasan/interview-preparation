package leetcode.easy;

//[[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","R",".",".",".","p"],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]
//[[".",".",".",".",".",".",".","."],[".","p","p","p","p","p",".","."],[".","p","p","B","p","p",".","."],[".","p","B","R","B","p",".","."],[".","p","p","B","p","p",".","."],[".","p","p","p","p","p",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]
//[[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","p",".",".",".","."],["p","p",".","R",".","p","B","."],[".",".",".",".",".",".",".","."],[".",".",".","B",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."]]
public class L999AvailableCapturesForRook {

    public int numRookCaptures(char[][] board) {

        int iPosRook = -1;
        int jPosRook = -1;


        for( int i = 0; i < board.length; i++ ){
            for( int j = 0; j < board[i].length; j++ ){
                if( board[i][j] == 'R' ) {
                    iPosRook = i;
                    jPosRook = j;
                }
            }
        }

        int count = 0;

        for( int j = jPosRook+1; j < board[iPosRook].length; j++ ){
            if( board[iPosRook][j] == 'B' ) break;
            if( board[iPosRook][j] == 'p' ) {
                count++;
                break;
            }
        }

        for( int j = jPosRook-1; j >= 0; j-- ){
            if( board[iPosRook][j] == 'B' ) break;
            if( board[iPosRook][j] == 'p' ) {
                count++;
                break;
            }
        }

        for( int i = iPosRook+1; i < board.length; i++ ){
            if( board[i][jPosRook] == 'B' ) break;
            if( board[i][jPosRook] == 'p' ){
                count++;
                break;
            }
        }

        for( int i = iPosRook-1; i >= 0; i-- ){
            if( board[i][jPosRook] == 'B' ) break;
            if( board[i][jPosRook] == 'p' ){
                count++;
                break;
            }
        }


        return count;
    }

}
