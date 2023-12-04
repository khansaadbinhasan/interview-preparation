package leetcode.medium;

import java.util.*;

//"())"
//"((("
//")"
//"("
//"()"
//")()()()()())))))))))))))))))))))))))))))))))(())"
//"(((((((((())))))))))"
//"()))(("
public class L921MinimumAddToMakeParanthesesValid {

    public int minAddToMakeValid(String s) {

        int count = 0;
        Stack<Character> stack = new Stack<>();

        for( int i = 0; i < s.length(); i++ ){
            if( s.charAt(i) == '(' ){
                stack.add('(');
            }

            else if( s.charAt(i) == ')' ){
                if( stack.isEmpty() ) count++;
                else stack.pop();
            }
        }

        return count + stack.size();
    }
}
