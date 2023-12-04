package leetcode.easy;

import java.util.*;

//"YazaAay"
//"Bb"
//"c"
//"dsjkfhakjdshfjkhsjkfhdkjasAAAAAAAAAAAAAAAAAADDDDDDDDDDDDDDJJJJJJJJJJJKLKLKLKL"
//"AAAAAAAAAAAAAAAAAAAAAaaaaaaaaaaaaaPPPPPPPPPOOOOOOOOooooiiiiUUUUUhhhhJJJJJJKKKKMMNNVBnnnbbvvmmnll"
//"A"
//"LPlp"
public class L1763LongestNiceSubstring {

    public String longestNiceSubstring(String s) {

        String nice = "";

        for( int i = 0; i < s.length(); i++ ){
            StringBuilder newNice = new StringBuilder();
            for( int j = i; j < s.length(); j++ ){
                newNice.append(s.charAt(j));

                if( isNice(newNice.toString()) && (newNice.length() > nice.length()) ){
                    nice = newNice.toString();
                }
            }
        }


        return nice;
    }

    public boolean isNice(String s){
        int[] smallFreqArr = new int[26];
        int[] capitalFreqArr = new int[26];

        for( int i = 0; i < s.length(); i++ ){
            if( s.charAt(i) >= 'a' && s.charAt(i) <= 'z' ){
                smallFreqArr[s.charAt(i)-'a']=1;
            }

            if( s.charAt(i) >= 'A' && s.charAt(i) <= 'Z' ){
                capitalFreqArr[s.charAt(i)-'A']=1;
            }
        }

        return Arrays.equals(smallFreqArr, capitalFreqArr);
    }

}
