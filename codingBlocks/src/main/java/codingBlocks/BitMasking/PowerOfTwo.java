package codingBlocks.BitMasking;

import java.util.Scanner;

public class PowerOfTwo {

    public static void main(String[] args) {
        new PowerOfTwo().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(isPowerOfTwo(n));
    }

    public boolean isPowerOfTwo(int n) {
        return Integer.toBinaryString(n).replaceFirst("1", "0").contains("1");
    }

}
