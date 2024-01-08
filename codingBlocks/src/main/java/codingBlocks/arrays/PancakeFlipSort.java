package codingBlocks.arrays;

//3 2 4 1
//3 2 1 4 5

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PancakeFlipSort {

    public static void main(String[] args) {
        new PancakeFlipSort().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        List<List<Integer>> ansArr = new ArrayList<>();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int[] arr = new int[N];

            for (int j = 0; j < N; j++) {
                arr[j] = sc.nextInt();
            }

            ansArr.add(pancakeSort(arr));
        }

        for (List<Integer> ans: ansArr){
            for (int elem : ans) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }

    public List<Integer> pancakeSort(int[] arr) {



        List<Integer> ansList = new ArrayList<>();



        if( arr.length == 0 ) return new ArrayList<>();

        int desiredIndex = arr.length - 1;

        while( desiredIndex != 0 ){

            int maxInd = getMaxInd(arr, desiredIndex);

            if( desiredIndex == maxInd ) {
                desiredIndex--;
                continue;
            }

            ansList.add(maxInd+1);
            ansList.add(desiredIndex+1);

            flip(arr, maxInd+1);
            flip(arr, desiredIndex+1);

            desiredIndex--;
        }

        return ansList;
    }

    public int getMaxInd(int[] arr, int desiredIndex){
        int maxInd = 0;

        for (int i = 1; i <= desiredIndex; i++) {
            if( arr[i] > arr[maxInd] ) maxInd = i;
        }

        return maxInd;
    }

    public void flip(int[] arr, int k){
        for (int i = 0; i < k / 2; i++) {
            swap(arr, i, k - i - 1);
        }
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
