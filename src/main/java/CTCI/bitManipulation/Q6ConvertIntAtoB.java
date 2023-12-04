package CTCI.bitManipulation;

public class Q6ConvertIntAtoB {

    public static void main(String[] args) {
        new Q6ConvertIntAtoB().run();
    }

    public void run(){
        System.out.println(numBitsToFlip(7,10));
    }

    public int numBitsToFlip(int A, int B){

        int cloneA = A;
        int cloneB = B;

        while( cloneA > 0 && cloneB > 0 ){
            cloneA = cloneA >> 1;
            cloneB = cloneB >> 1;
        }

        int clone = cloneA > 0? A: B;

        cloneA = A;
        cloneB = B;

        int numBitsToFlip = 0;

        while( clone > 0 ){
            if( (cloneA & 1) != (cloneB & 1) ) numBitsToFlip++;

            clone = clone >> 1;

            cloneA = cloneA >> 1;
            cloneB = cloneB >> 1;
        }

        return numBitsToFlip;
    }

}
