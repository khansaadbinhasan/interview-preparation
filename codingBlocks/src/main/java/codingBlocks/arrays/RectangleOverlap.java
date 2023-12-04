package codingBlocks.arrays;

import java.util.Scanner;

public class RectangleOverlap {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        int R1[] = new int[4];
        int R2[] = new int[4];

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {
            R1[i] = sc.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            R2[i] = sc.nextInt();
        }

        if( isOverlap(R1, R2) ){
            System.out.println(1);
        }

        else {
            System.out.println(0);
        }
    }

    public static boolean isOverlap(int[] R1, int[] R2){
        return R2xbtwR1(R1,R2) && R2ybtwR1(R1, R2);
    }

    public static boolean R2xbtwR1(int[] R1, int[] R2){
        return R2[0] > R1[0] && R2[0] < R1[2] || R2[2] > R1[0] && R2[2] < R1[2];
    }

    public static boolean R2ybtwR1(int[] R1, int[] R2){
        return R2[1] > R1[1] && R2[1] < R1[3] || R2[3] > R1[1] && R2[3] < R1[3];
    }
}
