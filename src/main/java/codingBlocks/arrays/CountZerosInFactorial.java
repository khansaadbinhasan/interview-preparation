package codingBlocks.arrays;

import java.util.*;

public class CountZerosInFactorial {

    public static void main(String[] args) {
        run();
    }

    public static void run(){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.println(countZeroes(N));
    }

    public static int countZeroes(int N){
//        List<Integer> array = getArrayFromNum(N);
//
//        int count5 = 0;
//        int count2 = 0;
//
//        for (int i = 0; i < array.size(); i++) {
//            count5 += getNCount(array.get(i), 5);
//            count2 += getNCount(array.get(i), 2);
//        }
//
//        return min(count2, count5);

        int count5 = 0;

        for (int i = 0; i <= N; i+=5) {
//            System.out.println(i);
            count5 += getNCount(i, 5);
        }

        return count5;
    }

    public static int min(int num1, int num2){
        if( num1 < num2 ){
            return num1;
        }

        return num2;
    }

    public static int getNCount(int num, int N){
        int Ncount = 0;

        while( num > 0 ){
            if( num % N != 0 ){
                break;
            }

            Ncount++;
            num = num / N;
        }

        return Ncount;
    }

    public static List<Integer> getArrayFromNum(int N){

        List<Integer> array = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            array.add(i);
        }

        return array;

    }

}
