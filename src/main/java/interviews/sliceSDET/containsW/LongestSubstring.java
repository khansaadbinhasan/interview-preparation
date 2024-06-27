package interviews.sliceSDET.containsW;

import java.util.*;

public class LongestSubstring {

    //    Khansaadbinhasan
    // longest substring without repeating characters
    // characters - alphabets only and capital and small are same

    //    Khansaadbinhasan
    //    p1, p2
    // khans
    // hans
    // ans
    // a
//    khans
    //adbinh
    //binhas --> 6
    //inhas

    //take a priority queue with length of string as parameter
    //n --> exponential

    public static void main(String[] args) {
        new LongestSubstring().run();
    }

    public void run(){
//        System.out.println(longestSubstringWithoutRepetition("khansaadbinhasan"));
//        System.out.println(longestSubstringWithoutRepetition2("khansaadbinhasan"));
        System.out.println(longestSubstringWithoutRepetition2("hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"));
    }


    public List<String> longestSubstringWithoutRepetition(String s){

        s = s.toLowerCase();

        int p1 = 0;
        int p2 = 1;

        Set<Character> characterSet = new HashSet<>();
        Map<Integer, List<String>> lenVsListOfSubstring = new HashMap<>();

        characterSet.add(s.charAt(p1));//khans

        while( p1 < p2 && p2 < s.length() ){
            if( characterSet.contains(s.charAt(p2)) ){
                lenVsListOfSubstring.putIfAbsent(p2-p1, new LinkedList<>());
                lenVsListOfSubstring.get(p2-p1).add(s.substring(p1, p2));
                p1 = p2;
                characterSet = new HashSet<>();
            }
            characterSet.add(s.charAt(p2));
            p2++;
        }

        int max = 0;

        for( int len: lenVsListOfSubstring.keySet() ){
            max = Math.max(len, max);
        }

        return lenVsListOfSubstring.get(max);
    }

    public List<String> longestSubstringWithoutRepetition2(String s){

        s = s.toLowerCase();

        int p1 = 0;
        int p2 = 1;

        Set<Character> characterSet = new HashSet<>();
        Map<Integer, List<String>> lenVsListOfSubstring = new HashMap<>();

        characterSet.add(s.charAt(p1));//khans

        while( p1 < p2 && p2 < s.length() ){
            if( characterSet.contains(s.charAt(p2)) ){
                lenVsListOfSubstring.putIfAbsent(p2-p1, new LinkedList<>());
                lenVsListOfSubstring.get(p2-p1).add(s.substring(p1, p2));
                while ( p1 < s.length() && characterSet.contains(s.charAt(p2)) ){
                    characterSet.remove(s.charAt(p1));
                    p1++;
                }
            }
            characterSet.add(s.charAt(p2));
            p2++;
        }

        lenVsListOfSubstring.putIfAbsent(p2-p1, new LinkedList<>());
        lenVsListOfSubstring.get(p2-p1).add(s.substring(p1, p2));

        int max = 0;

        for( int len: lenVsListOfSubstring.keySet() ){
            max = Math.max(len, max);
        }

        return lenVsListOfSubstring.get(max);
    }


}
