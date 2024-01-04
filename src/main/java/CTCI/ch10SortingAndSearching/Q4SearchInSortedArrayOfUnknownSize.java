package CTCI.ch10SortingAndSearching;

public class Q4SearchInSortedArrayOfUnknownSize {

    public static void main(String[] args) {
        System.out.println("ab".compareTo("ac"));
        System.out.println("ab".compareTo("ab"));
        System.out.println("ac".compareTo("ab"));
    }

    public int searchInSortedArrayOfUnknownSize(int[] nums, int target){

        int end = -1;




        return binSearch(nums, target, end);
    }

    public int binSearch(int[] nums, int target, int end){
        int start = 0;

        while( start <= end ){
            int mid = (start+end) / 2;

            if( nums[mid] == target ) return mid;

            if( target < nums[mid] ) end = mid-1;
            else start = mid+1;
        }
        return -1;
    }

}
