package leetcode.medium;

//"aaAbcBC"
//"abc"
//"NJNBJBajajajLLL"
//"aAbBxcCX"
//"a"
//"aA"
//"Aa"
public class L3120CountNumberOfSpecialCharactersI {

    public int numberOfSpecialChars(String word) {

        int nums = 0;

        boolean[] appearsSmall = new boolean[26];
        boolean[] appearsCapital = new boolean[26];

        for( char c: word.toCharArray() ) {
            if( c >= 'a' && c <= 'z' ) appearsSmall[c-'a'] = true;
            if( c >= 'A' && c <= 'Z' ) appearsCapital[c-'A'] = true;
        }

        for( int i = 0; i < 26; i++ ){
            if( appearsSmall[i] && appearsCapital[i] ) nums++;
        }

        return nums;
    }

}
