package leetcode.easy;


import java.util.*;

//[[1,1],[4,5],[3,8]]
//[[3,1],[1,5]]
//[[1,1],[3,2],[2,3]]
//[[2,1],[3,2],[1,3]]
//[[1,3],[2,2]]
//[[7,1],[2,2],[1,4]]
//[[1000,1000],[1,2]]
//[[1,1],[1000,1000],[5,4]]
public class L2363MergeItems {

    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {

        List<List<Integer>> ret = new LinkedList<>();


        int[] item1Arr = new int[1001];
        int[] item2Arr = new int[1001];

        for( int i = 0; i < items1.length; i++ ){
            item1Arr[items1[i][0]] = items1[i][1];
        }

        for( int i = 0; i < items2.length; i++ ){
            item2Arr[items2[i][0]] = items2[i][1];
        }

        for( int i = 1; i < 1001; i++ ){
            item1Arr[i] += item2Arr[i];

            if(item1Arr[i] != 0){
                ret.add(Arrays.asList(i, item1Arr[i]));
            }
        }

        return ret;
    }
}
