package leetcode.easy;

public class L1941CheckOccurences{

    public boolean areOccurrencesEqual(String s) {

        int[] freqArr = new int[26];

        for(char c: s.toCharArray() ){
            freqArr[c-'a']++;
        }

        int r = -1;

        for( int i = 0; i < freqArr.length; i++ ){
            if( freqArr[i] != 0 ) r = freqArr[i];
        }

        for( int i = 0; i < freqArr.length; i++ ){
            if( freqArr[i] != 0 && r != freqArr[i]) return false;
        }

        return true;

    }


}
