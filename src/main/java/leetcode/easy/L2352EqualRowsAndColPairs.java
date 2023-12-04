package leetcode.easy;

import java.util.*;

//[[3,2,1],[1,7,6],[2,7,7]]
//[[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
//[[1]]
//[[1,2],[2,1]]
//[[1,2],[2,3]]
//[[1,1],[1,1]]
public class L2352EqualRowsAndColPairs {

    public int equalPairs(int[][] grid) {

        int count = 0;
        int[][] gridCol = new int[grid[0].length][grid.length];

        List<String> lst1 = new LinkedList<>();
        List<String> lst2 = new LinkedList<>();

        for( int i = 0; i < grid.length; i++ ){
            StringBuilder sb = new StringBuilder();
            for( int j = 0; j < grid[0].length; j++ ){
                sb.append(String.valueOf(grid[i][j]));
                sb.append(",");
            }
            lst1.add(sb.toString());
        }

        for( int j = 0; j < grid[0].length; j++ ){
            StringBuilder sb = new StringBuilder();
            for( int i = 0; i < grid.length; i++ ){
                sb.append(String.valueOf(grid[i][j]));
                sb.append(",");
            }
            lst2.add(sb.toString());
        }


        for( int i = 0; i < lst1.size(); i++ ){
            for( int j = 0; j < lst2.size(); j++ ){
                if( lst1.get(i).equals(lst2.get(j)) ) count++;
            }
        }

        return count;

    }
}
