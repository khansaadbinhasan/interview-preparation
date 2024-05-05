package leetcode.medium;

public class L378KthSmallestElementInSortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {

        int[] arr = matrix[0];

        for( int i = 1; i < matrix.length; i++ ){
            arr = merge(arr, matrix[i]);
        }

        return arr[k-1];
    }

    public int[] merge(int[] arr1, int[] arr2){
        int[] merged = new int[arr1.length+arr2.length];

        int p1 = 0;
        int p2 = 0;
        int p = 0;

        while( p1 < arr1.length && p2 < arr2.length ){
            if( arr1[p1] < arr2[p2] ) merged[p] = arr1[p1++];
            else merged[p] = arr2[p2++];
            p++;
        }

        while( p1 < arr1.length ){
            merged[p++] = arr1[p1++];
        }

        while( p2 < arr2.length ){
            merged[p++] = arr2[p2++];
        }

        return merged;
    }

}
