package codingBlocks.stacksAndQueues;

import java.util.Scanner;
import java.util.Stack;

public class DailyTemperatures {

    public static void main(String[] args) {
        new DailyTemperatures().run();
    }

    public void run() {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] temperatures = new int[N];

        for (int i = 0; i < N; i++) {
            temperatures[i] = sc.nextInt();
        }

        for( int days: dailyTemperatures(temperatures) ){
            System.out.print(days + " ");
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {

        int N = temperatures.length;
        int[] answers = new int[N];
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            while( !stack.isEmpty() && temperatures[i] > stack.peek()[1] ){
                int x = stack.peek()[0];
                answers[x] = i - x;
                stack.pop();
            }

            stack.push(new int[]{i, temperatures[i]});
        }

        return answers;
    }

}
