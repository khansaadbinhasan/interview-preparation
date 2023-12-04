package leetcode.medium;

import java.util.*;

//1
//2
//3
//33
//50
//10
//11
//27
public class L1641CountSortedVowelString {

    public int countVowelStrings(int n) {
        int[] vowels = new int[5];

        Arrays.fill(vowels, 1);

        for( int j = 0; j < n; j++ ){
            for( int i = vowels.length-1; i > 0; i-- ){
                vowels[i-1] = vowels[i] + vowels[i-1];
            }
        }

        return vowels[0];
    }
}
