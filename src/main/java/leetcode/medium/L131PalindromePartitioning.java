package leetcode.medium;

import java.util.*;

public class L131PalindromePartitioning {
    List<List<String>> palindromes = new LinkedList<>();
    public List<List<String>> partition(String s) {
        getPartitions(s, new LinkedList<>());
        return palindromes;
    }

    public void getPartitions(String s, List<String> lst){
        if( s.isEmpty() ) {
            palindromes.add(lst);
            return;
        }

        for( int i = 1; i <= s.length(); i++ ){
            String sub = s.substring(0, i);

            if( isPalindrome(sub) ){
                lst.add(sub);
                getPartitions(s.substring(i, s.length()), new LinkedList<>(lst));
                lst.remove(sub);
            }
        }
    }

    public boolean isPalindrome(String s){
        int start = 0;
        int end = s.length()-1;

        while( start < end ){
            if( s.charAt(start) != s.charAt(end) ) return false;
            start++; end--;
        }

        return true;
    }
}
