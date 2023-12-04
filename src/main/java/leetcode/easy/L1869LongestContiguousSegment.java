package leetcode.easy;

//"1101"
//"111000"
//"110100010"
//"1"
//"0"
//"101010000100010010000100001010100101010"
public class L1869LongestContiguousSegment {

    public boolean checkZeroOnes(String s) {

        int longest0Seq = 0;
        int longest1Seq = 0;

        for( int i = 0; i < s.length(); i++ ){

            int longest0 = 0;
            int longest1 = 0;

            while( i < s.length() && s.charAt(i) == '0' ){
                longest0++;
                i++;
            }

            while( i < s.length() && s.charAt(i) == '1' ){
                longest1++;
                i++;
            }

            longest0Seq = Math.max(longest0, longest0Seq);
            longest1Seq = Math.max(longest1, longest1Seq);
            i--;
        }


        return longest1Seq > longest0Seq;

    }
}
