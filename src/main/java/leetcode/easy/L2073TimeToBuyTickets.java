package leetcode.easy;

//[2,3,2]
//2
//[5,1,1,1]
//0
//[2,3,2]
//2
//[5,1,1,1]
//0
//[100,1,12,100,99,18,19]
//0
//[100,100,100,100,100,100]
//5
//[1,1,1,1,1,1]
//5
public class L2073TimeToBuyTickets {

    public int timeRequiredToBuy(int[] tickets, int k) {

        int time = 0;

        while( tickets[k] > 0 ){
            for( int i = 0; i < tickets.length; i++ ){
                if( tickets[i] != 0 ) {
                    tickets[i]--;
                    time++;

                    if( tickets[k] == 0 ) break;
                }
            }
        }

        return time;
    }
}
