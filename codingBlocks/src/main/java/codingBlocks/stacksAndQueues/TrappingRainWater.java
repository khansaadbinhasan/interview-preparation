package codingBlocks.stacksAndQueues;

import java.util.Scanner;


//6
//4 2 0 3 2 5
public class TrappingRainWater {

    public static void main(String[] args) {
        new TrappingRainWater().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] height = new int[N];

        for (int i = 0; i < N; i++) {
            height[i] = sc.nextInt();
        }

        System.out.println(trap(height));
    }

    public int trap(int[] height){

        if( height.length == 0 ) return 0;

        int waterTrapped = 0;
        int[] left = new int[height.length];
        int[] right = new int[height.length];

        left[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(left[i-1], height[i]);
        }

        right[height.length-1] = height[height.length-1];
        for (int i = height.length-2; i >= 0 ; i--) {
            right[i] = Math.max(height[i], right[i+1]);
        }

        for (int i = 0; i < height.length; i++) {
            waterTrapped += Math.max(0, Math.min(left[i], right[i]) - height[i]);
        }

        return waterTrapped;
    }

}
