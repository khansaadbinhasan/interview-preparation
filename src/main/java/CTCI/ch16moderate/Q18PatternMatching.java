package CTCI.ch16moderate;

import java.util.*;

public class Q18PatternMatching {


    public static void main(String[] args) {
        new Q18PatternMatching().run();
    }

    public void run(){
        System.out.println(patternMatching("catcatgocatgo", "aabab"));
        System.out.println(patternMatching("catcatgocatgo", "aaba"));
        System.out.println(patternMatching("catcatgocatgo", "a"));
        System.out.println(patternMatching("catcatgocatgo", "b"));
    }

    public boolean patternMatching(String value, String pattern) {
        Set<String> sub = substring(value);

        for( String a: sub ){
            for( String b: sub ){
                if( buildString(a, b, pattern).equals(value) ) return true;
            }
        }

        return false;
    }

    public boolean patternMatchingII(String value, String pattern) {
        Set<String> sub = substring(value);

        for( String a: sub ){
            for( String b: sub ){
                if( buildString(a, b, pattern).equals(value) ) return true;
            }
        }

        return false;
    }

    private Set<String> substring(String s){
        Set<String> substring = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                substring.add(s.substring(i,j));
            }
        }

        return substring;
    }

    public String buildString(String a, String b, String pattern){
        StringBuilder sb = new StringBuilder();
        for( char c: pattern.toCharArray() ){
            if( c == 'a' ) sb.append(a);
            else sb.append(b);
        }

        return sb.toString();
    }

    public String buildStringII(String a, String b, String pattern){
        StringBuilder sb = new StringBuilder();
        for( char c: pattern.toCharArray() ){
            if( c == 'a' ) sb.append(a);
            else sb.append(b);
        }

        return sb.toString();
    }
}
