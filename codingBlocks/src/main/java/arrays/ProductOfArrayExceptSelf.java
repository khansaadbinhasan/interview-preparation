package arrays;

import java.util.Arrays;
import java.util.Scanner;

//4
//1 2 3 4
//5
//-1 1 0 -3 3
//7
//-1 5 2 4 1 1 7

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        new ProductOfArrayExceptSelf().run();
    }

    public void run(){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] nums = new int[N];

        for (int i = 0; i < N; i++) nums[i] = sc.nextInt();

        int[] productExceptSelfArr = productExceptSelf(nums);

        for (int j : productExceptSelfArr) System.out.print(j + " ");

        System.out.println();
    }

    public int[] productExceptSelfWithDivision(int[] nums) {
        int[] productExceptSelfArr = new int[nums.length];

        int zeroIndex = -1;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if( nums[i] == 0 ) {
                count++;

                if( count > 1 ) return productExceptSelfArr;

                Arrays.fill(productExceptSelfArr, 0);
                zeroIndex = i;
            }
        }

        int prod = 1;

        if( count == 1 ){
            for (int i = 0; i < nums.length; i++)
                if( i != zeroIndex ) prod *= nums[i];

            productExceptSelfArr[zeroIndex] = prod;

            return productExceptSelfArr;
        }

        for (int j : nums) prod *= j;

        for (int i = 0; i < productExceptSelfArr.length; i++)
            productExceptSelfArr[i] = prod / nums[i];

        return productExceptSelfArr;
    }

    public int[] productExceptSelf(int[] nums) {
        int[] productExceptSelfArr = new int[nums.length];

        int[] numsArr1 = new int[nums.length];
        int[] numsArr2 = new int[nums.length];

        numsArr1[0] = 1;
        numsArr2[numsArr1.length-1] = 1;

        for (int i = 0; i < numsArr1.length - 1; i++)
            numsArr1[i+1] = numsArr1[i] * nums[i];

        for (int i = numsArr2.length-1; i > 0; i--)
            numsArr2[i-1] = numsArr2[i] * nums[i];

        for (int i = 0; i < nums.length; i++)
            productExceptSelfArr[i] = numsArr1[i] * numsArr2[i];

        return productExceptSelfArr;
    }


}
