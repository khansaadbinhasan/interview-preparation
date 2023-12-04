package codingBlocks.arrays;

import java.util.Scanner;

//abcd a abb
//jumbo jumped jumping jump
//jumbo jumped a jumping train
//cook cooker cooking cooker
//cook cooker cooking ooker

public class LongestCommonPrefixString {

    public static void main(String[] args) {
        new LongestCommonPrefixString().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String[] strs = new String[N];

        for (int i = 0; i < N; i++)  strs[i] = sc.next();

        System.out.println(longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {

        if( strs[0].length() == 0 ) return "";

        int strLen = strs[0].length();
        String longestPrefix = "";

        for (int i = 0; i < strLen; i++) {

            char commonAlpha = strs[0].charAt(i);
            int countCommon = 0;

            for (String str : strs) {
                if (i >= str.length()) return longestPrefix;

                if (commonAlpha == str.charAt(i)) countCommon++;
            }

            if( countCommon == strs.length ) longestPrefix += String.valueOf(commonAlpha);
            else return longestPrefix;
        }

        return longestPrefix;
    }
}
