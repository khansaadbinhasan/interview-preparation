package codingBlocks.arrays;

import java.util.Arrays;
import java.util.Scanner;

//3
//1 2 2
//6
//6 6 6 6 6 6
//1
//1
//9
//8 5 7 2 9 13 6 16 70
//9
//8 15 7 2 9 13 6 16 70
public class Candy {

    public static void main(String[] args) {
        new Candy().run();
    }

    public void run(){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] ratings = new int[N];

        for (int i = 0; i < N; i++)
            ratings[i] = sc.nextInt();

        System.out.println(candy(ratings));
    }

    public int candy(int[] ratings) {

        int[] count = new int[ratings.length];
        Arrays.fill(count, 1);

        for (int i = 1; i < ratings.length; i++)
            if( ratings[i] > ratings[i-1] ) count[i] = count[i-1] + 1;

        for (int i = ratings.length-2; i >= 0; i--)
            if( ratings[i] > ratings[i+1] && count[i] <= count[i+1] ) count[i] = count[i+1] + 1;

        int sum = 0;

        for (int i = 0; i < count.length; i++)
            sum += count[i];

        return sum;
    }
}
