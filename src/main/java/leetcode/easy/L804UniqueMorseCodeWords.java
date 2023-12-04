package leetcode.easy;

import java.util.*;

//["gin","zen","gig","msg"]
//["a"]
//["a","b","ab","cd"]
//["abb","dd","ff"]

public class L804UniqueMorseCodeWords {

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> setWords = new HashSet<>();

        for( String word: words ){
            setWords.add(getMorseCode(word));
        }

        return setWords.size();
    }

    public String getMorseCode(String word){

        String[] morseArr = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};


        char[] alphas = word.toCharArray();

        StringBuilder sb = new StringBuilder();

        for( char alpha: alphas ){
            sb.append(morseArr[alpha - 'a']);
        }

        return sb.toString();
    }


}
