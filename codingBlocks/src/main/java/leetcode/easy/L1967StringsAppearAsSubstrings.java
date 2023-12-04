package leetcode.easy;

//["a","abc","bc","d"]
//"abc"
//["a","b","c"]
//"aaaaabbbbb"
//["a","a","a"]
//"ab"
//["nmksysm","gwjt","vjwxinx","wj","yspxxcv","tpeud","sv","sztjxnrb","smsv","vj","pj","tsmsvj","e","svj","w","vj","awofrm","rshgiiyi","v"]
//"ygwjtsmsvj"
public class L1967StringsAppearAsSubstrings {

    public int numOfStrings(String[] patterns, String word) {

        int count = 0;

        for( String pattern: patterns ){
            if( contains(word, pattern) ) count++;
        }

        return count;

    }

    public boolean contains(String s, String subString){

        for( int i = 0; i < s.length(); i++ ){

            int pointer = i;

            for( int j = 0; j < subString.length(); j++ ){
                if( pointer < s.length() && s.charAt(pointer) == subString.charAt(j) ) pointer++;
                else break;
            }

            if( (pointer-i) == subString.length() ) return true;
        }

        return false;
    }

}
