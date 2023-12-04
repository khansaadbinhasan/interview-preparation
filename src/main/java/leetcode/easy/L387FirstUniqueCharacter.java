package leetcode.easy;

import java.util.*;

public class L387FirstUniqueCharacter {
    public int firstUniqChar(String s) {

        int[] freqArr = new int[26];

        Arrays.fill(freqArr, 0);

        for(int i = 0; i < s.length(); i++){
            freqArr[s.charAt(i)-'a']++;
        }

        int minInd = -1;

        for(int i = 0; i < s.length(); i++){
            if( freqArr[s.charAt(i)-'a'] == 1 ) return i;
        }

//         for( int i = 0; i < freqArr.length; i++ ){

//         }

        return minInd;

    }

//     public int getIndexOf(String s, char c){
//         for( int i = 0; i < s.length(); i++ ){
//             if( s.charAt(i) == c ) return i;
//         }

//         return -1;
//     }
}