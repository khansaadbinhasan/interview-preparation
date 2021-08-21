package DP;

import java.util.*;

public class LongestValidParanthesis {

    public static void main(String[] args) {
        new LongestValidParanthesis().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        String inpStr = sc.next();

        System.out.println(longestValidParentheses(inpStr));
    }

    public int longestValidParentheses(String s) {

        int curr = 0;
        int ans = 0;

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char cc = s.charAt(i);

            if( cc == '(' ){
                st.push(curr);
                curr = 0;
            }

            else{
                if( st.isEmpty() ) curr = 0;

                else {
                    curr += st.peek() + 2;
                    st.pop();
                    ans = Math.max(ans, curr);
                }
            }
        }

        return ans;
    }

    public int longestValidParentheses2(String s) {

        if( s.length() <= 1 ) return 0;

        int[] maxParaLen = new int[s.length()];

        int maxVal = Integer.MIN_VALUE;

        for (int i = 0; i < s.length(); i++) {
            maxParaLen[i] = longestValidParanthesesFromStarting(s.substring(i));
            maxVal = Math.max(maxVal, maxParaLen[i]);
        }

        return maxVal;
    }

    public int longestValidParanthesesFromStarting(String s){

        int longestLen = 0;
        int maxLen = longestLen;

        String[] paras = s.split("");

        int ind = 0;

        int count = 0;

        while( ind < paras.length ) {

            if( paras[ind].equals(")") ){
                while( ind < paras.length && paras[ind].equals(")") && count > 0){
                    ind++;
                    count--;
                    longestLen += 2;
                }

                if( count == 0 ) maxLen = Math.max(maxLen, longestLen);

                if( ind < paras.length && paras[ind].equals(")") && count == 0 ) break;
            }

            if( ind < paras.length ) count++;

            ind++;
        }

        return maxLen;
    }
}