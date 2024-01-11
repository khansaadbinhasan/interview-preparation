package leetcode.medium;

import java.util.*;

public class L264UglyNumberII {

    public static void main(String[] args) {
        new L264UglyNumberII().run();
    }

    public void run(){
        System.out.println(nthUglyNumber(1690));
    }

    public int nthUglyNumber(int n) {

        long[] seqs = new long[n+1];

        seqs[1] = 1;

        for(int i=2; i <=n; i++){
            long min = Long.MAX_VALUE;
            for(int j = 0; j < i; j++){
                if( seqs[j]*2 > seqs[i-1] ){
                    min = Math.min(seqs[j]*2, min);
                }

                if( seqs[j]*3 > seqs[i-1] ){
                    min = Math.min(seqs[j]*3, min);
                }

                if( seqs[j]*5 > seqs[i-1] ){
                    min = Math.min(seqs[j]*5, min);
                }
            }
            seqs[i] = min;
        }

        return (int) seqs[n];
    }

    public int nthUglyNumber2(int k) {
        if( k < 0 ) return 0;

        long val = 0;

        Queue<Long> q2 = new LinkedList<>();
        Queue<Long> q3 = new LinkedList<>();
        Queue<Long> q5 = new LinkedList<>();

        q2.add(1L);

        for( int i = 1; i <= k; i++ ){
            long v2 = q2.size() > 0? q2.peek(): Long.MAX_VALUE;
            long v3 = q3.size() > 0? q3.peek(): Long.MAX_VALUE;
            long v5 = q5.size() > 0? q5.peek(): Long.MAX_VALUE;

            val = Math.min( v2, Math.min(v3, v5) );

            if( val == v2 ) {
                q2.remove();
                q2.add(2*val);
                q3.add(3*val);
            }

            else if( val == v3 ){
                q3.remove();
                q3.add(3*val);
            }

            else if( val == v5 ){
                q5.remove();
            }

            q5.add(5*val);
        }

        return (int) val;
    }

}
