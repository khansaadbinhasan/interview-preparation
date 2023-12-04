package CTCI.bitManipulation;

public class Q1InsertMintoN {

    public static void main(String[] args) {
        new Q1InsertMintoN().run();
    }

    public void run(){

        int N = 1024;
        int M = 19;
        int i = 2;
        int j = 6;

//        System.out.println(~0);

        System.out.println(updateBits(N, M, i, j));
    }

    int updateBits(int N, int M, int i, int j){

        int firstIBitsOneMask = ~(-1 << i);
        int firstJBitsZeroMask = (-1 << (j+1));

        int mask = firstJBitsZeroMask | firstIBitsOneMask;

        M = M << i;

        return (mask & N) | M;
    }

}
