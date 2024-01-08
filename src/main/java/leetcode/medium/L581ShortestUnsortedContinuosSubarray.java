package leetcode.medium;

//[2,6,4,8,10,9,15]
//[1,2,3,4]
//[1]
public class L581ShortestUnsortedContinuosSubarray {

    public int findUnsortedSubarray(int[] nums) {
        //1,2,4,7,10,11,7,12,6,7,16,18,19
        int[] min = new int[nums.length];
        int[] max = new int[nums.length];

        max[0] = nums[0];
        min[nums.length-1] = nums[nums.length-1];
        for( int i = 1; i < nums.length; i++ ){
            max[i] = Math.max(nums[i], max[i-1]);
            min[nums.length-1-i] = Math.min(min[nums.length-i], nums[nums.length-1-i]);
        }

        int start = -1;
        int end = -1;

        for( int i = 0; i < min.length; i++ ){
            if( min[i] != max[i] ){
                start = i;
                break;
            }
        }

        for( int i = min.length-1; i >= 0; i-- ){
            if( min[i] != max[i] ){
                end = i;
                break;
            }
        }


        return start == end? 0: end-start+1;
    }

}
