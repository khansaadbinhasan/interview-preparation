package leetcode.medium;


import java.util.Arrays;
import java.util.Stack;

//[5,3,4,5]
//[3,7,2,3]
//[3,2]
//[5,3,4,5,3,7,1,3]
//[3,2,10,4]
public class L877StoneGame {

    public static void main(String[] args) {
        new L877StoneGame().run();
    }

    public void run(){
        System.out.println(stoneGame(new int[]{3,2,10,4}));
    }

    public boolean stoneGame(int[] piles) {
        int alice = 0;
        int bob = 0;
        int i = 0;
        int j = piles.length-1;
        boolean aliceTurn = true;

        while( i <= j ){
            if( piles[i] > piles[j] ) {
                if( aliceTurn ){
                    alice += piles[i];
                }

                else{
                    bob += piles[i];
                }

                i++;
                aliceTurn = !aliceTurn;
            }

            else {
                if( aliceTurn ){
                    alice += piles[j];
                }

                else{
                    bob += piles[j];
                }

                aliceTurn = !aliceTurn;
                j--;
            }
        }

        return alice > bob;

    }

}
