package leetcode.easy;

public class L1009ComplementOfBase10Int {
    public int bitwiseComplement(int n) {
        int num = (int) Math.pow(2, Integer.toBinaryString(n).length())-1;
        return (~n)&num;
    }
}
