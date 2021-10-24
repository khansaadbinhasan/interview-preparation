package leetcode.easy;

import java.util.*;

//[[3,7,8],[9,11,13],[15,16,17]]
//[[1,10,4,2],[9,3,8,7],[15,16,17,12]]
//[[7,8],[1,2]]
//[[1]]
//[[1,2],[3,4]]
public class L1380LuckyNumbers {

    public List<Integer> luckyNumbers (int[][] matrix) {

        List<Integer> lst = new LinkedList<>();


        int[] luckyRows = new int[matrix.length];

        for( int i = 0; i < matrix.length; i++ ){
            luckyRows[i] = findMin(matrix[i]);
        }

        int[] luckyCols = new int[matrix[0].length];

        for( int i = 0; i < matrix[0].length; i++ ){
            luckyCols[i] = findMax(matrix, i);
        }

        for( int i = 0; i < luckyRows.length; i++ ){
            for( int j = 0; j < luckyCols.length; j++ ){
                if( luckyRows[i] == luckyCols[j] ) lst.add(luckyRows[i]);
            }
        }

        return lst;
    }

    public int findMin(int[] nums){

        int min = nums[0];

        for(int num: nums){
            min = Math.min(min, num);
        }

        return min;
    }

    public int findMax(int[][] mat, int col){

        int max = mat[0][col];

        for(int i = 1; i < mat.length; i++){
            max = Math.max(max, mat[i][col]);
        }

        return max;
    }


}
