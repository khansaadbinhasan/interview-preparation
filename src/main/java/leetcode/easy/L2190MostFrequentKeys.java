package leetcode.easy;

//[1,100,200,1,100]
//1
//[2,2,2,2,3]
//2
//[1,2,1,4,1,4,1,8,9]
//1
//[1,1]
//1
//[1,1,2,1,2]
//1
public class L2190MostFrequentKeys {
    public int mostFrequent(int[] nums, int key) {

        int[] freqArr = new int[1001];

        for( int i = 0; i < nums.length-1; i++ ){
            if( nums[i] == key ){
                freqArr[nums[i+1]]++;
            }
        }

        int max = 0;
        int maxVal = -1;

        for( int i = 0; i < nums.length-1; i++ ){
            if( nums[i] == key ){
                if( freqArr[nums[i+1]] > max ){
                    maxVal = nums[i+1];
                    max = freqArr[nums[i+1]];
                }
            }
        }

        return maxVal;
    }
}
