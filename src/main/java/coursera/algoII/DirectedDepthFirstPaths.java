package coursera.algoII;

import java.util.Stack;

public class DirectedDepthFirstPaths {

    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    public DirectedDepthFirstPaths(Graph G, int s){
        marked = new boolean[100];
        edgeTo = new int[100];

        dfs(G, s);
    }

    private void dfs(Graph G, int v){
        marked[v] = true;

        for( int w: G.adj(v) ){
            if( !marked[w] ) {
                dfs(G, w);
                edgeTo[w] = v;
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
