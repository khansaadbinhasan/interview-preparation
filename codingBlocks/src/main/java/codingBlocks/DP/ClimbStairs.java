package codingBlocks.DP;

import java.util.Scanner;

public class ClimbStairs {

    public static void main(String[] args) {
        new ClimbStairs().run();
    }

    public void run(){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(climbStairs(n));
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

}
