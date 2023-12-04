package leetcode.easy;

//[2,2,3,4]
//[1,2,2,3,3,3]
//[2,2,2,3,3]
//[5]
//[7,7,7,7,7,7,7]
public class L1394FindLuckyIntegersArray {

    public int findLucky(int[] arr) {

        int[] freqArr = new int[501];

        for( int i = 0; i < arr.length; i++ ){
            freqArr[arr[i]]++;
        }

        int max = -1;

        for( int i = 1; i < freqArr.length; i++ ){
            if( freqArr[i] == i ) max = Math.max(max, i);
        }

        return max;
    }

}
