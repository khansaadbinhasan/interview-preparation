package leetcode.easy;

//[1,4,2,5,3]
//[1,2]
//[10,11,12]
//[1]
//[100]
//[1,2,3,4,5,6,7,8]
//[1,2,4,5]

public class L1588SumOfOddSubArrs {

    public int sumOddLengthSubarrays(int[] arr) {

        int sum = 0;

        int oddNums = arr.length % 2 == 0? arr.length-1: arr.length;

        while( oddNums > 0 ){
            for( int i = 0; i <= arr.length - oddNums; i++ ){
                for( int j = i; j < i + oddNums; j++ ){
                    sum += arr[j];
                }
            }

            oddNums -= 2;
        }

        return sum;
    }

}
