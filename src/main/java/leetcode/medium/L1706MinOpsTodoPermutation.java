package leetcode.medium;

public class L1706MinOpsTodoPermutation {

    public static void main(String[] args) {
//        System.out.println(new L1706MinOpsTodoPermutation().reinitializePermutation(2));
        System.out.println(new L1706MinOpsTodoPermutation().reinitializePermutation(4));
        System.out.println(new L1706MinOpsTodoPermutation().reinitializePermutation(6));
        System.out.println(new L1706MinOpsTodoPermutation().reinitializePermutation(1000));
        System.out.println(new L1706MinOpsTodoPermutation().reinitializePermutation(90));
        System.out.println(new L1706MinOpsTodoPermutation().reinitializePermutation(130));
        System.out.println(new L1706MinOpsTodoPermutation().reinitializePermutation(150));
        System.out.println(new L1706MinOpsTodoPermutation().reinitializePermutation(290));
    }

    public int reinitializePermutation(int n) {

        if( n < 4 ) return 1;

        int ops = 1;
        int i = 2;

        while( i != 1 ){
            if( i <= (n-1)/2 ){
                i = 2*i;
            }

            else{
                i = 2*i+1-n;
            }

            ops++;
        }

        return ops;
    }

}
