package leetcode.medium;

import java.util.*;

//"abccda"
//"abccba"
//"abcdbcdaadcb"
//"kadljflkadjfldakfjlk"
//"aaaaaaaaaab"
public class L3138MinLengthOfAnagramConcatenation {

    public static void main(String[] args) {
        new L3138MinLengthOfAnagramConcatenation().run();
    }

    public void run(){
        System.out.println(minAnagramLength("aaaabb"));
    }

    public int minAnagramLength(String s) {
        for( int k = 1; k <= s.length()/2; k++ ){
            if( s.length() % k != 0 ) continue;
            String s1 = s.substring(0,k);
            int isAnCount = 1;
            for( int i = k; i <= s.length()-k; i+=k ){
                String s2 = s.substring(i,i+k);
                if( !isAnagram(s1, s2) ) {
                    isAnCount = -1;
                    break;
                }
                s1 = s2;
                isAnCount++;
            }
            if( isAnCount == s.length()*1.0/k ) return k;
        }

        return s.length();
    }

    public boolean isAnagram(String s1, String s2){
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for( int i = 0; i < s1.length(); i++ ){
            freq1[s1.charAt(i)-'a']++;
            freq2[s2.charAt(i)-'a']++;
        }

        return Arrays.equals(freq1, freq2);
    }


}
