package leetcode.easy;

//"aaaabbbbcccc"
//"rat"
//"leetcode"
//"ggggggg"
//"spo"
public class L1370IncreasingDecreasingSubsequence {

    public String sortString(String s) {

        int[] freqArr = new int[26];

        for( int i = 0; i < s.length(); i++ ){
            freqArr[s.charAt(i)-'a']++;
        }


        StringBuilder sb = new StringBuilder();

        int n = s.length();

        while( n > 0 ){

            for( int i = 0; i < freqArr.length; i++ ){
                if( freqArr[i] > 0 ){
                    sb.append((char)('a'+i));
                    freqArr[i]--;
                    n--;
                }
            }

            for( int i = freqArr.length-1; i >= 0; i-- ){
                if( freqArr[i] > 0 ){
                    sb.append((char)('a'+i));
                    freqArr[i]--;
                    n--;
                }
            }
        }


        return sb.toString();

    }
}
