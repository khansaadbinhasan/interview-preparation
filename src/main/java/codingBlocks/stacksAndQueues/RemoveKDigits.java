package codingBlocks.stacksAndQueues;

import java.util.Scanner;
import java.util.Stack;

//"1234567890"
//        9


public class RemoveKDigits {

    public static void main(String[] args) {
        new RemoveKDigits().run();
    }

    public void run(){

        Scanner sc = new Scanner(System.in);

        String num = sc.next();
        int k = sc.nextInt();

        System.out.println(removeKdigits(num, k));
    }

    public String removeKdigits(String num, int k) {

        Stack<Character> stack = new Stack<>();
        int j = 0;

        for( char n: num.toCharArray() ){

            while( !stack.isEmpty() && j < k && n < stack.peek() ){
                stack.pop();
                j++;
            }

            stack.push(n);
        }

        while( !stack.isEmpty() && j < k ){
            stack.pop();
            j++;
        }

        num = "";
        for( char n: stack ) num += n;

        int i = 0;
        while( i < num.length() && num.charAt(i) == '0' ) i++;

        if( stack.isEmpty() || i >= num.length() ) return "0";

        return num.substring(i);
    }


}
