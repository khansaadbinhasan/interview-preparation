package leetcode.easy;

import java.util.*;

//[15,88]
//[[88],[15]]
//[49,18,16]
//[[16,18,49]]
//[91,4,64,78]
//[[78],[4,64],[91]]
//[1]
//[[1]]
//[2]
//[[1]]
//[1,2]
//[[3],[4]]
public class L1640CheckArrayFormation {

    public boolean canFormArray(int[] arr, int[][] pieces) {

        Map<Integer, int[]> piecesMap = new HashMap<>();

        for( int i = 0; i < pieces.length; i++ ){
            piecesMap.put(pieces[i][0], pieces[i]);
        }

        for( int i = 0; i < arr.length; i++ ){
            if( piecesMap.get(arr[i]) == null ) return false;

            int[] piecesArr = piecesMap.get(arr[i]);
            for( int j = 0; j < piecesArr.length; j++ ){
                if( piecesArr[j] != arr[i] ) return false;

                i++;
            }

            i--;
        }

        return true;

    }
}
