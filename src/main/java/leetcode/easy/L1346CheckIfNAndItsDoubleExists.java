package leetcode.easy;

import java.util.*;

//[10,2,5,3]
//[3,1,7,11]
//[1,2]
//[-3,0,-1]
//[-3,-6]
//[1000,1000,-1000,500]
//[-1000,500]
public class L1346CheckIfNAndItsDoubleExists {

    public boolean checkIfExist(int[] arr) {

        Arrays.sort(arr);

        for( int i = 0; i < arr.length; i++ ){
            int j = Arrays.binarySearch(arr,2*arr[i]);

            //j >= 0 to check if binary search was successful
            //i!=j for case when arr[i]=0
            if( (j >= 0) && (i != j) ) return true;
        }

        return false;
    }
}
