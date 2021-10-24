package leetcode.easy;

//"hello world"
//"ad"
//"leet code"
//"lt"
//"leet code"
//"e"
public class L1935MaxNumberWordsType {

    public int canBeTypedWords(String text, String brokenLetters) {

        int[] brokenFreqArr = getFreqArr(brokenLetters);

        int count = 0;

        for( String word: text.split(" ") ){
            int[] freqArr = getFreqArr(word);

            if( !haveSameAlpha(freqArr, brokenFreqArr) ) count++;
        }

        return count;
    }

    public int[] getFreqArr(String s){
        int[] freqArr = new int[26];

        for( char c: s.toCharArray() ) freqArr[c-'a']++;

        return freqArr;
    }

    public boolean haveSameAlpha(int[] freqArr, int[] brokenFreqArr){

        for( int i = 0; i < freqArr.length; i++ ){
            if( freqArr[i] != 0 && brokenFreqArr[i] != 0 ) return true;
        }

        return false;

    }

}
