package leetcode.easy;

//0
//1
//2
//3
//4
//5
//6
//7
//30
public class L509Fibonacii {

    public int fib(int n) {

        if( n == 0 ) return 0;
        if( n == 1 ) return 1;


        int fib0 = 0;
        int fib1 = 1;

        int fib2 = 1;

        for( int i = 2; i <= n; i++ ){

            fib2 = fib0 + fib1;

            fib0 = fib1;
            fib1 = fib2;
        }

        return fib2;
    }

}
