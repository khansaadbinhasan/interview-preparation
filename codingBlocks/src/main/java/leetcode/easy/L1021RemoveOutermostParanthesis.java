package leetcode.easy;

//"(()())(())"
//"(()())(())(()(()))"
//"()()"
//"()"
//"(()())"

public class L1021RemoveOutermostParanthesis {

    public String removeOuterParentheses(String s) {

        char[] sCharArr = s.toCharArray();

        int numLeft = 0;
        // int numRight = 0;

        int ind = 0;

        for( int i = 0; i < sCharArr.length; i++ ){
            if( sCharArr[i] == '(' ) numLeft++;
            if( sCharArr[i] == ')' ) numLeft--;

            if( numLeft == 0 ) {
                sCharArr[ind] = ' ';
                sCharArr[i] = ' ';

                ind = i+1;
            }
        }

        return String.valueOf(sCharArr).replaceAll(" ", "");

    }


}
