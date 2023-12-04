package leetcode.easy;

//[5,3,6,1,12]
//3
//[2,7,9]
//4
//[12,5,3,6,1]
//3
//[100,200,400,800,1000]
//100
public class L2154KeepMultiplyingByTwo {

    public int findFinalValue(int[] nums, int original) {

        int[] freqArr = new int[1001];

        for( int i = 0; i < nums.length; i++ ){
            freqArr[nums[i]] = 1;
        }

        while( original < freqArr.length && freqArr[original] == 1 ){
            original = original * 2;
        }

        return original;
    }
}
