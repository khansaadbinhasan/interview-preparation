package codingBlocks.stacksAndQueues;

import java.util.Scanner;
import java.util.Stack;

public class DecodeString {

    public static void main(String[] args) {
        new DecodeString().run();
    }

    public void run() {
        Scanner sc = new Scanner(System.in);

        String encodedString = sc.next();

        System.out.println(decodeString(encodedString));
    }

    public String decodeString(String s) {

        String decodedString = "";
        Stack<Object[]> stack = new Stack<>();
        int i = 0;

        while( i < s.length() ){

            String temp = "";
            Object[] charCodesCharsIndex = getCharCodeChars(s, i);

            int code = (int) charCodesCharsIndex[0];
            String chars = (String) charCodesCharsIndex[1];
            i = (int) charCodesCharsIndex[2];

            if( code == 1 ){
                stack.push(new Object[]{Integer.parseInt(chars), temp});
            }

            else if( code == 2 ){
                temp += chars;
            }

            while( i < s.length() && !stack.isEmpty() ){

                charCodesCharsIndex = getCharCodeChars(s, i);
                code = (int) charCodesCharsIndex[0];
                chars = (String) charCodesCharsIndex[1];
                i = (int) charCodesCharsIndex[2];

                if( code == 1 ){
                    stack.push(new Object[]{Integer.parseInt(chars), temp});
                }

                else if( code == 2 ){
                    temp += chars;
                }

                else if( code == 3 ){
                    temp = "";
                }

                else if( code == 4 ){
                    Object[] stackTop = stack.pop();

                    temp = stackTop[1] + multiplyString(temp, (int) stackTop[0]);
                }
            }

            decodedString += temp;
        }

        return decodedString;
    }

    //returns
    //1. code of char --> {1:int, 2:String, 3:"[", 4:"]"};
    //2. the chars that form the string
    //3. index of the finalChar
    //e.g, [1, "34", 1] considering that "3" is the 0th index.
    public Object[] getCharCodeChars(String s, int i){

        char[] charArr = s.toCharArray();
        String chars = "";
        int code = -1;

        while( i < s.length() && charArr[i] >= '0' && charArr[i] <= '9' ){
            code = 1;
            chars += charArr[i];
            i++;
        }

        if( i >= s.length() || code != -1 ) return new Object[]{code, chars, i};

        while( i < s.length() && charArr[i] >= 'a' && charArr[i] <= 'z' ){
            code = 2;
            chars += charArr[i];
            i++;
        }

        if( i >= s.length() || code != -1 ) return new Object[]{code, chars, i};

        if( charArr[i] == '[' ){
            code = 3;
            chars = "[";
            i++;
        }

        else if( charArr[i] == ']' ){
            code = 4;
            chars = "]";
            i++;
        }

        return new Object[]{code, chars, i};
    }

    public String multiplyString(String str, int times){
        String multipliedStr = "";
        for (int i = 0; i < times; i++) multipliedStr += str;
        return multipliedStr;
    }
}