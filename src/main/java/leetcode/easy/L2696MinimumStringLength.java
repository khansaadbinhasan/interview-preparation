package leetcode.easy;

//"ABFCACDB"
//"ACBBD"
//"A"
//"AB"
//"CD"
//"ABCD"
//"CCDDABB"
//"ACCDDABB"
public class L2696MinimumStringLength {

    public int minLength(String s) {
        while( s.contains("AB") || s.contains("CD") ){
            s = s.replaceAll("AB", "");
            s = s.replaceAll("CD", "");
        }

        return s.length();
    }
}
