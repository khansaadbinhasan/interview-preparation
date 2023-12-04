package leetcode.easy;

//16
//5
//1
//2147483647
//-2147483647
//-2147483648
//-1
//0
//100
//22
//35
//10000
//87878
//-443
//87
//54
public class L342Pow4 {

    public boolean isPowerOfFour(int n) {

        double pow4 = 1;
        int i = 0;

        while( pow4 <= n ){
            pow4 = Math.pow(4, i);
            if( n == pow4 ) return true;
            i++;
        }

        return false;
    }
}
