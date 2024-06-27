package leetcode.easy;

//"EEEEEEE"
//"ELELEEL"
//"ELEELEELLL"
public class L3168CountNumberOfChairs {
    public int minimumChairs(String s) {
        int maxE = 0;
        int E = 0;

        for( char c: s.toCharArray() ){
            if( c == 'E' ) E++;
            else E--;
            maxE = Math.max(maxE, E);
        }

        return maxE;
    }
}