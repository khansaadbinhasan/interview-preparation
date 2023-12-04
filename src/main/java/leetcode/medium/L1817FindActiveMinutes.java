package leetcode.medium;

import java.util.*;

//[[0,5],[1,2],[0,2],[0,5],[1,3]]
//5
//[[1,1],[2,2],[2,3]]
//4
public class L1817FindActiveMinutes {

    public static void main(String[] args) {
        new L1817FindActiveMinutes().run();
    }

    public void run(){
        System.out.println(Arrays.toString(findingUsersActiveMinutes(new int[][]{{0,5},{1,2},{0,2},{0,5},{1,3}}, 5)));
    }

    public int[] findingUsersActiveMinutes(int[][] logs, int k) {

        Map<Integer, Set<Integer>> uam = new HashMap<>();

        for( int i = 0; i < logs.length; i++ ){
            if( !uam.containsKey(logs[i][0]) ){
                uam.put(logs[i][0], new HashSet<>());
            }

            uam.get(logs[i][0]).add(logs[i][1]);
        }

        int[] ans = new int[k];

        for( int key: uam.keySet() ){
            ans[uam.get(key).size()-1]++;
        }

        return ans;
    }
}
