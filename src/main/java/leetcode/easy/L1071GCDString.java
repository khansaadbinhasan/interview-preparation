package leetcode.easy;

//"ABCABC"
//"ABC"
//"ABABAB"
//"ABAB"
//"LEET"
//"CODE"
public class L1071GCDString {

    public static void main(String[] args) {
        new L1071GCDString().run();
    }

    public void run(){
        System.out.println(gcdOfStrings("ABABAB", "ABAB"));
    }

    public String gcdOfStrings(String str1, String str2) {

        String gcd = "";
        String s = str1.length() > str2.length() ? str2: str1;

        for( int i = 1; i <= s.length(); i++ ){
            String sub = s.substring(0, i);
            if( isDivide(sub, str1) && isDivide(sub, str2) && sub.length() > gcd.length() ){
                gcd = sub;
            }
        }

        return gcd;
    }

    public boolean isDivide(String t, String s){
        if( t.length() == 0 ) return false;
        if( s.length() % t.length() != 0 ) return false;

        String tFin = "";
        int tLen = t.length();

        for( int i = 0; i < s.length() / tLen; i++ ){
            tFin += t;
        }

        return s.equals(tFin);
    }

}
