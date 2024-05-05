package leetcode.medium;

import java.util.*;

//[[2,1],[3,4],[3,2]]
//[[4,-2],[1,4],[-3,1]]
//[[100000,-100000]]
//[[1,2]]
//[[1,2],[2,3],[3,4],[4,5],[5,6],[6,7],[7,8],[8,9],[9,10],[10,11],[11,12]]
//[[-3,-9],[-5,3],[2,-9],[6,-3],[6,1],[5,3],[8,5],[-5,1],[7,2]]
public class L1743RestoreArrayFromAdjacentPairs {

    Set<Integer> visited = new HashSet<>();
    int[] answer;

    public int[] restoreArray(int[][] adjacentPairs) {

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        answer = new int[adjacentPairs.length+1];

        for( int i = 0; i < adjacentPairs.length; i++ ){
            adjList.putIfAbsent(adjacentPairs[i][0], new LinkedList<>());
            adjList.putIfAbsent(adjacentPairs[i][1], new LinkedList<>());
            adjList.get(adjacentPairs[i][0]).add(adjacentPairs[i][1]);
            adjList.get(adjacentPairs[i][1]).add(adjacentPairs[i][0]);
        }


        for( int n: adjList.keySet() ){
            if( adjList.get(n).size() == 1 ) {
                getList(adjList, n, 0);
                break;
            }
        }

        return answer;
    }

    public int[] getList(Map<Integer, List<Integer>> adjList, int n, int i){
        if( i >= answer.length ) return answer;
        answer[i] = n;

        visited.add(n);

        for( int a: adjList.get(n) ){
            if( visited.contains(a) ) continue;
            visited.add(a);
            getList(adjList, a, i+1);
        }

        return answer;
    }

}
