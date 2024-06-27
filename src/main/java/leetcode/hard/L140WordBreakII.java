package leetcode.hard;

import java.util.*;

//"catsanddog"
//["cat","cats","and","sand","dog"]
//"pineapplepenapple"
//["apple","pen","applepen","pine","pineapple"]
//"catsandog"
//["cats","dog","sand","and","cat"]
//"aaaaaaa"
//["aaaa","aa","a"]
public class L140WordBreakII {

    public static void main(String[] args) {
        new L140WordBreakII().run();
    }

    public void run(){
        System.out.println(wordBreak("aaaaaaa", Arrays.asList("aaaa","aa","a")));
    }

    List<String>[] dp;
    public List<String> wordBreak(String s, List<String> wordDict) {
        dp = new List[s.length()];
        Arrays.fill(dp, new LinkedList<>());
        return possibleString(s, wordDict, 0, new LinkedList<>());
    }

    public List<String> possibleString(String s, List<String> wordDict, int i, List<String> possible){
        if( i >= s.length() ) return Arrays.asList(getString(possible));
        // if( !dp[i].isEmpty() ) return dp[i].addAll();

        List<String> ans = new LinkedList<>();

        for( String word: wordDict ){
            if( s.substring(i).startsWith(word) ){
                List<String> newPossible = new LinkedList<>(possible); // Make a copy of the current list
                newPossible.add(word);
                ans.addAll(possibleString(s, wordDict, i+word.length(), newPossible));
                // possible.remove(word);
            }
        }

        return dp[i] = ans;
    }

    public String getString(List<String> lst){
        String s = "";
        for( String word: lst ){
            s += word + " ";
        }

        return s.trim();
    }


}
//["aaaa aa a","aaaa a aa","aaaa a a a","aa aaaa a","aa aa aa a","aa aa a aa","aa a aa a a","aa a aaaa","aa a aa aa","a aa aa a a","aa a a aa a","a aa a a aa","a a a aa a a","a aaaa aa","a aaaa a a","a aa aaaa","a aa aa aa","a aa aa a a","aa a a aa a","a aa a a aa","a a a aa a a","a a aaaa a","a a aa aa a","a aa a a aa","a a a aa a a","a a a aaaa","a a a aa aa","a a a aa a a","a a a a aa a","a a a a a aa","a a a a a a a"]
//["a a a a a a a","aa a a a a a","a aa a a a a","a a aa a a a","aa aa a a a","aaaa a a a","a a a aa a a","aa a aa a a","a aa aa a a","a aaaa a a","a a a a aa a","aa a a aa a","a aa a aa a","a a aa aa a","aa aa aa a","aaaa aa a","a a aaaa a","aa aaaa a","a a a a a aa","aa a a a aa","a aa a a aa","a a aa a aa","aa aa a aa","aaaa a aa","a a a aa aa","aa a aa aa","a aa aa aa","a aaaa aa","a a a aaaa","aa a aaaa","a aa aaaa"]


//["aaaa a","aa aa a","aa a aa","a aa a a","a aaaa","a aa aa","a aa a a","a a aa a","a a a aa","a a a a a"]...
//["a a a a a","aa a a a","a aa a a","a a aa a","aa aa a","aaaa a","a a a aa","aa a aa","a aa aa","a aaaa"]...