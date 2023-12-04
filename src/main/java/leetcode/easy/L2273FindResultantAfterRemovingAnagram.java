package leetcode.easy;

import java.util.*;

//["abba","baba","bbaa","cd","cd"]
//["a","b","c","d","e"]
//["a"]
//["a","a"]
//["a","b"]
//["aa","ab","ba","bb","ca","ac"]
public class L2273FindResultantAfterRemovingAnagram {
    public List<String> removeAnagrams(String[] words) {

        List<String> lst = new LinkedList<>();

        for( int i = 0; i < words.length; i++ ){
            lst.add(words[i]);
        }

        for( int i = 1; i < lst.size(); i++ ){

            int[] freqArrCurr = getFreqArr(lst.get(i));
            int[] freqArrLast = getFreqArr(lst.get(i-1));

            if( Arrays.equals(freqArrCurr, freqArrLast) ){
                lst.remove(i);
                i--;
            }
        }

        return lst;
    }

    public int[] getFreqArr(String s){
        int[] freqArr = new int[26];

        for(int i = 0; i < s.length(); i++ ){
            freqArr[s.charAt(i)-'a']++;
        }

        return freqArr;
    }
}
