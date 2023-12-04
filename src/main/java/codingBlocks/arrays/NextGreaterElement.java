package codingBlocks.arrays;

import java.util.Scanner;

//12
//21
//862547
//89678965
//2147483647
//839264823
//100
//298654321
//123456789
//230241

public class NextGreaterElement {

    public static void main(String[] args) {
        new NextGreaterElement().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int prev = nextGreaterElement(N);
        System.out.println(prev);
    }

    public int nextGreaterElement(int n) {
        char[] num = String.valueOf(n).toCharArray();

        for (int i = num.length-2; i >= 0; i--) {
            for (int j = num.length-1; j >= i; j--) {

                if( num[j] > num[i] ) {
                    char temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;


                    for (int k = num.length-2; k > i ; k--) {
                        for (int l = num.length-1; l >= k ; l--) {
                            if( num[k] > num[l] ) {
                                temp = num[l];
                                num[l] = num[k];
                                num[k] = temp;
                            }
                        }
                    }

                    if( Long.parseLong(String.valueOf(num)) > Integer.MAX_VALUE ) return -1;
                    return Integer.parseInt(String.valueOf(num));
                }
            }
        }

        return -1;
    }

}
