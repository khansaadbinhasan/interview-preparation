package leetcode.easy;

//"xyzzaz"
//"aababcabc"
//"a"
//"adjksflfjadsklgklfsahldkghdaksfhjldsjfkljalkjldfkjlsd"
public class L1876GoodSubstrings {

    public int countGoodSubstrings(String s) {

        int count = 0;

        for( int i = 0; i < s.length()-2; i++ ){
            if( isGood(s.substring(i, i+3)) ) count++;
        }

        return count;
    }

    public boolean isGood(String s){

        return  (s.charAt(0) != s.charAt(1)) &&
                (s.charAt(1) != s.charAt(2)) &&
                (s.charAt(0) != s.charAt(2));
    }

}
