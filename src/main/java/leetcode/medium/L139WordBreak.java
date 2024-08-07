package leetcode.medium;

import java.util.*;

//"leetcode"
//["leet","code"]
//"applepenapple"
//["apple","pen"]
//"catsandog"
//["cats","dog","sand","and","cat"]
//"catsanddog"
//["cats","dog","sand","and","cat"]
//"klafdjklasdhkfhdjkhfjkdsahfjkldshafkashdkfjhlasdkfdzppaoppqwoqueioewyurivjkdsnmbjkz"
//["a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"]
//"klafdjklasdhkfhdjkhfjkdsahfjkldshafkashdkfjhlasdkfdppaoppqwoqueioewyurivjkdsnmbjk"
//["a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y"]
//"a"
//["a"]
//"a"
//["b"]
//"aaaaaaa"
//["aaaa","aa"]
//"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
//["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
public class L139WordBreak {

    public static void main(String[] args) {
        new L139WordBreak().run();
    }

    public void run(){
        System.out.println(wordBreak3("leetcode", Arrays.asList("leet", "code")));
    }

    int[] breakPossible;

    public boolean wordBreak(String s, List<String> wordDict) {
        breakPossible = new int[s.length()];

        //iterate through s
        //iterate through dict[s[0]]
        //if match then i --> i + len

        Map<Character, List<String>> dict = new HashMap<>();

        for( String word: wordDict ){
            if( !dict.containsKey(word.charAt(0)) ){
                dict.put( word.charAt(0), new LinkedList<>() );
            }

            dict.get(word.charAt(0)).add(word);
        }

        return breakWord( s, 0, dict );
    }

    public boolean breakWord( String s, int ind, Map<Character, List<String>> dict ){
        if( ind >= s.length() ) return true;
        if( breakPossible[ind] == 1 ) return true;
        if( breakPossible[ind] == -1 ) return false;

        char c = s.charAt(ind);

        if( dict.containsKey(c) ){
            for( String word: dict.get(c) ){
                if( ind+word.length() <= s.length() ){
                    if( s.substring(ind, ind+word.length()).equals(word) ){
                        if( breakWord( s, ind+word.length(), dict ) ){
                            breakPossible[ind]=1;
                            return true;
                        }
                    }
                }
            }
        }

        breakPossible[ind] = -1;

        return false;
    }

    Boolean[] isPossible;

    public boolean wordBreak3(String s, List<String> wordDict) {
        isPossible = new Boolean[s.length()];
        Arrays.fill(isPossible, null);

        return wordBreakDP(s, wordDict, 0);
    }

    public boolean wordBreakDP(String s, List<String> wordDict, int i) {
        if( i >= s.length() ) return true;
        if( isPossible[i] != null ) return isPossible[i];

        for( String word: wordDict ){
            if( s.substring(i).startsWith(word) ) {
                if( wordBreakDP(s, wordDict, i+word.length()) )
                    return isPossible[i+word.length()-1]=true;
            }
        }

        return isPossible[i]=false;
    }

//    public boolean contains(String s, String t){
//        return s.length() > t.length() && s.startsWith(t);
//    }

}
