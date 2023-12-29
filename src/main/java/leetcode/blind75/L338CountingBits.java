package leetcode.blind75;

//2
//5
//0
//100000
public class L338CountingBits {

    public int[] countBits(int n) {

        int[] countedBits = new int[n+1];

        for( int i = 0; i <= n; i++ ){
            countedBits[i] = getBits(i);
        }

        return countedBits;
    }

    public int getBits(int n){
        int count = 0;

        while( n > 0 ){
            count += (n&1);
            n = n >> 1;
        }

        return count;
    }

    

}
