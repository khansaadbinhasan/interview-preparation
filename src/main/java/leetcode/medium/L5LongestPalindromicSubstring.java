package leetcode.medium;

//"babad"
//"cbbd"
//"a"
//"ab"
//"aa"
//"aaa"
//"abaa"
//"aacabdkacaa"
public class L5LongestPalindromicSubstring {

    public static void main(String[] args) {
//        System.out.println('a'+"a"+'a');
        new L5LongestPalindromicSubstring().run();
    }

    public void run(){
        System.out.println(longestPalindrome3("cbbd"));
    }


    public String longestPalindrome4(String s) {
        maxPalindrome = String.valueOf(s.charAt(0));
        int count = 0;

        for( int k = 0; k < 2; k++ ){
            for( int i = 1; i < s.length(); i++ ){
                int p1 = i - (k%2==0?0:1);
                int p2 = i;

                String pal = s.substring(Math.max(p1, 0),Math.min(p1+1,s.length()));

                while( p1 >= 0 && p2 < s.length() && s.charAt(p1) == s.charAt(p2)){
                    pal = s.substring(Math.max(p1, 0),Math.min(p2+1,s.length()));
                    p1--;
                    p2++;
                }

                if( pal.length() > maxPalindrome.length() ) maxPalindrome = pal;
            }
        }



        return maxPalindrome;
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



    String maxPalindrome = "";

    public String longestPalindrome3(String s) {
        for( int i = 1; i < s.length()-1; i++ ){
            palindrome(s, i-1, i+1, String.valueOf(s.charAt(i)));
        }

        for( int i = 1; i < s.length(); i++ ){
            palindrome(s, i-1, i, "");
        }
        return maxPalindrome;
    }

    public String palindrome(String s, int p1, int p2, String currPalindrome){
        if( p1 < 0 || p2 >= s.length() ) {
            if( currPalindrome.length() > maxPalindrome.length() ) maxPalindrome = currPalindrome;
            return maxPalindrome;
        }

        if( s.charAt(p1) == s.charAt(p2) ){
            currPalindrome = palindrome(s, p1-1, p2+1, s.charAt(p1)+currPalindrome+s.charAt(p2));
        }

        else {
            String currPalindrome1 = palindrome(s, p1-1, p2, currPalindrome);
            String currPalindrome2 = palindrome(s, p1, p2+1, currPalindrome);

            if( currPalindrome1.length() > currPalindrome2.length() ) currPalindrome = currPalindrome1;
            else currPalindrome = currPalindrome2;
        }

        // System.out.println(currPalindrome);
        if( currPalindrome.length() > maxPalindrome.length() ) maxPalindrome = currPalindrome;

        return maxPalindrome;
    }
}
