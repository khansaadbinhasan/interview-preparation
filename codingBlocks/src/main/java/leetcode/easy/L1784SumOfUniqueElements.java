package leetcode.easy;

//[1,2,3,2]
//[1,1,1,1,1]
//[1,2,3,4,5]
public class L1784SumOfUniqueElements {

    public int sumOfUnique(int[] nums) {

        int[] freqArr = new int[101];

        for( int i = 0; i < nums.length; i++ ){
            freqArr[nums[i]]++;
        }

        int sum = 0;

        for( int i = 1; i < freqArr.length; i++ ){
            if( freqArr[i] == 1 ) sum += i;
        }

        return sum;
    }

}
