package leetcode.medium;

import java.util.*;

public class L150ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> ops = new HashSet<>(Arrays.asList("+", "-", "*", "/"));

        for( int i = 0; i < tokens.length; i++ ){
            if( ops.contains(tokens[i]) ) {
                int n1 = stack.pop();
                int n2 = stack.pop();

                if( tokens[i].equals("+") ) stack.push(n2+n1);
                else if( tokens[i].equals("-") ) stack.push(n2-n1);
                else if( tokens[i].equals("*") ) stack.push(n2*n1);
                else if( tokens[i].equals("/") ) stack.push(n2/n1);
            }

            else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }

        return stack.pop();
    }
}
