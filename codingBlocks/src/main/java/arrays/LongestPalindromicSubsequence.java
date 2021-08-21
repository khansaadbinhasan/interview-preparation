package arrays;

import java.util.Scanner;

public class LongestPalindromicSubsequence {

    public static void main(String[] args) {
        new LongestPalindromicSubsequence().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            String inputString = sc.next();
            System.out.println(longestPalindrome(inputString));
        }
    }

    public String longestPalindrome(String s){

        if( s.length() == 0 ) return null;

        String palindromeString = String.valueOf(s.charAt(0));
        String maxPalindromeString = String.valueOf(s.charAt(0));

        for (int i = 0; i < s.length()-1; i++) {
            palindromeString = String.valueOf(s.charAt(i));

            for (int j = i+1; j < s.length(); j++) {
                String subString = s.substring(i,j+1);
                palindromeString = maxStringPalindrome(subString, palindromeString);

                if( palindromeString.length() > maxPalindromeString.length() ){
                    maxPalindromeString = palindromeString;
                }
            }
        }

        return maxPalindromeString;
    }

    public String maxStringPalindrome(String s1, String s2){
        if( s1.length() > s2.length() )
            if( isPalindrome(s1) )
                return s1;

        return s2;
    }

    public boolean isPalindrome(String s){
        for (int i = 0; i < s.length() / 2; i++) {
            if( s.charAt(i) != s.charAt(s.length()-i-1) ){
                return false;
            }
        }

        return true;
    }

}



//    public String longestPalindrome(String s){
//
//        if( s.length() == 0 ) return null;
//
//        String[] stringArr = new String[s.length()];
//
//        for (int i = 0; i < s.length(); i++) {
//            stringArr[i] = String.valueOf(s.charAt(i));
//        }
//
//        String longerPalindrome = stringArr[0];
//        String longestPalindrome = stringArr[0];
//
//        for (int i = 1; i < s.length(); i++) {
//            longerPalindrome = maxStringPalindrome(stringArr[i] + stringArr[i-1], stringArr[i]);
//
////            System.out.println(longerPalindrome);
//
////            if( isPalindrome(longerPalindrome) ) {
//            stringArr[i] = longerPalindrome;
//
//            if( longerPalindrome.length() > longestPalindrome.length() ){
//                longestPalindrome = longerPalindrome;
//            }
////            }
//        }
//
//        return longestPalindrome;
//    }