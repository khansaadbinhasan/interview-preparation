package CTCI.ch10SortingAndSearching;

public class Q3SearchInRotatedArray {

    public int search(int[] nums, int target) {

        int start = 0;//3
        int end = nums.length-1;//3

        while( start <= end ){
            int mid = (start+end)/2;//3

            System.out.println(mid);

            if( nums[mid] == target ) return mid;

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

        return -1;
    }

    public static int search(int a[], int left, int right, int x) {
        int mid = (left + right) / 2;
        if (x == a[mid]) { // Found element
            return mid;
        }
        if (right < left) {
            return -1;
        }

        /* While there may be an inflection point due to the rotation, either the left or
         * right half must be normally ordered.  We can look at the normally ordered half
         * to make a determination as to which half we should search.
         */
        if (a[left] < a[mid]) { // Left is normally ordered.
            if (x >= a[left] && x < a[mid]) {
                return search(a, left, mid - 1, x);
            } else {
                return search(a, mid + 1, right, x);
            }
        } else if (a[mid] < a[right]) { // Right is normally ordered.
            if (x > a[mid] && x <= a[right]) {
                return search(a, mid + 1, right, x);
            } else {
                return search(a, left, mid - 1, x);
            }
        } else if (a[left] == a[mid]) { // Left is either all repeats OR loops around (with the right half being all dups)
            if (a[mid] != a[right]) { // If right half is different, search there
                return search(a, mid + 1, right, x);
            } else { // Else, we have to search both halves
                int result = search(a, left, mid - 1, x);
                if (result == -1) {
                    return search(a, mid + 1, right, x);
                } else {
                    return result;
                }
            }
        }
        return -1;
    }

    public boolean search2(int[] nums, int target) {
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

}
