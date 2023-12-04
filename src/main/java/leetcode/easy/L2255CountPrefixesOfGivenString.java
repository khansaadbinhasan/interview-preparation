package leetcode.easy;

//["a","b","c","ab","bc","abc"]
//"abc"
//["a","a"]
//"aa"
//["a"]
//"a"
public class L2255CountPrefixesOfGivenString {

    public int countPrefixes(String[] words, String s) {

        int count = 0;

        for( int i = 0; i < words.length; i++ ){
            if( s.startsWith(words[i]) ) count++;
        }

        return count;

    }
}
