package leetcode.medium;

import java.util.*;

//[2,1,3,0]
//[2,2,8,8,2]
//[3,7,5]
//[0,2,0,0]
public class L2094Find3DigitEvenNumbers {

    public static void main(String[] args) {
        new L2094Find3DigitEvenNumbers().run();
    }

    public void run(){
//        System.out.println(Arrays.toString(findEvenNumbers(new int[]{2, 1, 3, 0})));
        System.out.println(Arrays.toString(findEvenNumbers(new int[]{0,2,0,0})));
    }

    public int[] findEvenNumbers(int[] digits) {

        int[] digSqr = new int[digits.length*digits.length*digits.length];
        int ind = 0;
        Set<Integer> evens = new HashSet<>();

        for( int k = 0; k < digits.length; k++ ){
            if( digits[k] == 0 ) continue;
            for( int i = 0; i < digits.length; i++ ){
                if( i == k ) continue;
                for( int j = 0; j < digits.length; j++ ){
                    if( i == j || j == k ) continue;
                    digSqr[ind] = digits[k]*100 + digits[i]*10 + digits[j];
                    if( digSqr[ind] % 2 == 0 ) evens.add(digSqr[ind]);
                    ind++;
                }
            }
        }

        int[] ans = new int[evens.size()];

        int i = 0;
        for( int k: evens ){
            ans[i++] = k;
        }

        Arrays.sort(ans);

        return ans;

    }
}
