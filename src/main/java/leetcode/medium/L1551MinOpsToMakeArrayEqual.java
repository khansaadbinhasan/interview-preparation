package leetcode.medium;

public class L1551MinOpsToMakeArrayEqual {

    public int minOperations(int n) {
        // [1,3,5] --> 2
        // [1,3,5,7,9,11] --> 9
        // 5+3+1

        int minOps = 0;

        for( int i = 0; i < n/2; i++ ){
            minOps += (n-2*i-1);
        }

        return minOps;
    }

}
