package leetcode.easy;

//[1,4]
//2
//[1,2]
//2
//[1,2,3,4,5]
//3
//[1,4,6,9,10]
//3
//[1,2,3,4,5,6]
//1
//[1,2,3,4,5,6]
//5
//[1]
//1
//[1,2]
//2
public class L495TeemoAttack {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int poisonDuration = duration;

        for( int i = 1; i < timeSeries.length; i++ ){
            poisonDuration += duration;
            if( timeSeries[i] <= timeSeries[i-1]+duration-1 ){
                poisonDuration -= (timeSeries[i-1] + duration - timeSeries[i]);
            }
        }

        return poisonDuration;
    }
}
