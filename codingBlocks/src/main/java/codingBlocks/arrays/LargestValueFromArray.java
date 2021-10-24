package codingBlocks.arrays;

import java.util.*;

public class LargestValueFromArray {
    public static void main(String[] args) {
        new LargestValueFromArray().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        List<String> stringList = new ArrayList<>();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();

            int[] inpArr = new int[N];

            for (int j = 0; j < N; j++) {
                inpArr[j] = sc.nextInt();
            }

            stringList.add(getLargestVal(inpArr));
        }

        for (String elem :
                stringList) {
            System.out.println(elem);
        }
        System.out.println();
    }

    public String getLargestVal(int[] inpArr){

        String[] newArr = new String[inpArr.length];

        for (int i = 0; i < inpArr.length; i++) {
            newArr[i] = String.valueOf(inpArr[i]);
        }

        quickSort(newArr, 0, newArr.length-1);

        String largestVal = "";

        for (String elem : newArr) {

            if( largestVal.equals("0") && elem.equals("0") ){
                continue;
            }


            largestVal += elem;
        }

        return largestVal;
    }

    public void quickSort(String[] arr, int low, int high){
        if( low < high ){

            int pivotIndex = getPivotIndex(arr, low, high);

            quickSort(arr, low, pivotIndex-1);
            quickSort(arr, pivotIndex+1, high);
        }
    }

    public int getPivotIndex(String[] arr, int low, int high){
        String pivot = arr[high];
        int pivotIndex = low - 1;

        for (int i = low; i < high; i++) {
            if( !isArrIlessThanPivot(arr[i], pivot) ){
                pivotIndex++;
                swap(arr, pivotIndex, i);
            }
        }

        swap(arr, pivotIndex+1, high);

        return pivotIndex + 1;
    }

    public boolean isArrIlessThanPivot(String arrI, String pivot){
        return ( (arrI+pivot).compareTo(pivot+arrI) < 0 );
    }

    public void swap(String[] arr, int i, int j){
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
