package codingBlocks.arrays;

import java.util.*;

public class MaxAbsoluteExpression {

    public static void main(String[] args) {
        new MaxAbsoluteExpression().run();
    }

    public void run() {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr1 = new int[N];
        int[] arr2 = new int[N];

        for (int i = 0; i < N; i++) arr1[i] = sc.nextInt();
        for (int i = 0; i < N; i++) arr2[i] = sc.nextInt();

        System.out.println(maxAbsValExpr(arr1, arr2));
    }

    public int maxAbsValExpr(int[] arr1, int[] arr2) {

        List<Integer> maxExprs = new ArrayList<>();

        maxExprs.add(getMaxValForExpr1(arr1, arr2));
        maxExprs.add(getMaxValForExpr2(arr1, arr2));
        maxExprs.add(getMaxValForExpr3(arr1, arr2));
        maxExprs.add(getMaxValForExpr4(arr1, arr2));

        return Collections.max(maxExprs);
    }

    public int getMaxValForExpr1(int[] arr1, int[] arr2){

        if( arr1.length == 0 || arr2.length == 0 ) return Integer.MIN_VALUE;

        int maxAi = Integer.MIN_VALUE;
        int minAj = Integer.MAX_VALUE;

        for (int i = 0; i < arr1.length; i++) {
            int expr = arr1[i] + arr2[i] + i;
            if( expr > maxAi ) maxAi = expr;
        }

        for (int j = 0; j < arr1.length; j++) {
            int expr = arr1[j] + arr2[j] + j;
            if( expr < minAj ) minAj = expr;
        }

        return maxAi - minAj;
    }

    public int getMaxValForExpr2(int[] arr1, int[] arr2){
        if( arr1.length == 0 || arr2.length == 0 ) return Integer.MIN_VALUE;

        int minAi = Integer.MAX_VALUE;
        int maxAj = Integer.MIN_VALUE;

        for (int i = 0; i < arr1.length; i++) {
            int expr = arr1[i] + arr2[i] - i;
            if( expr < minAi ) minAi = expr;
        }

        for (int j = 0; j < arr1.length; j++) {
            int expr = arr1[j] + arr2[j] - j;
            if( expr > maxAj ) maxAj = expr;
        }

        return maxAj - minAi;
    }

    public int getMaxValForExpr3(int[] arr1, int[] arr2){
        if( arr1.length == 0 || arr2.length == 0 ) return Integer.MIN_VALUE;

        int maxAi = Integer.MIN_VALUE;
        int maxAj = Integer.MIN_VALUE;

        for (int i = 0; i < arr1.length; i++) {
            int expr = -1*arr1[i] + arr2[i] + i;
            if( expr > maxAi ) maxAi = expr;
        }

        for (int j = 0; j < arr1.length; j++) {
            int expr = arr1[j] - arr2[j] - j;
            if( expr > maxAj ) maxAj = expr;
        }

        return maxAi + maxAj;
    }

    public int getMaxValForExpr4(int[] arr1, int[] arr2){
        if( arr1.length == 0 || arr2.length == 0 ) return Integer.MIN_VALUE;

        int maxAi = Integer.MIN_VALUE;
        int minAj = Integer.MAX_VALUE;

        for (int i = 0; i < arr1.length; i++) {
            int expr = arr1[i] - arr2[i] + i;
            if( expr > maxAi ) maxAi = expr;
        }

        for (int j = 0; j < arr1.length; j++) {
            int expr = arr1[j] - arr2[j] + j;
            if( expr < minAj ) minAj = expr;
        }

        return maxAi - minAj;
    }
}