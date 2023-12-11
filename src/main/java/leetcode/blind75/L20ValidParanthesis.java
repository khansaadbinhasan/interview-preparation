package leetcode.blind75;

import java.util.Stack;

public class L20ValidParanthesis {

    public boolean isValid(String s) {

        Stack<Character> st = new Stack<>();

        for( int i = 0; i < s.length(); i++ ){

            while( !st.isEmpty() && i < s.length() && (s.charAt(i) == getOpposite(st.peek())) ){
                st.pop();
                i++;
            }

            if( i < s.length() ) st.push(s.charAt(i));
        }

        return st.isEmpty();
    }

    public char getOpposite(char para){
        if( para == '(' ) return ')';
        else if( para == '{' ) return '}';
        else if( para == '[') return ']';

        return '_';
    }

}
