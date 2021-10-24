package leetcode.easy;

//"(1+(2*3)+((8)/4))+1"
//"(1)+((2))+(((3)))"
//"1+(2*3)/(2-1)"
//"1"
public class L1614MaxDepthParanthesis {

    public int maxDepth(String s) {

        int maxDepth = 0;

        int currDepth = 0;

        for( char c: s.toCharArray() ){
            if( c == '(' ) currDepth++;

            maxDepth = Math.max(maxDepth, currDepth);

            if( c == ')' ) currDepth--;
        }

        return maxDepth;
    }

}
