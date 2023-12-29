package leetcode.blind75;

public class L70ClimbingStairs {

    public static void main(String[] args) {
        new L70ClimbingStairs().run();
    }

    public void run(){
        System.out.println(climbStairs2(5));
    }

    public int climbStairs2(int n){
        int a = n-1;
        int b = 1;
        int c = 0;

        while( b < a ){
            c += comb(a, b);
            a--;
            b++;
        }

        return c+1;
    }

    public int comb(int a, int b){
        return fact(a) / fact(a-b);
    }

    public int fact(int n){
        if( n < 2 ) return 1;

        int fact = 1;

        for( int i = 1; i <= n; i++ ){
            fact *= i;
        }

        return fact;
    }

    public int climbStairs(int n){

        if( n < 3 ) return n;

        int p1 = 1;
        int p2 = 2;

        int numWays = p1+p2;

        for (int i = 2; i < n; i++) {
            numWays = p1 + p2;

            p1 = p2;
            p2 = numWays;
        }

        return numWays;
    }

    public int climbStairsDP(int n){

        if( n < 2 ) return 1;

        int[] ways = new int[n+1];

        ways[1] = 1;
        ways[2] = 2;

        for( int i = 3; i < ways.length; i++ ){
            ways[i] = ways[i-1] + ways[i-2];
        }

        return ways[n];
    }

}
