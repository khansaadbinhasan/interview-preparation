package leetcode.easy;

import java.util.*;

//3
//[[0,1],[1,2],[2,0]]
//0
//2
//6
//[[0,1],[0,2],[3,5],[5,4],[4,3]]
//0
//5
//2
//[[0,1]]
//0
//1
//6
//[[0,1],[0,2],[3,5],[5,4],[4,3],[1,4]]
//0
//5
//6
//[[0,1],[0,2],[3,5],[5,4],[4,3],[1,4]]
//1
//5
//6
//[[0,1],[0,2],[3,5],[5,4],[4,3]]
//3
//5
//6
//[[0,1],[0,2],[3,5],[5,4],[4,3]]
//1
//5
//6
//[[0,1],[0,2],[3,5],[5,4],[4,3]]
//0
//2
public class L1971FindIfPathExistsInGraph {

    Set<Integer> visitedVertices = new HashSet<>();

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<Integer>[] adjList = new LinkedList[n];

        for( int i = 0; i < n; i++ ){
            adjList[i] = new LinkedList<>();
        }

        for( int i = 0; i < edges.length; i++ ){
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
        }

        return dfs(adjList, source, destination);
    }

    public boolean dfs(List<Integer>[] adjList, int source, int destination){
        if( source == destination ) return true;
        if( visitedVertices.contains(source) ) return false;

        visitedVertices.add(source);

        for( int i = 0; i < adjList[source].size(); i++ ){
            if( dfs(adjList, adjList[source].get(i), destination) ) return true;
        }

        return false;
    }

}
