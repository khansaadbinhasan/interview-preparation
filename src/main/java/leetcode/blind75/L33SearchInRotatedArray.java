package leetcode.blind75;


//[4,5,6,7,0,1,2]
//0
//[4,5,6,7,0,1,2]
//3
//[1]
//0
//[1,2,3,4,5,6,7]
//1
//[1,2,3,4,5,6]
//5
//[1,2,3,4,5,6,7]
//6
//[1,2,3,4,5,6]
//3
//[1,2,3,4,5,6]
//2
//[1,2,3,4,5,6,7]
//4
//[1,2,3,4,5,6]
//0
//[1]
//1
public class L33SearchInRotatedArray {

    public static void main(String[] args) {
        new L33SearchInRotatedArray().run();
    }

    public void run(){
        System.out.println(search3(new int[]{1}, 0));
    }

    public int search(int[] nums, int target) {

        if( nums.length == 0 ) return -1;

        int start = 0;
        int end = nums.length - 1;
        int mid;
        int N = nums.length;

        while( start <= end ){
            mid = (start + end)/2;

            if( nums[mid] == target ) return mid;

            //Case when array is not sorted
            if( nums[mid] > nums[N-1] ){
                if( nums[mid] < target ) start = mid + 1;
                else if( target > nums[N-1] ) end = mid - 1;
                else if( target < nums[0] ) start = mid + 1;
            }

            //Case when array is not sorted
            else if( nums[mid] < nums[0] ){
                if( nums[mid] > target ) end = mid - 1;
                else if( target > nums[N-1] ) end = mid - 1;
                else if( target < nums[0] ) start = mid + 1;
            }

            //When array is  sorted
            else if( nums[mid] < target ) start = mid + 1;
            else if( nums[mid] > target ) end = mid - 1;
        }

        return -1;
    }

    public int search2(int[] nums, int target) {

        int left = 0;
        int right = nums.length-1;

        while( left <= right ){
            int mid = (left+right)/2;

            if( nums[mid] < target ) left = mid+1;
            else if( nums[mid] > target ) right = mid-1;
            else return mid;
        }

        return -1;
    }

    public int search3(int[] nums, int target) {

        int l = 0;
        int r = nums.length-1;

        while( l <= r ){
            int mid = (l+r)/2;

            if( nums[mid] == target ) return mid;

            //left sorted list
            if( nums[mid] > nums[0] ) {
                if( target < nums[mid] && target >= nums[0] ) r = mid-1;
                else l = mid+1;
            }

            //right sorted list
            else {
                if( target > nums[mid] && target <= nums[nums.length-1] ) l = mid+1;
                else r = mid-1;
            }
        }

        return -1;
    }


}
