package leetcode.medium;

//[3,4,5,1,2]
//[4,5,6,7,0,1,2]
//[11,13,15,17]
//[1,2,3,4,5]
//[4,5,1,2,3]
//[1]
//[1,2]
//[6,7,8,9,1,2,3,4,5]
public class L153FindMinInRotatedSortedArray {


    public int findMin(int[] arr) {
        int start = 0;
        int end = arr.length-1;

        if( arr.length == 1 ) return arr[0];

        while( start <= end ){
            int mid = (start + end) / 2;

            //If mid < mid+1 and mid-1 then its the min element
            if( arr[mid] < arr[(mid+1)%arr.length] && arr[mid] < arr[(arr.length+mid-1)%arr.length] ){
                return arr[mid];
            }

            //Left Sorted Portion
            if( arr[mid] >= arr[start] ){
                if( arr[start] > arr[end] ) start = mid+1;
                else end = mid-1;
            }

            //Right Sorted Portion
            else {
                if( arr[mid] < arr[(arr.length+mid-1)%arr.length] ) start = mid+1;
                else end = mid-1;
            }
        }

        return -1;
    }

}
