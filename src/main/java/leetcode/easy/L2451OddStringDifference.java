package leetcode.easy;

import java.util.*;

//["adc","wzy","abc"]
//["aaa","bob","ccc","ddd"]
//["ab","be","cd"]
//["abc","def", "ghk"]
public class L2451OddStringDifference {

    public String oddString(String[] words) {

        Map<String, Integer> freqMap = new HashMap<>();

        for( String word: words ){
            String dArr = Arrays.toString(getDiffArr(word));

            if( !freqMap.containsKey(dArr) ){
                freqMap.put(dArr, 0);
            }

            freqMap.put(dArr, freqMap.get(dArr)+1);
        }

        for( String word: words ){
            if( freqMap.get(Arrays.toString(getDiffArr(word))) == 1 ) return word;
        }

        return "";

    }

    public int[] getDiffArr(String s){
        int[] diffArr = new int[s.length()];

        for( int i = 1; i < s.length(); i++ ){
            diffArr[i] = s.charAt(i) - s.charAt(i-1);
        }

        return diffArr;
    }
}
