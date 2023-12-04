package leetcode.easy;

//["abc","car","ada","racecar","cool"]
//["notapalindrome","racecar"]
//["def","ghi"]
public class L2108FirstPalindromicString {

    public String firstPalindrome(String[] words) {

        for( String word: words ){
            if( isPalindrome(word) ) return word;
        }

        return "";
    }

    public boolean isPalindrome(String word){

        for( int i = 0; i < word.length() / 2; i++ ){
            if( word.charAt(i) != word.charAt(word.length()-i-1) ){
                return false;
            }
        }

        return true;

    }
}
