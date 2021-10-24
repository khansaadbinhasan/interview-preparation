package leetcode.easy;

//[4,5,8]
//[10,9,1,8]
//2
//[1,4,2,3]
//[-4,-3,6,10,20,30]
//3
//[2,1,100,3]
//[-5,-2,10,-3,7]
//6
public class L1385FindDistBtwTwoArrs {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {

        int count = 0;

        for( int i = 0; i < arr1.length; i++ ){

            for( int j = 0; j < arr2.length; j++ ){
                if( Math.abs(arr1[i] - arr2[j]) <= d ) {
                    count--;
                    break;
                }
            }

            count++;
        }

        return count;
    }

}
