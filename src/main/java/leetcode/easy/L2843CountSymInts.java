package leetcode.easy;

//1
//100
//1200
//1230
//1
//10000
//99
//199
//98
//3222
public class L2843CountSymInts {

    public int countSymmetricIntegers(int low, int high) {

        int symInts = 0;

        for( int i = low; i <= high; i++ ){
            if( isSymInt(i) ) symInts++;
        }

        return symInts;
    }

    public boolean isSymInt(int n){
        int len = String.valueOf(n).length();

        if( len % 2 != 0 ) return false;

        int k = len/2;

        int i = 0;
        int sum1 = 0;
        int sum2 = 0;

        while( i < k ){
            sum2 += n%10;
            n = n / 10;
            i++;
        }

        i = 0;

        while( i < k ){
            sum1 += n%10;
            n = n / 10;
            i++;
        }

        return sum1 == sum2;
    }
}
