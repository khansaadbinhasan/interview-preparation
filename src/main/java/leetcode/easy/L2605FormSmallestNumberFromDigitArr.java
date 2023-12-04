package leetcode.easy;

//[4,1,3]
//[5,7]
//[3,5,2,6]
//[3,1,7]
//[4,5,6]
//[1,2,3]
//[1,9,8]
//[2,7,6]
//[1]
//[2]
//[1]
//[1]
//[3]
//[1]
//[6,4,3,7,2,1,8,5]
//[6,8,5,3,1,7,4,2]
public class L2605FormSmallestNumberFromDigitArr {

    public int minNumber(int[] nums1, int[] nums2) {

        int min = 100;

        for( int i = 0; i < nums1.length; i++ ){
            for( int j = 0; j < nums2.length; j++ ){
                if( nums1[i] == nums2[j] ) min = Math.min(min, nums1[i]);
            }
        }

        if( min != 100 ) return min;

        int min1 = findMin(nums1);
        int min2 = findMin(nums2);


        if( min1 > min2 ) return min2*10+min1;

        return min1*10+min2;
    }

    public int findMin(int[] arr){
        int min = arr[0];

        for( int i = 1; i < arr.length; i++ ){
            min = Math.min(min, arr[i]);
        }

        return min;
    }
}
