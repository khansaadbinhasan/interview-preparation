package leetcode.medium;

import java.util.Queue;
import java.util.Stack;

//"()"
//"(*)"
//"(*))"
//"("
//")"
//"(****)**(**)**(**)**(**)*(**)**(*)(***)(**)**"
//"((*(**)**(**)**(**)*(**)*)(*)(***)(**))*"
//"(((*)()()())()()())"
public class L678ValidParanthesisString {

    public static void main(String[] args) {
        new L678ValidParanthesisString().run();
    }

    public void run(){
        System.out.println(checkValidString("(((*)()()())()()())"));
    }

    public boolean checkValidString(String s) {
        Stack<Character> st = new Stack<>();
        int left = 0;
        int star = 0;

        for( char c: s.toCharArray() ){
            if( c == '(' ) {
                st.push(c);
                left++;
            }

            else if( c == '*' ) {
                st.push(c);
                star++;
            }

            else if( c == ')' ) {
                if( st.isEmpty() ) return false;
                if( st.peek() == '(' ) {
                    st.pop();
                    left--;
                    continue;
                }
                if( st.peek() == '*' && left < star ) {
                    st.pop();
                    star--;
                    continue;
                }

                Stack<Character> starStack = new Stack<>();

                while( left > 0 && !st.isEmpty() && st.peek() == '*' ){
                    starStack.push(st.pop());
                }

                st.addAll(starStack);

                if( st.peek() == '(' ) {
                    st.pop();
                    continue;
                }
            }
        }

        Stack<Character> starStack = new Stack<>();

        while( !st.isEmpty() ){
            if( st.peek() == '(' ) {
                if( starStack.isEmpty() ) return false;
                else{
                    st.pop();
                    starStack.pop();
                }
            }
            else if( st.peek() == '*' ) {
                starStack.push('*');
                st.pop();
            }
        }

        return true;
    }

}
