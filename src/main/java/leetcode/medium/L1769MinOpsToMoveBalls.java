package leetcode.medium;

//"110"
//"001011"
//"1"
//"0"
//"1010101010101010101010"
//"0000101010100001000100000"
public class L1769MinOpsToMoveBalls {

    public int[] minOperations(String boxes) {

        int[] minOps = new int[boxes.length()];

        for( int i = 0; i < boxes.length(); i++ ){
            int minOp = 0;
            for( int j = 0; j < boxes.length(); j++ ){
                if( boxes.charAt(j) == '1' ){
                    minOp += Math.abs(i-j);
                }
            }
            minOps[i] = minOp;
        }

        return minOps;
    }

}
