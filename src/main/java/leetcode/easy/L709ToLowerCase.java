package leetcode.easy;

//"Hello"
//"here"
//"LOVELY"
//"A"
//"B"
//"Z"
//"a"
//"z"
//"al&phaBET"
public class L709ToLowerCase {

    // public String toLowerCase(String s) {
    //     return s.toLowerCase();
    // }

    public String toLowerCase(String s) {

        char[] sCharArr = new char[s.length()];

        for(int i = 0; i < s.length(); i++){

            char c = s.charAt(i);

            if( c < 'a' ) c = (char)('a' + (c - 'A'));

            sCharArr[i] = c;
        }

        return String.valueOf(sCharArr);
    }

}
