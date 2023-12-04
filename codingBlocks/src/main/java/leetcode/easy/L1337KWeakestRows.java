package leetcode.easy;

import java.util.*;

//[[1,1,0,0,0],[1,1,1,1,0],[1,0,0,0,0],[1,1,0,0,0],[1,1,1,1,1]]
//3
//[[1,0,0,0],[1,1,1,1],[1,0,0,0],[1,0,0,0]]
//2
//[[1,1,0],[1,0,0],[1,0,0],[1,1,1],[1,1,0],[0,0,0]]
//4
public class L1337KWeakestRows {

    public int[] kWeakestRows(int[][] mat, int k) {

        int[] soldiers = new int[mat.length];

        for( int i = 0; i < mat.length; i++ ){
            soldiers[i] = sumRow(mat[i]);
        }

        int[] res = new int[soldiers.length];

        for( int i = 0; i < res.length; i++ ){
            res[i] = i;
        }

//         for( int i = 0; i < soldiers.length-1; i++ ){
//             for( int j = i + 1; j < soldiers.length; j++ ){
//                 if( soldiers[j] < soldiers[i] ){
//                     int temp = soldiers[i];
//                     soldiers[i] = soldiers[j];
//                     soldiers[j] = temp;

//                     temp = res[i];
//                     res[i] = res[j];
//                     res[j] = temp;
//                 }
//             }
//         }

        for( int i = 0; i < soldiers.length-1; i++ ){
            for( int j = 1; j < soldiers.length; j++ ){
                if( soldiers[j] < soldiers[j-1] ){
                    int temp = soldiers[j];
                    soldiers[j] = soldiers[j-1];
                    soldiers[j-1] = temp;

                    temp = res[j-1];
                    res[j-1] = res[j];
                    res[j] = temp;
                }
            }
        }

        return Arrays.copyOf(res, k);

    }

    public int sumRow(int[] nums){
        int sum = 0;

        for( int num: nums ){
            sum += num;
        }

        return sum;
    }

}
