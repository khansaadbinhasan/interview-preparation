package CTCI.bitManipulation;

public class Q7PairwiseSwap {

    public static void main(String[] args) {
        System.out.println(swapOddEvenBits(23));
    }

    static int swapOddEvenBits(int x){
        return ((x >>> 1) & 0x55555555) | ((x << 1) & 0xaaaaaaaa);
    }
}
