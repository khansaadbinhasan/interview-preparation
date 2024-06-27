package leetcode.medium;

//[2,5,6,0,0,1,2]
//0
//[2,5,6,0,0,1,2]
//3
//[2,5,6,0,0,1,2]
//5
//[1,1,1,1,1,1,1,1,1,13,1,1,1,1,1,1,1,1,1,1,1,1]
//13
//[1]
//2
//[1,2,3,4,5]
//1
//[4,5,1,2,3]
//3
//[1,0,1,1,1]
//0
public class L81SearchInRotatedSortedArrayII {

    public boolean search(int[] nums, int target) {

        if( nums.length == 0 ) return false;

        int start = 0;
        int end = nums.length - 1;
        int mid;
        int N = nums.length;

        while( start <= end ){
            mid = (start + end)/2;

            if( nums[mid] == target ) return true;

            if( nums[mid] > nums[N-1] ){

                if( nums[mid] < target ){
                    start = mid + 1;
                }

                else if( target > nums[N-1] ){
                    end = mid - 1;
                }

                else if( target < nums[0] ){
                    start = mid + 1;
                }

            }

            else if( nums[mid] < nums[0] ){
                if( nums[mid] > target ){
                    end = mid - 1;
                }

                else if( target > nums[N-1] ){
                    end = mid - 1;
                }

                else if( target < nums[0] ){
                    start = mid + 1;
                }
            }

            else if( nums[mid] < target ){
                start = mid + 1;
            }

            else if( nums[mid] > target ){
                end = mid - 1;
            }

        }

        return false;
    }


    public boolean search2(int[] nums, int target) {
        int start = 0;//3
        int end = nums.length-1;//3

        while( start <= end ){
            int mid = (start+end)/2;//3
            if( nums[mid] == target ) return true;

            //Left sorted portion
            if( nums[mid] >= nums[start] ) {
                if( target < nums[mid] && target >= nums[start] ){
                    end = mid-1;
                }

                else{
                    start = mid+1;
                }
            }

            //Right sorted Portion
            else if( nums[mid] < nums[end] ){
                if( target > nums[mid] && target <= nums[end] ){
                    start = mid+1;
                }

                else{
                    end = mid-1;
                }
            }

        }

        return false;

    }

    public boolean search3(int[] nums, int target) {
        int start = 0;//3
        int end = nums.length-1;//3

        while( start <= end ){
            int mid = (end+start)/2;//3
            if( nums[mid] == target ) return true;

            //Left sorted portion
            if( nums[mid] > nums[start] ) {
                if( target < nums[mid] && target >= nums[start] ){
                    end = mid-1;
                }

                else{
                    start = mid+1;
                }
            }

            //Right sorted Portion
            else if( nums[mid] < nums[start] ){
                if( target > nums[mid] && target <= nums[end] ){
                    start = mid+1;
                }

                else{
                    end = mid-1;
                }
            }

            else{
                start++;
            }

        }

        return false;

    }

    public static void main(String[] args) {
        new L81SearchInRotatedSortedArrayII().run();
    }

    public void run(){
        System.out.println(search2(new int[]{1,0,1,1,1}, 0));
    }
}
