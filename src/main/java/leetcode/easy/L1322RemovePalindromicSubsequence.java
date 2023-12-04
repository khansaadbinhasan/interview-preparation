package leetcode.easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

//"ababa"
//"abb"
//"baabb"
//"abbbababababbabababababababbabababbbbbbbbb"
//"bbbbbbbbbbbbbaaaaaaaaaaaabbbbbbbbaaaaaa"
public class L1322RemovePalindromicSubsequence {

    public int removePalindromeSub(String s) {
        return isPalindrome(s) ? 1: 2;
    }

    public boolean isPalindrome(String s){
        for( int i = 0; i < s.length() / 2; i++ ){
            if( s.charAt(i) != s.charAt(s.length() - i - 1) ) return false;
        }

        return true;
    }
}
