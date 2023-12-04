package leetcode.easy;

//3
//2
//0
//2
//3
//2
//0
//4
//1
//2
//3
//5
//0
//0
//1
//1
public class L2600KItemsWithMaxSum {

    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {

        int sum = 0;

        if( numOnes >= k ) return k;

        sum += numOnes;
        k -= numOnes;

        if( numZeros >= k ) return sum;

        k -= numZeros;

        return sum - k;
    }
}
