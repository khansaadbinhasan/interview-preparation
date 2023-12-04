package leetcode.easy;

import java.util.*;

//"aeiouu"
//"unicornarihan"
//"cuaieuouac"
//"a"
//"aeiouskjfkdhaskfhsjkaiouaiooeuaioioioaioaioiaoiaouuuaaa"
//"l"
//"aeiou"
public class L2062CountVowelSubstringsOfString {

    public int countVowelSubstrings(String word) {
        Set<String> aeiou = new HashSet<>();
        String[] wordArr = word.split("");

        aeiou.add("a");
        aeiou.add("e");
        aeiou.add("i");
        aeiou.add("o");
        aeiou.add("u");

        int countVowel = 0;

        for( int i = 0; i < wordArr.length; i++ ){
            Set<String> vowelSet = new HashSet<>();
            for( int j = i; j < wordArr.length; j++ ){
                if( aeiou.contains(wordArr[j]) ){
                    vowelSet.add(wordArr[j]);
                }

                else break;

                if( vowelSet.size() == aeiou.size() ) countVowel++;
            }
        }

        return countVowel;
    }
}
