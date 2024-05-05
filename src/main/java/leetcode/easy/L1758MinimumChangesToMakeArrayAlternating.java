package leetcode.easy;

//"0100"
//"10"
//"1111"
//"0"
//"1"
//"0101001010101000001010010101001010101010101010100101010101010101010101010010101010010101"
//"01010010101010000010100101010010101010101010101001010101010100101001010101000001010010101001010101010101010100101010101010101010101010010101010010101101010101010010101010010101"
public class L1758MinimumChangesToMakeArrayAlternating {

    public int minOperations(String s) {
        StringBuilder sb0 = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();

        for( int i = 0; i < s.length(); i+=2 ){
            sb0.append(0);sb0.append(1);
            sb1.append(1);sb1.append(0);
        }

        int diff0 = 0;
        int diff1 = 0;

        for( int i = 0; i < s.length(); i++ ){
            diff0 += (s.charAt(i)!=sb0.charAt(i)?1:0);
            diff1 += (s.charAt(i)!=sb1.charAt(i)?1:0);
        }

        return Math.min(diff0, diff1);
    }

}
