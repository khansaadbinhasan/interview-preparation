package leetcode.easy;


public class L724FindPivotIndex {

    public static void main(String[] args) {
        new L724FindPivotIndex().run();
    }

    public void run(){
        int i = pivotIndex(new int[]{-1, -1, 0, 1, 1, -1});

        System.out.println(i);
    }

    public int pivotIndex(int[] nums) {

        if( nums.length == 1 ) return 0;

        int[] leftSum = nums.clone();
        leftSum[0] = 0;
        leftSum[1] = nums[0];
        for( int i = 1; i < nums.length; i++ ){
            leftSum[i] = leftSum[i-1] + nums[i-1];
        }


        int[] rightSum = nums.clone();
        rightSum[nums.length-1] = 0;
        for( int i = nums.length-2; i >= 0; i-- ){
            rightSum[i] = rightSum[i+1] + nums[i+1];
        }

        for( int i = 0; i < nums.length; i++ ){
            if( leftSum[i] == rightSum[i] ){
                return i;
            }
        }

        return -1;
    }
}
