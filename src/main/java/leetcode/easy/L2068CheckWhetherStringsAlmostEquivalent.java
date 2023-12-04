package leetcode.easy;

//"aaaa"
//"bccb"
//"abcdeef"
//"abaaacc"
//"cccddabba"
//"babababab"
//"b"
//"a"
//"a"
//"a"
//"thisisarealllylongstringthatconsohtsakof"
//"thishihsfdkfhksahfkdhfkashfjakshfjkdsahf"
//"anotherverylongstringletssesstheresoulsjkdfjadlskfjkalsjforthis"
//"anotherverylonkdsljflksadjkfljdsklfksdsoulsjkdfjadlskfjkalsjfor"
public class L2068CheckWhetherStringsAlmostEquivalent {

    public boolean checkAlmostEquivalent(String word1, String word2) {

        int[] freqArr1 = freqArr(word1);
        int[] freqArr2 = freqArr(word2);

        for( int i = 0; i < 26; i++ ){
            if( Math.abs(freqArr1[i] - freqArr2[i]) > 3 ) return false;
        }

        return true;

    }

    public int[] freqArr(String word){

        int[] freqArr = new int[26];

        for( int i = 0; i < word.length(); i++ ){
            freqArr[word.charAt(i)-'a']++;
        }

        return freqArr;
    }

}
