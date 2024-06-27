package leetcode.easy;

import java.util.*;

public class L1275FindTicTacToeWinner {

//    public String tictactoe(int[][] moves) {
//
//        if( !winner(moves).equals("N") ){
//            return winner;
//        }
//
//        if( allSquaresFilled(moves) ){
//            return "Draw"
//        }
//
//        return "Pending";
//    }
//
//    //Returns winner A/B if any. Else returns N
//    public String winner(int[][] moves){
//
//        int[][] aMoves = new int[(moves.length+1) / 2][2];
//        int[][] bMoves = new int[moves.length - aMoves.length][2];
//
//        for( int i = 0; i < moves.length; i+=2 ){
//
//            for( int row = 0; row < 3; row++ ){
//                int count = 0;
//
//                for( int j = 0; j < 3; j++ ){
//                    if( aMoves[row][j] == "X" ){
//                        count++;
//                    }
//                }
//
//                if( count == 3 ) return true;
//            }
//
//            for( int col = 0; col < 3; col++ ){
//                int count = 0;
//
//                for( int j = 0; j < 3; j++ ){
//                    if( aMoves[j][col] == "X" ){
//                        count++;
//                    }
//                }
//
//                if( count == 3 ) return true;
//            }
//
//
//            count = 0;
//
//            for( int j = 0; j < 3; j++ ){
//                if( aMoves[j][col] == "X" ){
//                    count++;
//                }
//            }
//
//            if( count == 3 ) return true;
//
//        }
//
//        for( int i = 1; i < moves.length; i+=2 ){
//
//        }
//
//    }
//
//    public boolean allSquaresFilled(int[][] moves){
//        if( moves.size() == 9 ) return true;
//        return false;
//    }
//
//    public String winner(int[][] moves){
//
//        // int[][] aMoves = new int[(moves.length+1) / 2][2];
//        // int[][] bMoves = new int[moves.length - aMoves.length][2];
//
//        List<int[][]> winningMovesList = new LinkedList<>();
//
//        int[][] winningMove1 = new int[3][2]{{0,0}, {0,1}, {0,2}};
//        int[][] winningMove2 = new int[3][2]{{1,0}, {1,1}, {1,2}};
//        int[][] winningMove3 = new int[3][2]{{2,0}, {2,1}, {2,2}};
//
//        int[][] winningMove4 = new int[3][2]{{0,0}, {1,0}, {2,0}};
//        int[][] winningMove5 = new int[3][2]{{0,1}, {1,1}, {2,1}};
//        int[][] winningMove6 = new int[3][2]{{0,2}, {1,2}, {2,2}};
//
//        int[][] winningMove7 = new int[3][2]{{0,0}, {1,1}, {2,2}};
//        int[][] winningMove8 = new int[3][2]{{0,2}, {1,1}, {2,0}};
//
//        winningMovesList.add(winningMove1);
//        winningMovesList.add(winningMove2);
//        winningMovesList.add(winningMove3);
//
//        winningMovesList.add(winningMove4);
//        winningMovesList.add(winningMove5);
//        winningMovesList.add(winningMove6);
//
//        winningMovesList.add(winningMove7);
//        winningMovesList.add(winningMove8);
//
//        for( int i = 0; i < winningMovesList.size(); i++ ){
//            int count = 0;
//            for( int j = 0; j < moves.length; j+=2 ){
//                if( winningMovesList.get(i)[0][0] == moves[j][0]  ){
//
//                }
//            }
//        }
//
//
//        for( int i = 1; i < moves.length; i+=2 ){
//
//        }
//
//    }

    public String tictactoe(int[][] moves) {
        char[][] tictac = new char[3][3];
        char move = 'X';

        for( int i = 0; i < tictac.length; i++ ){
            Arrays.fill(tictac[i], '.');
        }

        for( int i = 0; i < moves.length; i++ ){
            tictac[moves[i][0]][moves[i][1]] = move;
            move = move == 'X' ? 'O': 'X';
        }

        if( isWin(tictac, 'X') ) return "A";
        if( isWin(tictac, 'O') ) return "B";
        if( moves.length != 9 ) return "Pending";

        return "Draw";

    }

    public boolean isWin(char[][] tictac, char player){
        //Search rows
        for( int i = 0; i < tictac.length; i++ ){
            if( tictac[i][0] == player && tictac[i][1] == player && tictac[i][2] == player ) return true;
        }

        //Search columns
        for( int j = 0; j < tictac[0].length; j++ ){
            if( tictac[0][j] == player && tictac[1][j] == player && tictac[2][j] == player ) return true;
        }

        //Search Diagonals
        if( tictac[0][0] == player && tictac[1][1] == player && tictac[2][2] == player ) return true;
        if( tictac[2][0] == player && tictac[1][1] == player && tictac[0][2] == player ) return true;

        return false;
    }

}
