package leetcode.easy;

import java.util.*;

//[[1,2,4],[3,3,1]]
//[[10]]
//[[1,2,4],[3,1,1],[3,11,1],[3,10,1]]
public class L2500DeleteGreatestValEachRow {

    public int deleteGreatestValue(int[][] grid) {

        int sum = 0;

        List<PriorityQueue<Integer>> pqList = new LinkedList<>();

        for( int i = 0; i < grid.length; i++ ){
            pqList.add(new PriorityQueue<>());
            for( int j = 0; j < grid[i].length; j++ ){
                pqList.get(i).add(grid[i][j]);
            }
        }

        while( !pqList.get(0).isEmpty() ){
            int max = pqList.get(0).peek();
            for( int i = 0; i < grid.length; i++ ){
                max = Math.max(pqList.get(i).poll(), max);
            }

            sum += max;
        }


        return sum;
    }

}
