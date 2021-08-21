package arrays;

import java.util.*;

public class OverHappyNumbers {

    public static void main(String[] args) {
        run();
    }

    public static void run(){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

//        System.out.println(N);

        List<Integer> array = arrayFromNum(N);

        System.out.println(isOverHappy(array));
    }

    public static List<Integer> arrayFromNum(int N){
        List<Integer> array = new ArrayList<>();

        while( N != 0 ){
            array.add(N % 10);
            N = N / 10;
//            System.out.println(N);
        }

        return array;
    }

    public static boolean isOverHappy(List<Integer> array){

//        System.out.println(array.size());

        if( array.size() == 1 ){
            if( array.get(0) == 1 ){
                return true;
            }

            else {
                return false;
            }
        }

        int newNum = sumOfSquares(array);
        List<Integer> newArr = arrayFromNum(newNum);

        return isOverHappy(newArr);
    }

    public static int sumOfSquares(List<Integer> array){

        int newNum = 0;

        for (int i = 0; i < array.size(); i++) {
            newNum += array.get(i)*array.get(i);
        }

        return newNum;
    }
}
