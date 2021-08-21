package arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//6
//1 2 3 56 57 8

public class FindTheRanges {

    public static void main(String[] args) {
        new FindTheRanges().run();
    }

    public void run(){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) arr[i] = sc.nextInt();

//        List<Integer[]> rangesList = findTheRanges(arr);

//        for(Integer[] range: rangesList)
//            System.out.print(range[0] + "->" + range[1] + " ");
//
//        System.out.println();

        List<String> rangesListStr = summaryRanges(arr);

        for( String range: rangesListStr ) System.out.println(range);

    }

    public List<Integer[]> findTheRanges(int[] arr){

        List<Integer[]> rangesArr = new ArrayList<>();

        int rangeStart = arr[0];
        int rangeEnd = arr[0];

        for (int i = 0; i < arr.length - 1; i++) {

            if( arr[i+1] - arr[i] != 1 ) {
                rangesArr.add(new Integer[]{rangeStart, rangeEnd});
                rangeStart = arr[i+1];
            }

            rangeEnd = arr[i+1];
        }


        if( rangeEnd == arr[arr.length - 1] ) rangesArr.add(new Integer[]{rangeStart, rangeEnd});
        
        return rangesArr;
    }

    public List<String> summaryRanges(int[] nums) {

        if( nums.length == 0 ) return new ArrayList<>();

        List<String> rangesList = new LinkedList<>();

        int rangeStart = nums[0];
        int rangeEnd = nums[0];

        for (int i = 0; i < nums.length - 1; i++) {

            if( nums[i+1] - nums[i] != 1 ) {

                if( rangeStart == rangeEnd )
                    rangesList.add(rangeStart + "");

                else
                    rangesList.add(rangeStart + "->" + rangeEnd);


                rangeStart = nums[i+1];
            }

            rangeEnd = nums[i+1];
        }


        if( rangeStart == rangeEnd )
            rangesList.add(rangeStart + "");

        else
            rangesList.add(rangeStart + "->" + rangeEnd);

        return rangesList;
    }

}
