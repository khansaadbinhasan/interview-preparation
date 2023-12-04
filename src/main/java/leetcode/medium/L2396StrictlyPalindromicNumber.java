package leetcode.medium;

//9
//4
//100000
//1000
//83993
public class L2396StrictlyPalindromicNumber {
    public boolean isStrictlyPalindromic(int n) {

        for( int i = 2; i < n-1; i++ ){
            if( !isPalindrome(getNum(n, i)) ) return false;
        }

        return true;
    }

    public boolean isPalindrome(String num){
        for( int i = 0; i < num.length()/2; i++ ){
            if( num.charAt(i) != num.charAt(num.length()-1-i) ) return false;
        }

        return true;
    }

    public String getNum(int n, int base){

        String num = "";

        while( n != 0 ){
            num += n % base;
            n = n / base;
        }

        return num;
    }


}
