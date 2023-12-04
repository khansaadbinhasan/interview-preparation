package leetcode.easy;

import java.util.*;

//"ab#c"
//"ad#c"
//"ab##"
//"c#d#"
//"a##c"
//"#a#c"
//"a#c"
//"b"
public class L844BackSpaceStringCOmpare {

    public boolean backspaceCompare(String s, String t) {
        return getStack(s).equals(getStack(t));
    }

    public Stack<Character> getStack(String s){

        Stack<Character> stack = new Stack<>();

        for( char c: s.toCharArray() ){

            if( stack.isEmpty() && c == '#' ) continue;
            if( c == '#' ) {
                stack.pop();
                continue;
            }

            stack.push(c);
        }

        return stack;
    }


}
