package leetcode.easy;


//[-5,1,5,0,-7]
//[-4,-3,-2,-1,4,3,2]
//[-1]
//[1]
//[1,2,3,4,5,6,7,8,9,10]
public class L1732FindHighestAltitude {

    public int largestAltitude(int[] gain) {

        int max = 0;
        int sum = 0;

        for(int i = 0; i < gain.length; i++){
            sum += gain[i];
            max = Math.max(max, sum);
        }

        return max;
    }

}
