package leetcode.easy;

//[2,1]
//[3,5,5]
//[0,3,2,1]
//[0,2,3,4,5,2,1,0]
//[0,2,3,3,5,2,1,0]
//[0,2,3,4,5,2,1,7]
//[0]
//[1,2]
public class L941ValidMountainArray {

    public boolean validMountainArray(int[] arr) {

        int i = 1;
        boolean strictlyIncreasing = false;
        boolean strictlyDecreasing = false;

        while( i < arr.length && arr[i] > arr[i-1] ){
            strictlyIncreasing = true;
            i++;
        }

        while( i < arr.length && arr[i] < arr[i-1] ){
            strictlyDecreasing = true;
            i++;
        }

        return strictlyIncreasing && strictlyDecreasing && i == arr.length;

    }

}
