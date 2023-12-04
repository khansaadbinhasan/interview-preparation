package leetcode.easy;

//[4,10,7,9]
//[6,5,2,3]
//[3,5,7,6]
//[8,10,10,2]
//[2,3]
//[4,1]
//[10,2]
//[10,1]
//[10,10]
//[1,1]
//[1]
//[1]
//[10]
//[10]
public class L2660DetermineWinner {

    public int isWinner(int[] player1, int[] player2) {

        int player1Score = getScore(player1);
        int player2Score = getScore(player2);

        if( player1Score > player2Score ) return 1;
        else if( player1Score < player2Score ) return 2;

        return 0;
    }

    public int getScore(int[] player){
        int score = player[0];

        for( int i = 1; i < player.length; i++ ){

            score += player[i];

            if( (i > 1 && (player[i-2] == 10)) || (player[i-1] == 10) ){
                score += player[i];
            }
        }

        return score;
    }
}
