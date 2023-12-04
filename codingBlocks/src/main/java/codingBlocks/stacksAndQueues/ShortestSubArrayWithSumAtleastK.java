package codingBlocks.stacksAndQueues;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//5
//-28 81 -20 28 -29
//89


public class ShortestSubArrayWithSumAtleastK {

    public static void main(String[] args) {
        new ShortestSubArrayWithSumAtleastK().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        System.out.println(shortestSubarray(nums, k));
    }

    public int shortestSubarray(int[] nums, int k) {

        int N = nums.length;
        int[] sumK = new int[N];
        List<Integer> greaterArr = new ArrayList<>();

        sumK[0] = nums[0];

        if( sumK[0] >= k ) greaterArr.add(0);

        for (int i = 1; i < N; i++) {
            sumK[i] = nums[i] + sumK[i-1];

//            System.out.println(sumK[i]);
//
//            if( sumK[i] >= k ) greaterArr.add(i);
        }

        int lenArr = N*2;
        int p1 = 0;

        for( int p2 = 0; p2 < N; p2++ ){
            System.out.println(p2);

            int sumk = sumK[p2];
            int p1Prev = p1;

            while( sumk >= k ){
                sumk -= sumK[p1];
                p1++;
            }

            if( p1 != p1Prev ) p1--;

            if( p2 - p1 + 1 < lenArr ) lenArr = p2 - p1 + 1;

            p1 = p2 - lenArr + 1;
        }

        return lenArr;
    }


    public int shortestSubarrayOld(int[] nums, int k) {
        int p1 = 0;
        int p2 = 0;

        int sumK = nums[p1];
        int lenArr = nums.length * 2;

        while( (p1 == 0 && p2 == 0) || p2 != p1 ){

            System.out.println(p1 + " " + p2 + " " + sumK);

            if( sumK < k ){
                if( p2 < nums.length - 1) {
                    p2++;
                    sumK += nums[p2];
                }

                else if( p1 < nums.length - 1 ) {
                    sumK -= nums[p1];
                    p1++;
                }

                else break;
            }

            else if( sumK >= k ){
//                System.out.println(p1 + " " + p2 + " " + sumK);

                if( p2 - p1 + 1 < lenArr ) lenArr = p2 - p1 + 1;

                if( p1 < nums.length - 1) {
                    sumK -= nums[p1];
                    p1++;
                }
            }
        }

        if( lenArr == nums.length*2 ) lenArr = -1;

        if( p1 == p2 && p1 < nums.length && nums[p1] >= k ) lenArr = 1;

        return lenArr;
    }
}