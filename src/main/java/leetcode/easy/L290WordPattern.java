package leetcode.easy;

import java.util.*;

//"abba"
//"dog cat cat dog"
//"abba"
//"dog cat cat fish"
//"aaaa"
//"dog cat cat dog"
//"a"
//"dog"
//"this"
//"that"
//"askdjfklasjd"
//"this is one word that is being stretched too long dub dub"
//"all"
//"this thisa thisa"
//"abba"
//"dog dog dog dog"
public class L290WordPattern {

    public static void main(String[] args) {
        new L290WordPattern().run();
    }

    public void run(){
        System.out.println(wordPattern("abba", "dog cat cat dog"));
    }

    public boolean wordPattern(String pattern, String s) {
        String pattern2 = "";

        String[] words = s.split(" ");
        String[] patList = pattern.split("");

        if( words.length != patList.length ) return false;

        HashMap<String, String> wordMap = new HashMap<>();

        for( int i = 0; i < words.length; i++ ){

            if( !wordMap.containsKey(words[i]) ){
                wordMap.put( words[i], patList[i] );
            }

            pattern2 += wordMap.get(words[i]);
        }

        long count = wordMap.values().stream().distinct().count();

        if( count != wordMap.size() ) return false;

        return pattern.equals(pattern2);
    }
}
