package leetcode.easy;

import java.util.*;

//"ab"
//["ad","bd","aaab","baa","badab"]
//"abc"
//["a","b","c","ab","ac","bc","abc"]
//"cad"
//["cc","acd","b","ba","bac","bad","ac","d"]
public class L1684CountNumberOfConsistentString {
    public int countConsistentStrings(String allowed, String[] words) {

        Set<String> allowedSet = new HashSet<>(Arrays.asList(allowed.split("")));

        int count = 0;

        for( String word: words ){
            for( String alpha: word.split("")) {
                if( !allowedSet.contains(alpha) ) {
                    count--;
                    break;
                }
            }

            count++;
        }

        return count;
    }
}