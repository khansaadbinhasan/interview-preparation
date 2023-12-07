package coursera.algoII;

import coursera.algoII.datastructures.Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirstPaths {

    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    public BreadthFirstPaths(Graph G, int s){
        marked = new boolean[100];
        edgeTo = new int[100];

        bfs(G, s);
    }

    private void bfs(Graph G, int s){
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        marked[s] = true;

        while( !q.isEmpty() ){
            int v = q.poll();

            for( int w: G.adj(v) ){
                if( !marked[w] ) {
                    q.add(w);
                    edgeTo[w] = v;
                    marked[w] = true;
                }
            }
        }
    }

    //Is there a path from s to v
    boolean hasPathTo(int v){
        return marked[v];
    }

    Iterable<Integer> pathTo(int v){

        if( !hasPathTo(v) ) return null;

        Stack<Integer> path = new Stack<>();

        for (int x = v; x != s; x=edgeTo[x]) {
            path.push(x);
        }

        path.push(s);

        return path;
    }

    public String toString(int v){
        StringBuilder pathsStr = new StringBuilder();
//        DepthFirstPaths paths = new DepthFirstPaths(G, s);
//
//        for (int v = 0; v < G.V(); v++) {
//            if( paths.hasPathTo(v) ){
//                pathsStr.append(v).append("\n");
//            }
//        }
//
//        return pathsStr.toString();

        for( int p: pathTo(v) ){
            pathsStr.append(p).append(">-");
        }

        pathsStr.delete(pathsStr.length()-2, pathsStr.length());

        return pathsStr.reverse().toString();
    }


}
