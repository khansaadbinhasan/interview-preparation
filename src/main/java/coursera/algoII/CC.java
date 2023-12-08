package coursera.algoII;

import coursera.algoII.datastructures.Graph;

public class CC {

    private boolean[] marked;
    private int s;
    private int[] id;
    private int count;

    public CC(Graph G){
        marked = new boolean[G.V()];
        id = new int[G.V()];

        for (int v = 0; v < G.V(); v++) {
            if( !marked[v] ){
                dfs(G, v);
                count++;
            }
        }
    }

    boolean connected(int v, int w){
        return id[v] == id[w];
    }

    int count(){
        return count;
    }

    int id(int v){
        return id[v];
    }

    private void dfs(Graph G, int v){
        marked[v] = true;
        id[v] = count;

        for( int w: G.adj(v) ){
            if( !marked[w] ) {
                dfs(G, w);
            }
        }
    }

    //Is there a path from s to v
    boolean hasPathTo(int v){
        return marked[v];
    }


}
