package leetcode.easy;

import java.util.*;

//["leetcode","is","amazing","as","is"]
//["amazing","leetcode","is"]
//["b","bb","bbb"]
//["a","aa","aaa"]
//["a","ab"]
//["a","a","a","ab"]
public class L2085CountCommonOccurence {

    public int countWords(String[] words1, String[] words2) {

        Map<String, Integer> freqMap1 = freqMap(words1);
        Map<String, Integer> freqMap2 = freqMap(words2);

        int count = 0;

        for( String key: freqMap1.keySet() ){
            if( freqMap1.get(key) == freqMap2.get(key) && freqMap1.get(key) == 1){
                count++;
            }
        }

        return count;

    }

    public Map<String, Integer> freqMap(String[] words){

        Map<String, Integer> freqMap = new HashMap<>();

        for( int i = 0; i < words.length; i++ ){
            if( !freqMap.containsKey(words[i]) ){
                freqMap.put(words[i], 1);
                continue;
            }

            freqMap.put(words[i], freqMap.get(words[i])+1);
        }

        return freqMap;
    }
}
