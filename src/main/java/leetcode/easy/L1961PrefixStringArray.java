package leetcode.easy;

//"iloveleetcode"
//["i","love","leetcode","apples"]
//"iloveleetcode"
//["apples","i","love","leetcode"]
//"i"
//["i"]
//"thisissomestring"
//["thisis"]
//"thisissomestring"
//["l"]
//"a"
//["aa","aaaa","banana"]
public class L1961PrefixStringArray {

    public boolean isPrefixString(String s, String[] words) {

        String wordStr = "";

        for( int i = 0; i < words.length; i++ ){
            wordStr += words[i];

            if( wordStr.equals(s) ) return true;
        }

        return false;
    }
}
