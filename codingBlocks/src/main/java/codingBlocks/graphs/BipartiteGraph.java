package codingBlocks.graphs;

import java.util.*;

//[[1,2,3],[0,2],[0,1,3],[0,2]]
//[[1,3],[0,2],[1,3],[0,2]]
//[[1,2],[0,4,5],[0,3,5],[2,4,5],[1,3,5],[0,1,2,3,4]]
//[[1],[0,3],[3],[1,2]]

public class BipartiteGraph {

    public static void main(String[] args) {
        new BipartiteGraph().run();
    }

    public void run(){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] graph = new int[N][2];

        for (int i = 0; i < N; i++) {
            graph[i][0] = sc.nextInt();
            graph[i][1] = sc.nextInt();
        }

        System.out.println(isBipartite(graph) ? 1: 0);

    }

//    public boolean isBipartite(int[][] graph) {
//
//        Set<Integer> set1 = new HashSet<>();
//        Set<Integer> set2 = new HashSet<>();
//
//        int n = graph.length;
//
//        for( int i = 0; i < n; i++ ){
//            if( set2.contains(i) ){
//                for( int j = 0; j < graph[i].length; j++ ){
//                    if( set2.contains(graph[i][j]) ) return false;
//
//                    set1.add(graph[i][j]);
//
//                    for( int k = 0; k < graph[graph[i][j]].length; k++ ){
//                        set2.add(graph[graph[i][j]][k]);
//                    }
//                }
//
//                continue;
//            }
//
//            set1.add(i);
//
//            for( int j = 0; j < graph[i].length; j++ ){
//                set2.add(graph[i][j]);
//            }
//        }
//
//        return true;
//    }

    public boolean isBipartiteSetApproach(int[][] graph) {

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        int n = graph.length;

        for( int i = 0; i < n; i++ ){

            boolean isAddedToSet1 = addToSet1(i, set1, set2, graph);

            if(!isAddedToSet1) return false;
        }

        return true;
    }



    public boolean addToSet1(int node, Set<Integer> set1, Set<Integer> set2, int[][] graph){
        if( set1.contains(node) || set2.contains(node) ) return true;

        set1.add(node);

        for (int i = 0; i < graph[node].length; i++) {
            if( set1.contains(graph[node][i]) ) return false;

            boolean isAdded = addToSet2(graph[node][i], set1, set2, graph);

            if( !isAdded ) return false;
        }

        return true;
    }

    public boolean addToSet2(int node, Set<Integer> set1, Set<Integer> set2, int[][] graph){
        if( set1.contains(node) || set2.contains(node) ) return true;

        set2.add(node);

        for (int i = 0; i < graph[node].length; i++) {
            if( set2.contains(graph[node][i]) ) return false;

            boolean isAdded = addToSet1(graph[node][i], set1, set2, graph);

            if( !isAdded ) return false;
        }

        return true;
    }

    public boolean helper(int i, int[][] graph, int[] cl){
        Queue<Integer> bfs = new LinkedList<>();

        bfs.add(i);

        cl[i] = 1;

        while( !bfs.isEmpty() ){
            int curr = bfs.poll();

            for(int neigh: graph[curr]){
                if( cl[neigh] != 0 ) {
                    if( curr != neigh && cl[curr] == cl[neigh] ) return false;

                    else {
                        cl[neigh] = -cl[curr];
                        bfs.add(neigh);
                    }
                }
            }
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        int[] cl = new int[n];

        for (int i = 0; i < n; i++) {
            if( cl[i] == 0 ) continue;

            if( !helper( i, graph, cl ) ) return false;
        }

        return true;
    }


}
