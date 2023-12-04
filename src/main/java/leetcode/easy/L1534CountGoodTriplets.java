package leetcode.easy;

//[3,0,1,1,9,7]
//7
//2
//3
//[1,1,2,2,3]
//0
//0
//1
//[1,3,2,3,1,1,2,2,3,1,1,2,2,3,1,1,2,2,3,1,1,2,2,3,1,1,2,2,3,3,0,1,1,9,7,3,0,1,1,9,7,3,0,1,1,9,7,3,0,1,1,9,7,3,0,1,1,9,7,3,0,0,1,1,9,7,3,0,1,1,9,7,3,0,1,1,9,7,3,0,1,1,9,7,3,0,1,1,9,7,3,0,1,1,9,7,3,0,1,1]
//0
//0
//1

public class L1534CountGoodTriplets {

    public int countGoodTriplets(int[] arr, int a, int b, int c) {

        int n = arr.length;

        int count = 0;

        for( int i = 0; i < n-2; i++ ){
            for( int j = i+1; j < n-1; j++ ){
                for( int k = j+1; k < n; k++ ){
                    if(   Math.abs(arr[i] - arr[j]) <= a &&
                            Math.abs(arr[j] - arr[k]) <= b &&
                            Math.abs(arr[i] - arr[k]) <= c
                    ) count++;
                }
            }
        }

        return count;
    }

}
