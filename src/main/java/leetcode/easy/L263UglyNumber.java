package leetcode.easy;

//6
//1
//14
//100
//2147483647
//-2147483647
//-2147483648
public class L263UglyNumber {

    public static void main(String[] args) {
        new L263UglyNumber().run();
    }

    public void run(){
        System.out.println(isUgly(1772391175));
    }

    public boolean isUgly(int n) {

        if( n <= 0 ) return false;

        while( n % 2 == 0 ) n = n / 2;
        while( n % 3 == 0 ) n = n / 3;
        while( n % 5 == 0 ) n = n / 5;

        return n==1;
    }
}
