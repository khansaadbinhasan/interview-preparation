package leetcode.easy;

//"011101"
//"00111"
//"1111"
//"00"
//"11"
//"10101010101"
//"000011101010010101"
//"0100"
public class L1422MaxScoreAfterSplitting {

    public int maxScore(String s) {
        int total1s = 0;

        for( int i = 0; i < s.length(); i++ ){
            if( s.charAt(i) == '1' ) total1s++;
        }

        int num0 = 0;
        int num1 = 0;
        int max = 0;

        int slen = s.length();

        if( s.charAt(s.length()-1) == '0' ) slen--;

        for( int i = 0; i < slen; i++ ){
            if( s.charAt(i) == '0' ) num0++;
            else num1++;

            max = Math.max(max, num0+total1s-num1);
        }

        return max;
    }
}
