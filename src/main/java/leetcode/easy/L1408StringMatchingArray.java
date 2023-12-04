package leetcode.easy;

import java.util.*;

//["mass","as","hero","superhero"]
//["leetcode","et","code"]
//["blue","green","bu"]
//["leetcoder","leetcode","od","hamlet","am"]
//["jak","yjakdn","tj","yyjakdn"]
public class L1408StringMatchingArray {

    public List<String> stringMatching(String[] words) {

        List<String> lst = new LinkedList<>();

        for( int i = 0; i < words.length; i++ ){
            for( int j = 0; j < words.length; j++ ){
                if( !words[i].equals(words[j]) && words[j].contains(words[i]) && !lst.contains(words[i]) )
                    lst.add(words[i]);
            }
        }

        return lst;
    }

}
