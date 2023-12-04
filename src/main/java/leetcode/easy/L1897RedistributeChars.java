package leetcode.easy;


//["abc","aabc","bc"]
//["ab","a"]
//["a","a"]
//["ab", "ba", "a", "b"]
//["a", "b", "a", "b"]
//["abcd", "dcba"]
//["a", "b"]
public class L1897RedistributeChars {

    public boolean makeEqual(String[] words) {

        int[] freqArr = new int[26];

        for( String word: words ){
            for( int i = 0; i < word.length(); i++ ){
                freqArr[word.charAt(i)-'a']++;
            }
        }

        for( int i = 0; i < freqArr.length; i++ ){
            if( freqArr[i] % words.length != 0 ) return false;
        }

        return true;
    }
}
