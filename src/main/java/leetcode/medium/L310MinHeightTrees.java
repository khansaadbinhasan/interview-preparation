package leetcode.medium;

import java.util.*;

//4
//[[1,0],[1,2],[1,3]]
//6
//[[3,0],[3,1],[3,2],[3,4],[5,4]]
public class L310MinHeightTrees {

    List<Integer> ans = new LinkedList<>();
    Map<Integer, List<Integer>> map = new HashMap<>();
    int n;

    public static void main(String[] args) {
        new L310MinHeightTrees().run();
    }

    public void run(){
//        System.out.println(findMinHeightTrees(4, new int[][]{{1,0},{1,2},{1,3}}));
//        System.out.println(findMinHeightTrees(6, new int[][]{{3,0},{3,1},{3,2},{3,4},{5,4}}));
//        System.out.println(findMinHeightTrees(6, new int[][]{{0,1},{0,2},{0,3},{3,4},{4,5}}));
        System.out.println(findMinHeightTrees3(6, new int[][]{{3,1},{3,2},{3,0},{3,4},{4,5}}));
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        this.n = n;

        //for each node in our map do DFS and find height of tree
        //if height is < min, update the list, if height == min add element to list
        createMap(edges);
        Map<Integer, Integer> heightMap = getHeightMap();
        int minHeight = Integer.MAX_VALUE;

        for( int node: heightMap.keySet() ){
            if( heightMap.get(node) == minHeight ) {
                ans.add(node);
            }

            if( heightMap.get(node) < minHeight ) {
                ans.clear();
                ans.add(node);
                minHeight = heightMap.get(node);
            }
        }

        return ans;
    }

    //Returns a map {node --> height}
    public Map<Integer, Integer> getHeightMap(){
        Map<Integer, Integer> heightMap = new HashMap<Integer, Integer>();

        for( int i = 0; i < n; i++ ){
            heightMap.put(i, getHeight(i));
        }

        return heightMap;
    }

    public int getHeight(int root){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        q.add(root);
        q.add(-1);

        int height = 0;

        while( !q.isEmpty() ){
            int node = q.poll();

            if( node == -1 ) {
                height++;
                if( !q.isEmpty() ) {
                    q.add(-1);
                }
                continue;
            }

            if( visited[node] ) continue;

            visited[node] = true;
            for( int k: map.get(node) ){
                if( !visited[k] ){
                    q.add(k);
                }
            }
        }

        return height;
    }

    //[[1,0],[1,2],[1,3]]
    //{1->[0,2,3],0->[1],2->[1],3->[1]}
    public void createMap(int[][] edges){
        for( int i = 0; i < n; i++ ){
            map.put(i, new LinkedList<>());
        }

        for( int i = 0; i < edges.length; i++ ){
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }
    }


    public List<Integer> findMinHeightTrees2(int n, int[][] edges) {

        List<Integer>[] adjList = new LinkedList[n];

        for( int i = 0; i < n; i++ ){
            adjList[i] = new LinkedList<>();
        }

        for( int i = 0; i < edges.length; i++ ){
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        int minH = Integer.MAX_VALUE;

        for( int i = 0; i < n; i++ ){
            int h = getHeight(adjList, i);
            map.putIfAbsent(h, new LinkedList<>());
            minH = Math.min(h, minH);
            map.get(h).add(i);
        }

        return map.get(minH);
    }

    public int getHeight(List<Integer>[] adjList, int start){
        int height = 0;

        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        q.add(start);
        q.add(-1);

        while( !q.isEmpty() ){
            int v = q.poll();

            if( v == -1 ) {
                height++;
                if( !q.isEmpty() ) q.add(v);
                continue;
            }

            if( visited.contains(v) ) continue;

            visited.add(v);

            for( int elem: adjList[v] ){
                q.add(elem);
            }
        }

        return height;

    }


    public List<Integer> findMinHeightTrees3(int n, int[][] edges) {

        List<Integer>[] adjList = new LinkedList[n];

        for( int i = 0; i < n; i++ ){
            adjList[i] = new LinkedList<>();
        }

        for( int i = 0; i < edges.length; i++ ){
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
        }

        int maxLen = 0;

        for( int i = 0; i < n; i++ ){
            maxLen = Math.max(maxLen, adjList[i].size());
        }

        Set<Integer> removed = new HashSet<>();

        for( int i = 0; i < maxLen; i++ ){
            if( removed.size() >= n-2 ) break;
            if( adjList[i] == null ) continue;

            int[] clone = new int[adjList[i].size()];

            for (int j = 0; j < adjList[i].size(); j++) {
                clone[j] = adjList[i].get(j);
            }

            for( int a: clone ){
                if( removed.contains(a) ){
                    adjList[i].remove(a);
                }
            }


            if( adjList[i].size() == 1 ) {
                adjList[i] = null;
                removed.add(i);
            }
        }

        List<Integer> ans = new LinkedList<>();

        for( int i = 0; i < adjList.length; i++ ){
            List<Integer> v = adjList[i];
            if(v != null) ans.add(i);
        }

        return ans;
    }

}
