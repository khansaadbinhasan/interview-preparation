package leetcode.easy;

//["cat","bt","hat","tree"]
//"atach"
//["hello","world","leetcode"]
//"welldonehoneyr"
public class L1160FindWordsFormedByChars {

    public int countCharacters(String[] words, String chars) {

        int[] charFreqArr = getFreqArr(chars);

        int count = 0;

        for( String word: words ){

            int[] freqArr = getFreqArr(word);

            if( canForm(freqArr, charFreqArr) ) count += word.length();
        }

        return count;
    }

    public int[] getFreqArr(String s){

        int[] freqArr = new int[26];

        for(char c: s.toCharArray()){
            freqArr[c-'a']++;
        }

        return freqArr;
    }

    public boolean canForm(int[] arr1, int[] arr2){

        for( int i = 0; i < arr1.length; i++ ){
            if( arr2[i] < arr1[i] ) return false;
        }

        return true;
    }
}
