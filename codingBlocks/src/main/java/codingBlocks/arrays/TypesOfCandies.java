package codingBlocks.arrays;

import java.util.*;

public class TypesOfCandies {

    public static void main(String[] args) {
        run();
    }

    public static void run(){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        List<Integer> array = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int inpNum = sc.nextInt();

            if( !containsNum(array, inpNum) ){
                array.add(inpNum);
            }

        }

        if( array.size() > N / 2 ){
            System.out.println(N / 2);
        }

        if( array.size() < N / 2 ){
            System.out.println(array.size());
        }

    }

    public static boolean containsNum(List<Integer> array, int num){
        for (int i = 0; i < array.size(); i++) {
            if( array.get(i) == num )
                return true;
        }

        return false;
    }

}
