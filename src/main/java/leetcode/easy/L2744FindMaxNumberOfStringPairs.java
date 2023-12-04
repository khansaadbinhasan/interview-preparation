package leetcode.easy;

import java.util.*;

//["cd","ac","dc","ca","zz"]
//["ab","ba","cc"]
//["aa","ab"]
//["aa","ac"]
//["ab","ba"]
//["ab"]
public class L2744FindMaxNumberOfStringPairs {

    public int maximumNumberOfStringPairs(String[] words) {

        Map<String, Integer> freqMap = new HashMap<>();


        for( String word: words ){
            String rev = new StringBuilder(word).reverse().toString();
            if( freqMap.containsKey(rev) ){
                word = rev;
            }

            if( !freqMap.containsKey(word) ){
                freqMap.put(word, 0);
            }

            freqMap.put(word, freqMap.get(word)+1);
        }

        int count = 0;

        for( String key: freqMap.keySet() ){
            if( freqMap.get(key) == 2 ) count++;
        }

        return count;

    }
}
