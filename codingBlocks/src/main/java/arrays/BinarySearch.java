package arrays;

public class BinarySearch {

    public static void main(String[] args) {
        new BinarySearch().run();
    }

    public void run(){
        int[] arr = {5, 7, 9, 100, 102};
        int elem = 100;

        System.out.println(binarySearch(arr, elem));
    }

    public int binarySearch(int[] arr, int elem){
        int start = 0;
        int end = arr.length - 1;
        int mid = (end-start)/2;

        while( start <= end ){
            if( elem > arr[mid] ){
                start = mid + 1;
                mid = start + (end-start) / 2;
            }

            else if( elem < arr[mid] ){
                end = mid - 1;
                mid = end - (end-start) / 2;
            }

            else {
                return mid;
            }
        }

        return -1;
    }

}
