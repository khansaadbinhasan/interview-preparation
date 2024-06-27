package leetcode.easy;


//[1,2,2,1]
//1
//[1,3]
//3
//[3,2,1,5,4]
//2
public class L2006CountPairsWithDiffK {

    public static void main(String[] args) {
        new L2006CountPairsWithDiffK().run();
    }

    public void run(){

    }

    public int countKDifference(int[] nums, int k) {

        int count = 0;

        for(int i = 0; i < nums.length; i++ ){
            for(int j = 0; j < nums.length; j++ ){
                if( (nums[i]-nums[j] == k) ) count++;
            }

        }

        return count;

    }
}


