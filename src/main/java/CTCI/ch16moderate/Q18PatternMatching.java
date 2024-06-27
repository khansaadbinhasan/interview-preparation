package CTCI.ch16moderate;

import java.util.*;

//TODO do this again --> Leetcode 291
public class Q18PatternMatching {


    public static void main(String[] args) {
        new Q18PatternMatching().run();
    }

    public void run(){
        System.out.println(patternMatching("catcatgocatgo", "aabab"));
        System.out.println(patternMatching("catcatgocatgo", "aaba"));
        System.out.println(patternMatching("catcatgocatgo", "a"));
        System.out.println(patternMatching("catcatgocatgo", "b"));


        System.out.println(patternMatchingII("catcatgocatgo", "aabab"));
        System.out.println(patternMatchingII("catcatgocatgo", "aaba"));
        System.out.println(patternMatchingII("catcatgocatgo", "a"));
        System.out.println(patternMatchingII("catcatgocatgo", "b"));
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
        if( pattern.length() == 0 ) return value.length()==0;

        char mainChar = pattern.charAt(0);
        char altChar = mainChar == 'a' ? 'b': 'a';
        int size = value.length();

        int countOfMain = countOf(pattern, mainChar);
        int countOfAlt = pattern.length() - countOfMain;
        int firstAlt = pattern.indexOf(altChar);
        int maxMainSize = size / countOfMain;

        for (int mainSize = 0; mainSize <= maxMainSize; mainSize++) {
            int remainingLength = size - mainSize*countOfMain;
            String first = value.substring(0, mainSize);

            if( countOfAlt == 0 || remainingLength % countOfAlt == 0 ){
                int altIndex = firstAlt * mainSize;
                int altSize = countOfAlt == 0 ? 0: remainingLength/countOfAlt;
                String second = countOfAlt == 0? "": value.substring(altIndex, altSize+altIndex);
                String cand = buildString(first, second, pattern);
                if( cand.equals(value) ) return true;
            }
        }

        return false;
    }

    private int countOf(String pattern, char c) {
        int count = 0;

        for (int i = 0; i < pattern.length(); i++) {
            if( pattern.charAt(i) == c ) count++;
        }

        return count;
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

}
