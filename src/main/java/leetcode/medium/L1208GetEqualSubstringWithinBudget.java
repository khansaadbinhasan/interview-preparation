package leetcode.medium;

//"abcd"
//"bcdf"
//3
//"abcd"
//"cdef"
//3
//"abcd"
//"acde"
//0
//"abcd"
//"dabc"
//0
//"kdlahfklalllaoaoaoaoaoao"
//"kdlahfklalllaoaoaoaoaoao"
//0
//"alalalalallalllalallal"
//"alalalalallalllalallal"
//100
//"abcd"
//"abce"
//1
//"a"
//"b"
//2
//"krrgw"
//"zjxss"
//19
public class L1208GetEqualSubstringWithinBudget {


    public int equalSubstring(String s, String t, int maxCost) {
        int[] prefixSum = new int[s.length()];

        for( int i = 0; i < s.length(); i++ ){
            prefixSum[i] = Math.abs(s.charAt(i)-t.charAt(i));
        }

        // for( int i = 1; i < prefixSum.length; i++ ){
        //     prefixSum[i] += prefixSum[i-1];
        // }

        int p1 = 0;
        int p2 = 0;
        int sum = 0;
        int maxLen = 0;


        while( p1 < prefixSum.length && p2 < prefixSum.length ){
            sum += prefixSum[p2];

            if( sum <= maxCost ){
                maxLen = Math.max(maxLen, p2-p1+1);
                p2++;
            }

            else{
                sum -= prefixSum[p1];
                p1++;
            }
        }

        return maxLen;
    }

    public int equalSubstring2(String s, String t, int maxCost) {
        int[] prefixSum = new int[s.length()];

        for( int i = 0; i < s.length(); i++ ){
            prefixSum[i] = Math.abs(s.charAt(i)-t.charAt(i));
        }

        int p1 = 0;
        int p2 = 0;
        int sum = 0;
        int maxLen = 0;

        while( p1 < prefixSum.length && p2 < prefixSum.length ){
            sum += prefixSum[p2++];
            if( sum <= maxCost ) maxLen = Math.max(maxLen, p2-p1);
            else sum -= prefixSum[p1++];
        }

        return maxLen;
    }
}
