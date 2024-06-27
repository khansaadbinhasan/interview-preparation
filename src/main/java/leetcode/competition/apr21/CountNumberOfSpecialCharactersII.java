package leetcode.competition.apr21;

//"aaAbcBC"
//"abc"
//"NJNBJBajajajLLL"
//"aAbBxcCX"
//"a"
//"aA"
//"Aa"
//"AbBCab"
//"abDBAbb"
//"cCceDC"
//"AbcbDBdD"
public class CountNumberOfSpecialCharactersII {

    public int numberOfSpecialChars(String word) {
        int nums = 0;

        int[] appearsSmall = new int[26];
        int[] appearsCapital = new int[26];

        for( char c: word.toCharArray() ) {
            if( c >= 'a' && c <= 'z' ) {
                if( appearsCapital[c-'a'] >= 1 ) {
                    appearsCapital[c-'a'] = -1;
                }
                appearsSmall[c-'a'] = 1;
            }
            else {
                if( (appearsSmall[c-'A'] == 1) && (appearsCapital[c-'A'] == 0) ) {
                    appearsCapital[c-'A'] = 2;
                }

                if( appearsCapital[c-'A'] != -1 && appearsCapital[c-'A'] != 2 ) {
                    appearsCapital[c-'A'] = 1;
                }
            }
        }

        for( int i = 0; i < 26; i++ ){
            if( appearsCapital[i] == 2 ) nums++;
        }


        return nums;
    }
}
