package arrays;

import java.util.*;

//5
//1 2 3 4 5
//4 3

//5
//1 2 3 4 5
//4 -1

//4
//8 90 100 1000
//2 89

//2
//0 100
//2 51

public class KClosestToX {

    public static void main(String[] args) {
        new KClosestToX().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();
        int x = sc.nextInt();

        findClosestElements(arr, k, x).forEach(elem -> System.out.print(elem + " "));
        System.out.println();
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int[] indexes = binarySearch(arr, x);

        int numElems = 0;
        int pointer1 = -1;
        int pointer2 = arr.length;

        if( indexes.length == 1 ) {
            int elemIndex = indexes[0];

            numElems++;

            pointer1 = elemIndex - 1;
            pointer2 = elemIndex + 1;
        }

        else if( indexes.length == 2 ) {
            pointer1 = indexes[1];
            pointer2 = indexes[0];
        }


        while( numElems != k ){

            if( pointer1 >= 0 ){
                if( pointer2 >= arr.length || Math.abs(arr[pointer1] - x) <= Math.abs(arr[pointer2] - x) ){
                    pointer1--;
                }

                else pointer2++;
            }

            else pointer2++;

            numElems++;
        }

        List<Integer> closestElementsList = new LinkedList<>();

        for (int i = pointer1+1; i < pointer2; i++) closestElementsList.add(arr[i]);

        return closestElementsList;
    }


    public int[] binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;

        while( start <= end ){
            int mid = (start + end) / 2;

            if( arr[mid] == target ) return new int[]{mid};

            else if( target < arr[mid] ) end = mid - 1;
            else if( target > arr[mid] ) start = mid + 1;
        }

        return new int[]{start, end};
    }

}
