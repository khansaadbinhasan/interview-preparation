package leetcode.easy;

//"Let's take LeetCode contest"
//"God Ding"
//"a"
//"this is a sentence"
//"a"
//"this s sis sis sdfksajdgkfhadskgh asdlfkhaskdfh dshifdshk"
public class L557ReverseWordsInStringIII {

    public String reverseWords(String s) {

        String[] words = s.split(" ");

        String ans = "";


        for( String word: words ){
            ans += reverse(word) + " ";
        }

        return ans.trim();

    }

    public String reverse(String word) {

        int end = word.length()-1;

        char[] wordArr = word.toCharArray();

        for( int i = 0; i < end; i++, end-- ){
            char temp = wordArr[i];
            wordArr[i] = wordArr[end];
            wordArr[end] = temp;
        }

        return String.valueOf(wordArr);
    }

}
