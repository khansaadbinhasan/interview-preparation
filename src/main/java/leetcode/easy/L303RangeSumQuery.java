package leetcode.easy;

//["NumArray","sumRange","sumRange","sumRange"]
//[[[-2,0,3,-5,2,-1]],[0,2],[2,5],[0,5]]
//["NumArray","sumRange","sumRange","sumRange","sumRange"]
//[[[-2,0,3,-5,2,-1]],[0,2],[2,5],[0,1],[0,3]]
public class L303RangeSumQuery {

    class NumArray {

        private int[] nums = null;

        public NumArray(int[] nums) {
            this.nums = nums;
        }

        public int sumRange(int left, int right) {

            int sum = 0;

            for( int i = left; i <= right && right < nums.length; i++ ){
                sum += nums[i];
            }

            return sum;
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
}
