package leetcode.easy;

import java.util.*;

//[40,10,20,30]
//[100,100,100]
//[37,12,28,9,100,56,80,5,12]
//[37,12,28,9,100,2,2,2,2,56,80,5,12]
//[1]
//[]
public class L1331RankTransformOfArr {

    public int[] arrayRankTransform(int[] arr) {
        int[] rankArr = new int[arr.length];

        Integer[] sortedArr = new Integer[arr.length];
        for( int i = 0; i < arr.length; i++ ){
            sortedArr[i] = arr[i];
        }
        HashSet<Integer> set = new HashSet<Integer>(Arrays.asList(sortedArr));
        sortedArr = set.toArray(new Integer[set.size()]);
        Arrays.sort(sortedArr);

        for( int i = 0; i < arr.length; i++ ){
            rankArr[i] = Arrays.binarySearch(sortedArr, arr[i])+1;
        }

        return rankArr;
    }
}
