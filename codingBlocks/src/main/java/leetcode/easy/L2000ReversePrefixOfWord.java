package leetcode.easy;

//"abcdefd"
//"d"
//"xyxzxe"
//"z"
//"abcd"
//"z"
//"a"
//"b"
//"a"
//"a"
//"abdef"
//"d"
//"ab"
//"a"
//"ab"
//"b"
//"aba"
//"a"
public class L2000ReversePrefixOfWord {

    public String reversePrefix(String word, char ch) {

        int end = -1;

        char[] wordArr = word.toCharArray();

        for( int i = 0; i < wordArr.length; i++ ){
            if( wordArr[i] == ch ) {
                end = i;
                break;
            }
        }

        for( int i = 0; i < end; i++, end-- ){
            char temp = wordArr[i];
            wordArr[i] = wordArr[end];
            wordArr[end] = temp;
        }

        return String.valueOf(wordArr);
    }
}
