package leetcode.easy;

//"RLRRLLRLRL"
//"RLLLLRRRLR"
//"LLLLRRRR"
//"RLRRRLLRLL"
//"LR"
public class L1221SplitStringLR {

    public int balancedStringSplit(String s) {

        if( s.length() < 2 ) return 0;

        int lCount = s.charAt(0) == 'L'? 1: 0;
        int rCount = s.charAt(0) == 'R'? 1: 0;

        int count = 0;

        for( int i = 1; i < s.length(); i++ ){
            if(s.charAt(i) == 'L') lCount++;
            else rCount++;

            if( lCount == rCount ) count++;
        }

        return count;
    }

}
