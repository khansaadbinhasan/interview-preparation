package leetcode.medium;

import java.util.*;

//"babad"
//"cbbd"
//"a"
//"aa"
//"aaa"
//"abaa"
//"aacabdkacaa"
//"euazbipzncptldueeuechubrcourfpftcebikrxhybkymimgvldiwqvkszfycvqyvtiwfckexmowcxztkfyzqovbtmzpxojfofbvwnncajvrvdbvjhcrameamcfmcoxryjukhpljwszknhiypvyskmsujkuggpztltpgoczafmfelahqwjbhxtjmebnymdyxoeodqmvkxittxjnlltmoobsgzdfhismogqfpfhvqnxeuosjqqalvwhsidgiavcatjjgeztrjuoixxxoznklcxolgpuktirmduxdywwlbikaqkqajzbsjvdgjcnbtfksqhquiwnwflkldgdrqrnwmshdpykicozfowmumzeuznolmgjlltypyufpzjpuvucmesnnrwppheizkapovoloneaxpfinaontwtdqsdvzmqlgkdxlbeguackbdkftzbnynmcejtwudocemcfnuzbttcoew"
public class L516LongestPalindromicSubsequence {


    public static void main(String[] args) {
        new L516LongestPalindromicSubsequence().run();
    }

    public void run(){
        System.out.println(
                new L516LongestPalindromicSubsequence().longestPalindromeSubseq("euazbipzncptldueeuechubrcourfpftcebikrxhybkymimgvldiwqvkszfycvqyvtiwfckexmowcxztkfyzqovbtmzpxojfofbvwnncajvrvdbvjhcrameamcfmcoxryjukhpljwszknhiypvyskmsujkuggpztltpgoczafmfelahqwjbhxtjmebnymdyxoeodqmvkxittxjnlltmoobsgzdfhismogqfpfhvqnxeuosjqqalvwhsidgiavcatjjgeztrjuoixxxoznklcxolgpuktirmduxdywwlbikaqkqajzbsjvdgjcnbtfksqhquiwnwflkldgdrqrnwmshdpykicozfowmumzeuznolmgjlltypyufpzjpuvucmesnnrwppheizkapovoloneaxpfinaontwtdqsdvzmqlgkdxlbeguackbdkftzbnynmcejtwudocemcfnuzbttcoew")
        );
    }

    int maxLen = 1;
    Map<String, Integer> dp;

    public int longestPalindromeSubseq(String s) {
        dp = new HashMap<>();
        for( int i = 1; i < s.length()-1; i++ ){
            maxLen = Math.max(maxLen, palindrome(s, i-1, i+1, 1));
//            System.out.println(maxLen);
        }

        for( int i = 1; i < s.length(); i++ ){
            maxLen = Math.max(maxLen, palindrome(s, i-1, i, 0));
//            System.out.println(maxLen);
        }
        return maxLen;
    }



    public int palindrome(String s, int p1, int p2, int palLen){
        if( p1 < 0 || p2 >= s.length() ) {
            int max = Math.max(maxLen, palLen);
            dp.put(p1+","+p2, max);
            return Math.max(maxLen, palLen);
        }

        if( dp.containsKey(p1+","+p2) ) return dp.get(p1+","+p2);

        if( s.charAt(p1) == s.charAt(p2) ){
            palLen = palindrome(s, p1-1, p2+1, palLen+2);
        }

        else {
            palLen = Math.max(palindrome(s, p1-1, p2, palLen), palindrome(s, p1, p2+1, palLen));
        }

//        System.out.println(palLen);

        int max = Math.max(maxLen, palLen);
        dp.put(p1+","+p2, max);
        return Math.max(maxLen, palLen);
    }
}
