package codingBlocks.arrays;

import java.util.Scanner;

//7 3
//1 2 3 3 3 4 5
//9 7
//1 3 5 5 5 5 7 123 125

public class FirstAndLastOfElemInSortedRepeatedArray {
    public static void main(String[] args) {
        new FirstAndLastOfElemInSortedRepeatedArray().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int target = sc.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(getFirstAndLast(arr, target)[0] + " " + getFirstAndLast(arr, target)[1]);
    }

    public int[] getFirstAndLast(int[] arr, int target){

        int first = binarySearchFirst(arr, target);
        int second = binarySearchSecond(arr, target);

        return new int[]{first, second};
    }

    public int binarySearchFirst(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;
        int first = -1;

        while( start <= end ){
            int mid = (start+end) / 2;

            if( arr[mid] == target ) {
                first = mid;
                end = mid - 1;
            }

            if( arr[mid] > target ) end = mid-1;
            else if( arr[mid] < target ) start = mid+1;
        }

        return first;
    }

    public int binarySearchSecond(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;
        int second = -1;

        while( start <= end ){
            int mid = (start+end) / 2;

            if( arr[mid] == target ) {
                second = mid;
                start = mid + 1;
            }

            if( arr[mid] > target ) end = mid-1;
            else if( arr[mid] < target ) start = mid+1;
        }

        return second;
    }
}
