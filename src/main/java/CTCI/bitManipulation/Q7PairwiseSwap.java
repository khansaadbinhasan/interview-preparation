package CTCI.bitManipulation;

public class Q7PairwiseSwap {

    public static void main(String[] args) {
        System.out.println(swapOddEvenBits(23));
        System.out.println(swapOddEvenBits2(23));
        System.out.println(pairwiseSwap(23));
//        System.out.println(Integer.toBinaryString(23));
//        System.out.println(Integer.toBinaryString(43));
//        System.out.println(Integer.toBinaryString(53));
    }

    static int swapOddEvenBits(int x){
        return ((x >>> 1) & 0x55555555) | ((x << 1) & 0xaaaaaaaa);
    }

    public static int swapOddEvenBits2(int x) {
        return ( ((x & 0xaaaaaaaa) >>> 1) | ((x & 0x55555555) << 1) );
    }


    public static int pairwiseSwap(int n){
        int num = 0;
        while( n != 0 ){
            int n0 = n&1;
            n = n >> 1;
            int n1 = n&1;
            n = n >> 1;

            num = num << 1;
            num += n1;
            num = num << 1;
            num += n0;
        }

        while( num != 0 ){
            n = n << 1;
            n += num&1;
            num = num >> 1;
        }

        return n;
    }

}
