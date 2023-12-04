package codingBlocks.heap;

import java.util.*;

public class MergeKSortedArrs {

    public static void main(String[] args) {
        new MergeKSortedArrs().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[][] arr = new int[N][K];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        mergeKArrays(arr, K).forEach(val -> System.out.print(val +  " "));
    }

    public ArrayList<Integer> mergeKArrays(int[][] arr, int K){

        ArrayList<Integer> ansLst = new ArrayList<>();

        List<int[]> lst = new LinkedList<>(Arrays.asList(arr));

        int pointer = 0;

        while( pointer + 1 < lst.size() ){
            lst.add(mergeTwoArrays(lst.get(pointer), lst.get(pointer+1)));
            pointer+=2;
        }

        for (int j = 0; j < lst.get(lst.size() - 1).length; j++) {
            ansLst.add(lst.get(lst.size() - 1)[j]);
        }

        return ansLst;
    }

    public int[] mergeTwoArrays( int[] arr1, int[] arr2 ){

        int pointer1 = 0;
        int pointer2 = 0;
        int pointer = 0;

        int[] arr = new int[arr1.length+arr2.length];

        while( pointer1 < arr1.length && pointer2 < arr2.length && pointer < arr.length ){
            if( arr1[pointer1] < arr2[pointer2] ) {
                arr[pointer] = arr1[pointer1];
                pointer1++;
            }

            else {
                arr[pointer] = arr2[pointer2];
                pointer2++;
            }

            pointer++;
        }

        while( pointer1 < arr1.length && pointer < arr.length ){
            arr[pointer] = arr1[pointer1];
            pointer1++;
            pointer++;
        }

        while( pointer2 < arr2.length && pointer < arr.length ){
            arr[pointer] = arr2[pointer2];
            pointer2++;
            pointer++;
        }

        return arr;
    }

}
