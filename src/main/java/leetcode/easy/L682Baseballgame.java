package leetcode.easy;

import java.util.*;

//["5","2","C","D","+"]
//["5","-2","4","C","D","9","+","+"]
//["1"]
public class L682Baseballgame {

    public int calPoints(String[] ops) {

        if( ops.length == 1 ) return Integer.valueOf(ops[0]);

        int sum = 0;

        Stack<Integer> stack = new Stack<>();


        for( int i = 0; i < ops.length; i++ ){

            if( ops[i].equals("D") ) stack.push(2*stack.peek());
            else if( ops[i].equals("C") ) stack.pop();
            else if( ops[i].equals("+") ) {
                Integer s1 = stack.pop();
                Integer s2 = s1 + stack.peek();

                stack.push(s1);
                stack.push(s2);
            }

            else{
                stack.push(Integer.valueOf(ops[i]));
            }
        }


        for( int num: stack ){
            sum += num;
        }

        return sum;
    }


}
