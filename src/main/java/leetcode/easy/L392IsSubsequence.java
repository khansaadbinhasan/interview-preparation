package leetcode.easy;

//"abc"
//"ahbgdc"
//"axc"
//"ahbgdc"
//"a"
//"b"
//"a"
//"a"
//""
//"ahbgdc"
//"b"
//"abc"
public class L392IsSubsequence {

    public static void main(String[] args) {
        new L392IsSubsequence().run();
    }

    public void run(){
        System.out.println(isSubsequence("abc","ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {

        if( s.length() == 0 ) return true;

        int i = 0;
        for( int j = 0; j < t.length(); j++ ){
            if( (i < s.length()) && (s.charAt(i) == t.charAt(j)) ){
                i++;
            }
        }

        return i == s.length();
    }
}
