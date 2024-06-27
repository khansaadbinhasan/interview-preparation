package leetcode.medium;

import java.util.*;

//["cat","bat","rat"]
//"the cattle was rattled by the battery"
//["a","b","c"]
//"aadsfasf absbs bbab cadsfafs"
//["a","b","c","cat","bat","rat","kda","lkj","poi","aeq"]
//"aadsfasf absbs bbab cadsfafs the cattle was rattled by the battery aadsfasf absbs bbab cadsfafs the cattle was rattled by the battery thi is poasdfh dafkhakl hudsahf jkdshalf ajkdsa jkhdlaf adhjfk ioyqut pop qweyut hdsfb"
//["a","b","c","cat","bat","rat","kda","lkj","poi","aeq", "p"]
//"aadsfasf absbs bbab cadsfafs the cattle was rattled by the battery aadsfasf absbs bbab cadsfafs the cattle was rattled by the battery thi is poasdfh dafkhakl hudsahf jkdshalf ajkdsa jkhdlaf adhjfk ioyqut pop qweyut hdsfb pang"
public class L648ReplaceWords {
    public String replaceWords(List<String> dictionary, String sentence) {

        String[] words = sentence.split(" ");

        Map<Character, List<String>> dict = new HashMap<>();

        for( String w: dictionary ){
            dict.putIfAbsent(w.charAt(0), new LinkedList<>());
            dict.get(w.charAt(0)).add(w);
        }

        StringBuilder sb = new StringBuilder();

        for( String word: words ){
            if( dict.containsKey(word.charAt(0)) ){
                for( String w: dict.get(word.charAt(0)) ){
                    if( word.startsWith(w) && word.length() > w.length() ){
                        word = w;
                    }
                }
            }
            sb.append(word).append(" ");
        }

        return sb.toString().trim();
    }
}
