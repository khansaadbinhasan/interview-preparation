package leetcode.easy;

//[2,5,1,3,4,7]
//3
//[1,2,3,4,4,3,2,1]
//4
//[1,1,2,2]
//2
//[1,2]
//1
public class L1470ShuffleArray {

    public int[] shuffle(int[] nums, int n) {

        int xPointer = 0;
        int yPointer = n;

        int[] ans = new int[nums.length];

        for( int i = 0; i < ans.length; i+=2 ){
            ans[i] = nums[xPointer];
            ans[i+1] = nums[yPointer];

            xPointer++;
            yPointer++;
        }

        return ans;
    }

}
