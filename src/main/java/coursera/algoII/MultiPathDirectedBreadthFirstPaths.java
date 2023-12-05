package coursera.algoII;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class MultiPathDirectedBreadthFirstPaths {

    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    public MultiPathDirectedBreadthFirstPaths(Digraph G, List<Integer> s){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];

        bfs(G, s);
    }

    private void bfs(Digraph G, List<Integer> sList){
        Queue<Integer> q = new LinkedList<>(sList);

        for( int s: sList ){
            marked[s] = true;
        }

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
