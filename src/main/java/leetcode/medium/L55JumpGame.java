package leetcode.medium;

//[2,3,1,1,4]
//[3,2,1,0,4]
//[3,3,1,1,1,2,0,4]
//[1,2,3,4,5,6,7]
//[7,6,5,4,3,2,1,0,0,0,0,9]
//[100,6,5,4,3,2,1,0,0,0,0,0]
//[1]
//[0]
//[1,0,1,0]
//[4,2,0,0,1,1,4,4,4,0,4,0]
public class L55JumpGame {

    public static void main(String[] args) {
        new L55JumpGame().run();
    }

    public void run(){
        System.out.println(canJump(new int[]{4,2,0,0,1,1,4,4,4,0,4,0}));
    }

    public boolean canJump(int[] nums) {

        // [2,3,1,1,4,1,1,1,1]
        // Greedy approach and go to the maximum from given position
        int maxJ = 0;

        for( int i = 0; i < nums.length-1; i++ ){
            if( nums[i] + i >= nums.length-1 ) return true;
            if( nums[i] == 0 ) break;

            maxJ = i+1;
            for( int j = i+1; j < nums.length && j <= i+nums[i]; j++ ){
                if( nums[j] >= nums[maxJ] ){
                    maxJ = j;
                }
            }
            if( maxJ > i ) i = maxJ-1;
        }

        return nums[maxJ] + maxJ >= nums.length - 1;
    }

    public boolean canJump2(int[] nums) {

        int goal = nums.length - 1;

        for( int i = nums.length-1; i >= 0; i-- ){
            if( i + nums[i] >= goal ) goal = i;
        }

        return goal == 0;
    }
}
