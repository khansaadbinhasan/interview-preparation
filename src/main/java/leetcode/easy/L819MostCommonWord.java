package leetcode.easy;

import java.util.*;

//"Bob hit a ball, the hit BALL flew far after it was hit."
//["hit"]
//"a."
//[]
//"a"
//[]
//"a. is akdjflaksj adf?,..   "
//["a","d"]
//"T,his i,,,s,,, T,his is? a SENTENCE.,,,"
//["is"]
//"a, a, a, a, b,b,b,c, c"
//["a"]
public class L819MostCommonWord {

    public String mostCommonWord(String paragraph, String[] banned) {

        Map<String, Integer> freqMap = new HashMap<>();

        paragraph = paragraph.toLowerCase();

        for(String word: paragraph.split("!|\\?|'|,|;|\\.| ")){
            word = word.trim();

            if( word.isEmpty() ) continue;

            freqMap.putIfAbsent(word, 0);
            freqMap.put(word, freqMap.get(word)+1);
        }

        for( int i = 0; i < banned.length; i++ ){
            if( freqMap.containsKey(banned[i]) ) freqMap.remove(banned[i]);
        }

        String mostCommon = "";
        int max = 0;

        for( String key: freqMap.keySet() ){
            if( freqMap.get(key) > max ){
                max = freqMap.get(key);
                mostCommon = key;
            }
        }

        return mostCommon;
    }

    public String removeSpecialChars(String s){
        return s.replaceAll("!|\\?|'|,|;|\\.", "");
    }

}
