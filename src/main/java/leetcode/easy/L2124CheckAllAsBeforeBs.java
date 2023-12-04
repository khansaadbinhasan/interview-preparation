package leetcode.easy;

//"aaabbb"
//"abab"
//"bbb"
//"aaa"
public class L2124CheckAllAsBeforeBs {

    public boolean checkString(String s) {
        int aCount = 0;

        for( int i = 0; i < s.length(); i++ ){
            if( s.charAt(i) == 'b' ){
                while( i < s.length() && s.charAt(i) == 'b' ){
                    i++;
                }

                if( i == s.length() ) return true;
                break;
            }

            else{
                aCount++;
            }
        }

        return aCount == s.length();
    }
}
