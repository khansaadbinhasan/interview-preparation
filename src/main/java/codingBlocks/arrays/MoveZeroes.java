package codingBlocks.arrays;

import java.util.*;

public class MoveZeroes {

    public static void main(String[] args) {
        run();
    }

    public static void run(){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        List<Integer> array = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int inpNum = sc.nextInt();
            array.add(inpNum);
        }

        array = moveZeroes(array);

        for(int a: array)
            System.out.print(a + " ");
    }

    public static List<Integer> moveZeroes(List<Integer> array){

        //initialize values
        int swapIndexZero = 0;
        int swapIndexNonZero = 0;

        while( swapIndexZero < array.size() - 1 )
        {
            List<Integer> swappedNums = getSwapIndexes(array, swapIndexZero);
            swapIndexZero = swappedNums.get(0);
            swapIndexNonZero = swappedNums.get(1);

            if( swapIndexZero == swapIndexNonZero )
                break;

            array = swap(array, swapIndexZero, swapIndexNonZero);
            swapIndexZero++;
        }

        return array;
    }

    public static List<Integer> swap(List<Integer> array, int num1, int num2){

        int temp = array.get(num1);
        array.set(num1, array.get(num2));
        array.set(num2, temp);

        return array;
    }

    public static List<Integer> getSwapIndexes(List<Integer> array, int swapIndexZero){
        int swapIndexNonZero = 0;

        for (int i = swapIndexZero; i < array.size(); i++) {
            if( array.get(i) == 0 ){
                swapIndexZero = i;
                swapIndexNonZero = getLastSwapIndexZero(array, swapIndexZero);
                break;
            }
        }

        return Arrays.asList(swapIndexZero, swapIndexNonZero);
    }

    public static int getLastSwapIndexZero(List<Integer> array, int swapIndexZero){

        while( swapIndexZero < array.size() - 1 && array.get(swapIndexZero) == 0 ){
            swapIndexZero++;
            System.out.print(swapIndexZero + " ");
        }

        System.out.println();

        return swapIndexZero;
    }

}
