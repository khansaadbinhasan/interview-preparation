package PIE.recursion;

public class BinarySearch {


    public static void main(String[] args) {
        new BinarySearch().run();
    }

    public void run(){

        int[] arr = new int[]{1,2,3,4,5, 6};

        System.out.println(binarySearch(arr, 0, arr.length, 1));

    }

    public int binarySearch( int[] arr, int start, int end, int target ){

        if( start > end || start >= arr.length || end < 0 ) return -1;

        int mid = (start+end) / 2;

        if( target < arr[mid] ) return binarySearch(arr, start, mid-1, target);
        else if( target > arr[mid] ) return binarySearch(arr, mid+1, end, target);

        return mid;
    }

}
