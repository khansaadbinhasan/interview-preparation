package pramp;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SortKMessedArray {

    public static void main(String[] args) {
        new SortKMessedArray().run();
    }

    public void run(){
        System.out.println(Arrays.toString(sortKMessedArray(new int[]{1, 4, 5, 2, 3, 7, 8, 6, 10, 9}, 2)));
    }

    public int[] sortKMessedArray(int[] arr, int k){

        int n = arr.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i <= k; i++) {
            pq.add(arr[i]);
        }

        for (int i = k+1; i < n; i++) {
            arr[i-k-1] = pq.poll();
            pq.add(arr[i]);
        }

        for (int i = n-k-1; i < n; i++) {
            arr[i] = pq.poll();
        }

        return arr;
    }

}
