package leetcode.easy;

import java.util.*;

//"egg"
//"add"
//"foo"
//"bar"
//"paper"
//"title"
//"paper"
//"ttile"
//"this"
//"that"
//"random"
//"random"
//"rando"
//"odnar"
//"a"
//"b"
public class L205IsomorphicString {
    public boolean isIsomorphic(String s, String t) {
        return isIsomorphic2(s,t) && isIsomorphic2(t,s);
    }

    public boolean isIsomorphic2(String s, String t) {
        Map<Character, Character> map = new HashMap<>();

        for( int i = 0; i < s.length(); i++ ){
            if( map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) != t.charAt(i) ) {
                return false;
            }

            map.put(s.charAt(i), t.charAt(i));
        }

        return true;
    }
}
