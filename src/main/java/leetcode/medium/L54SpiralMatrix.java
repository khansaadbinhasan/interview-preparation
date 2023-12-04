package leetcode.medium;

import java.util.*;

//[[1,2,3],[4,5,6],[7,8,9]]
//[[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//[[1,2,3,4],[5,6,7,8],[9,10,11,12],[9,10,11,12]]
//[[1,2,3,4],[1,2,3,4],[5,6,7,8],[9,10,11,12],[9,10,11,12]]
//[[1,2,3,4],[5,6,7,8],[1,2,3,4],[9,10,11,12],[9,10,11,12]]
//[[1,2,3,4,2,3,4],[5,6,7,8,2,3,4],[1,2,3,4,2,3,4],[9,10,11,12,2,3,4],[9,10,11,12,2,3,4]]
//[[1]]
//[[1,2,3,4,5]]
public class L54SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {

        int i = 0;
        int j = 0;

        List<Integer> lst = new LinkedList<>();

        lst.add(matrix[i][j]);


        int M = matrix.length;
        int N = matrix[0].length;

        int numElems = M*N;

        int numK = Math.min(M, N)-1;

        numK = numK < 1 ? 1: numK;

        for( int k = 0; k < numK; k++ ){
            while( j < matrix[i].length-1-k && lst.size() < numElems ) lst.add(matrix[i][++j]);
            while( i < matrix.length-1-k && lst.size() < numElems ) lst.add(matrix[++i][j]);
            while( j > 0+k && lst.size() < numElems ) lst.add(matrix[i][--j]);
            while( i > 1+k && lst.size() < numElems ) lst.add(matrix[--i][j]);
        }

        return lst;
    }


}
