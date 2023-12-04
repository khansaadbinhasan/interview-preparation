package codingBlocks.arrays;

public class QuickSort {

    public static void main(String[] args) {
        run();
    }

    public static void run(){
        int[] Arr = new int[]{5, 1, 0, 7, 2, 3};

        System.out.println("Initial Arr: ");

        for (int elem : Arr) {
            System.out.print(elem + " ");
        }

        System.out.println();

        quickSort(Arr, 0, Arr.length-1);

        System.out.println("\nQuick Sorted Arr: ");

        for (int elem : Arr) {
            System.out.print(elem + " ");
        }
    }

    public static void quickSort(int[] array, int low, int high) {

        if (low < high) {
            int pivotIndex = getPivotIndex(array, low, high);

            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static int getPivotIndex(int[] array, int low, int high){
        int pivotIndex = low-1;
        int pivot = array[high];

        int i;

        for (i = low; i < high; i++) {
            if( array[i] < pivot ){
                pivotIndex++;
                swap(array, pivotIndex, i);
            }
        }

        swap(array, pivotIndex+1, high);

        return pivotIndex+1;
    }

}
