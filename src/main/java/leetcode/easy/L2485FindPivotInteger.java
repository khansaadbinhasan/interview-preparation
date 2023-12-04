package leetcode.easy;

//121
//-121
//10
//-101
//0
//-2147483647
//2147483646
public class L2485FindPivotInteger {

    public int pivotInteger(int n) {
        double sqrt = Math.sqrt(n*(n+1) / 2);
        int pivot = (int) sqrt;

        if( (int) Math.ceil(sqrt) == pivot ) return pivot;

        return -1;
    }
}
