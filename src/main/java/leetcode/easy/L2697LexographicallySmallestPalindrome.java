package leetcode.easy;


//"egcfe"
//"abcd"
//"seven"
//"a"
//"aa"
//"ab"
//"ba"
//"cac"
//"neves"
public class L2697LexographicallySmallestPalindrome {

    public static void main(String[] args) {
        new L2697LexographicallySmallestPalindrome().run();
    }

    public void run(){
        System.out.println(makeSmallestPalindrome("neves"));
    }

    public String makeSmallestPalindrome(String s) {

        int j = s.length()-1;
        int minOps = 0;

        for( int i = 0; i < s.length() / 2; i++ ){
            if( s.charAt(i) != s.charAt(j) ) {
                if( s.charAt(j) < s.charAt(i) ){
                    s = s.substring(0, i) + s.charAt(j) + s.substring(i+1);
                }

                else{
                    s = s.substring(0, j) + s.charAt(i) + s.substring(j+1);
                }
            }

            j--;
        }

        return s;
    }
}
