package leetcode.easy;

import java.util.*;

//["bella","label","roller"]
//["cool","lock","cook"]
//["a"]
//["these","are","some","words"]
//["r","s"]
public class L1002FindCommonCharacters {

    public List<String> commonChars(String[] words) {

        List<String> ans = new LinkedList<>();

        int[] freqArrPrev = getFreqArr(words[0]);

        for( int i = 1; i < words.length; i++ ){

            int[] freqArr = getFreqArr(words[i]);

            for( int j = 0; j < freqArr.length; j++ ){
                freqArrPrev[j] = Math.min(freqArr[j], freqArrPrev[j]);
            }
        }

        for( int i = 0; i < freqArrPrev.length; i++ ){
            while( freqArrPrev[i] > 0 ){
                ans.add(String.valueOf((char)('a'+i)));
                freqArrPrev[i]--;
            }
        }

        return ans;
    }

    public int[] getFreqArr(String s){

        int[] freqArr = new int[26];

        for(char c: s.toCharArray()){
            freqArr[c-'a']++;
        }

        return freqArr;
    }

}
