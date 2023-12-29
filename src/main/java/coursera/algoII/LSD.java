package coursera.algoII;

import java.util.Arrays;

public class LSD {

    String[] array;

    public static void main(String[] args) {
        new LSD().run();
    }

    public void run(){
        array = new String[]{"dab", "cab", "fad", "bad", "dad", "ebb", "ace", "add", "feb", "bed", "fee", "bee"};
        String[] sortedStart = new String[]{"ace", "add", "bad", "bed", "bee", "cab", "dab", "dad", "ebb", "fad", "feb", "fee"};
        String[] sortedEnd = new String[]{"dab", "cab", "ebb", "feb", "fad", "bad", "dad", "add", "bed", "ace", "fee", "bee"};

        System.out.println(Arrays.equals(lsdRadixSort(array, 0), sortedStart));
        System.out.println(Arrays.equals(lsdRadixSort(array, array.length-1), sortedEnd));
    }

    public String[] lsdRadixSort(String[] array, int index){
        //Do radix sort of given index
        int[] count = new int[6];




        return array;
    }

}
