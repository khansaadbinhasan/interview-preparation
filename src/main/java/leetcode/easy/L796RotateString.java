package leetcode.easy;


//"abcde"
//"cdeab"
//"abcde"
//"abced"
public class L796RotateString {

    public boolean rotateString(String s, String goal) {
        if( s.length() != goal.length() ) return false;

        return (s+s).contains(goal);
    }


}
