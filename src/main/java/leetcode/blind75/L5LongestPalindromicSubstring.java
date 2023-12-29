package leetcode.blind75;

public class L5LongestPalindromicSubstring {

    public static void main(String[] args) {
        new L5LongestPalindromicSubstring().run();
    }

    public void run(){
        System.out.println(longestPalindrome2(""));
    }

    public String longestPalindrome2(String s){

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

    public String longestPalindrome(String s){

        String maxPalindromeString = "";//rtr

        //b a b a d
        //r t r
        //^
        for( int i = 0; i < s.length(); i++ ){//2
            int p1 = i-1;//1
            int p2 = i+1;//3

            String str = String.valueOf(s.charAt(i));//rtr

            while( p1 >= 0 && p2 < s.length() ){//3
                if( s.charAt(p1) != s.charAt(p2) ) break;

                str = String.valueOf(s.charAt(p1)) + str + String.valueOf(s.charAt(p2));

                p1--;
                p2++;
            }

            if( str.length() > maxPalindromeString.length() ){
                maxPalindromeString = str;
            }
        }

        for( int i = 0; i < s.length(); i++ ){//2
            int p1 = i;//1
            int p2 = i+1;//3

            String str = "";//rtr

            while( p1 >= 0 && p2 < s.length() ){//3
                if( s.charAt(p1) != s.charAt(p2) ) break;

                str = String.valueOf(s.charAt(p1)) + str + String.valueOf(s.charAt(p2));

                p1--;
                p2++;
            }

            if( str.length() > maxPalindromeString.length() ){
                maxPalindromeString = str;
            }
        }

        return maxPalindromeString;
    }
}
