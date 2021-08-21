package arrays;

import java.util.*;

public class AttendAllMeetings {

    public static void main(String[] args) {
        new AttendAllMeetings().run();
    }



//    public static void run(){
//        Scanner sc = new Scanner(System.in);
//
//        int N = sc.nextInt();
//        int[][] array = new int[2][N];
//
//        for (int i = 0; i < N; i++) {
//            int start = sc.nextInt();
//            int end = sc.nextInt();
//
//            array[0][i] = start;
//            array[1][i] = end;
//        }
//
//        quickSort(array, 0, array[0].length-1);
//        System.out.println(possibleToAttendAllMeetings(array));
//    }
//
//    public static boolean possibleToAttendAllMeetings(int[][] array){
//        for (int i = 1; i < array[0].length; i++) {
//            if( array[0][i] < array[1][i-1] )
//                return false;
//        }
//
//        return true;
//    }
//
//    public static void quickSort(int[][] array, int low, int high) {
//
//        if (low < high) {
//            int pivotIndex = getPivotIndex(array, low, high);
//
//            quickSort(array, low, pivotIndex - 1);
//            quickSort(array, pivotIndex + 1, high);
//        }
//    }
//
//    public static void swap(int[][] array, int i, int j){
//        int temp = array[0][i];
//        array[0][i] = array[0][j];
//        array[0][j] = temp;
//
//        temp = array[1][i];
//        array[1][i] = array[1][j];
//        array[1][j] = temp;
//    }
//
//    public static int getPivotIndex(int[][] array, int low, int high){
//        int pivotIndex = low-1;
//        int pivot = array[0][high];
//
//        for (int i = low; i < high; i++) {
//            if( array[0][i] < pivot ){
//                pivotIndex++;
//                swap(array, pivotIndex, i);
//            }
//        }
//
//        swap(array, pivotIndex+1, high);
//
//        return pivotIndex+1;
//    }


    public void run(){
        int[][] events = {{1,2},{2,3},{3,4}};

        System.out.println(maxEvents(events));
    }

    public int maxEvents(int[][] events) {

        int numEvents = 0;

        quickSort(events, 0, events.length-1);

//        for (int[] elem : events) {
//            System.out.print(elem[0] + " ");
//        }
//
//        System.out.println();

        for (int i = 1; i < events.length; i++) {

            System.out.println(events[i][0] + " " + events[i-1][1]);

            if( events[i][0] >= events[i-1][1] )
                numEvents++;
        }

        return numEvents;
    }

    public void quickSort(int[][] array, int low, int high) {

        if (low < high) {
            int pivotIndex = getPivotIndex(array, low, high);

            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    public void swap(int[][] array, int i, int j){
        int temp = array[i][0];
        array[i][0] = array[j][0];
        array[j][0] = temp;

        temp = array[i][1];
        array[i][1] = array[j][1];
        array[j][1] = temp;
    }

    public int getPivotIndex(int[][] array, int low, int high){
        int pivotIndex = low-1;
        int pivot = array[high][0];

        for (int i = low; i < high; i++) {
            if( array[i][0] < pivot ){
                pivotIndex++;
                swap(array, pivotIndex, i);
            }
        }

        swap(array, pivotIndex+1, high);

        return pivotIndex+1;
    }
}
