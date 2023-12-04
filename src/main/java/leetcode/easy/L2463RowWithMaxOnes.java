package leetcode.easy;

import java.util.LinkedList;
import java.util.List;

//[[0,1],[1,0]]
//[[0,0,0],[0,1,1]]
//[[0,0],[1,1],[0,0]]
//[[0]]
//[[1]]
public class L2463RowWithMaxOnes {

    public int[] rowAndMaximumOnes(int[][] mat) {
        int maxI = 0;
        int max = 0;

        for( int i = 0; i < mat.length; i++ ){
            int sum = 0;

            for( int j = 0; j < mat[i].length; j++ ){
                sum += mat[i][j];
            }

            if( sum > max ){
                max = sum;
                maxI = i;
            }
        }

        return new int[]{maxI, max};

    }
}
