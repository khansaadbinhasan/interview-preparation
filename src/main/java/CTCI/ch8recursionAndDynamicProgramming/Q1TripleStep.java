package CTCI.ch8recursionAndDynamicProgramming;

public class Q1TripleStep {

    int[] dp;

    public int numSteps(int currStep){
        dp = new int[Math.max(3,currStep)+1];

        dp[1] = 1; dp[2] = 2; dp[3] = 4;

        for( int i = 4; i <= currStep; i++ ){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        return dp[currStep];
    }

    public int numSteps2(int currStep){
        int step1 = 0;
        int step2 = 0;
        int step3 = 0;
        int steps = 0;

        for( int i = 1; i <= currStep; i++ ){
            steps = step1+step2+step3;
        }

        return steps;
    }


    public static void main(String[] args) {
        new Q1TripleStep().run();
    }

    public void run(){
        System.out.println(numSteps(1));
        System.out.println(numSteps(2));
        System.out.println(numSteps(3));
        System.out.println(numSteps(4));
        System.out.println(numSteps(5));
    }

}
