package leetcode.easy;

import java.util.*;

//"leEeetcode"
//"abBAcC"
//"s"
//"mC"
public class L1544MakeStringGreat {

    public String makeGood(String s) {

        Stack<Character> stack = new Stack<>();

        int i = -1;

        while( ++i < s.length() ){

            if( !stack.isEmpty() && isNotGood(stack.peek(), s.charAt(i)) )
            {
                stack.pop();
                continue;
            }

            stack.push(s.charAt(i));
        }

        StringBuilder sb = new StringBuilder();

        for( Character c: stack ){
            sb.append(c);
        }

        return sb.toString();
    }

    public boolean isNotGood(char c1, char c2){
        return  (isSmall(c1) && isCapital(c2) && (c1-'a'+'A' == c2)) ||
                (isCapital(c1) && isSmall(c2) && (c2-'a'+'A' == c1));
    }

    public boolean isSmall(char c){
        return c >= 'a' && c <= 'z';
    }

    public boolean isCapital(char c){
        return c >= 'A' && c <= 'Z';
    }

    public String makeGood2(String s) {
        StringBuilder sb = new StringBuilder();

        sb.append(s.charAt(0));

        for(int i = 1; i < s.length(); i++){
            char curr = s.charAt(i);

            if( sb.isEmpty() ) {
                sb.append(curr);
                continue;
            }

            int endInd = sb.length()-1;
            char end = sb.charAt(endInd);
            if( curr - 'A' == end - 'a' || curr - 'a' == end - 'A' )
                sb.deleteCharAt(endInd);
            else sb.append(curr);
        }

        return sb.toString();
    }

}
