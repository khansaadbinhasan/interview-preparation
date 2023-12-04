package leetcode.easy;

//["hello","leetcode"]
//"hlabcdefgijkmnopqrstuvwxyz"
//["word","world","row"]
//"worldabcefghijkmnpqstuvxyz"
//["apple","app"]
//"abcdefghijklmnopqrstuvwxyz"
//["rapple","app", "app", "apple", "chapple", "rappled"]
//"abcdefghijklmnopqrstuvwxyz"
//["rapple","app", "app", "hello","leetcode", "apple", "chapple", "rappled", "word","world","row"]
//"hlabcdefgijkmnopqrstuvwxyz"
//["rapple"]
//"hlabcdefgijkmnopqrstuvwxyz"
public class L953VerifyAlienDictionary {

    public boolean isAlienSorted(String[] words, String order) {

        int count = 1;

        int[] freqArr = new int[26];

        for( int i = 0; i < order.length(); i++ ){
            freqArr[order.charAt(i)-'a'] = count++;
        }

        for( int i = 1; i < words.length; i++ ){
            int len = Math.min(words[i].length(), words[i-1].length());

            int j = 0;
            for( j = 0; j < len; j++ ){
                if( freqArr[words[i].charAt(j)-'a'] < freqArr[words[i-1].charAt(j)-'a'] ){
                    return false;
                }

                else if( freqArr[words[i].charAt(j)-'a'] > freqArr[words[i-1].charAt(j)-'a'] ){
                    break;
                }
            }

            if( j == len && words[i].length() < words[i-1].length() ) return false;
        }

        return true;
    }

}
