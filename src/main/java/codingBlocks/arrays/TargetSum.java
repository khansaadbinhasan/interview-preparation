package codingBlocks.arrays;

import java.util.*;

public class TargetSum {

    public static void main(String[] args) {
        run();
    }

    public static void run(){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = getTargetSumArray(N);

        for (int i = 0; i < N; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    private static int[] getTargetSumArray(int n) {
        int[] targetSumArr = new int[n];

        targetSumArr[0] = -1 * n / 2;

        for (int i = 1; i < n; i++) {

            if( n % 2 == 0 ){
                if( targetSumArr[i-1] + 1 == 0 ){
                    targetSumArr[i] = targetSumArr[i-1] + 2;
                    continue;
                }
            }

            targetSumArr[i] = targetSumArr[i-1] + 1;
        }

//        System.out.println(sum);

        return targetSumArr;
    }

}
