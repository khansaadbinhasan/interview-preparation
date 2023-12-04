package leetcode.easy;

import java.util.*;

//"book"
//"textbook"
//"MerryChristmas"
//"AbCdEfGh"

public class L1704StringHalvesAlike {

    public boolean halvesAreAlike(String s) {

        s = s.toLowerCase();

        Set<Character> vowelSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        String s1 = s.substring(0, s.length() / 2);

        int s1vow = 0;
        int s1con = 0;

        for( int i = 0; i < s1.length(); i++ ){
            if( vowelSet.contains(s1.charAt(i)) ) s1vow++;
            else s1con++;
        }


        String s2 = s.substring(s.length() / 2);

        int s2vow = 0;
        int s2con = 0;

        for( int i = 0; i < s2.length(); i++ ){
            if( vowelSet.contains(s2.charAt(i)) ) s2vow++;
            else s2con++;
        }

        return (s1vow == s2vow) && (s1con == s2con);
    }


}
