package arrays;

//7
//3 4 5 6 0 1 2

import java.util.Scanner;

public class MinInRotatedSortedArr {

    public static void main(String[] args) {
        new MinInRotatedSortedArr().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(getMinInRotatedSortedArr(arr));
    }

    public int getMinInRotatedSortedArr(int[] arr){
        int start = 0;
        int end = arr.length-1;

        if( arr[end] > arr[start] ) return arr[start];

        while( start <= end ){
            int mid = (start + end) / 2;

            if( arr[mid] < arr[mid-1] ) return arr[mid];

            if( arr[mid] < arr[arr.length-1] ) end = mid - 1;
            else if( arr[mid] > arr[arr.length-1] ) start = mid+1;
        }

        return -1;
    }

    public int binSearch(int[] arr, int elem){
        int start = 0;
        int end = arr.length-1;

        while( start <= end ){
            int mid = (start + end) / 2;

            if( elem == arr[mid] ) return mid;

            if( arr[mid] > elem ) end = mid - 1;
            else if ( arr[mid] < elem ) start = mid + 1;
        }

        return -1;
    }
}
