package coursera.algoII;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class KosarajuSharirSCC {

    private boolean[] marked;
    private int s;
    private int[] id;
    private int count;

    public KosarajuSharirSCC(Digraph G){
        marked = new boolean[G.V()];
        id = new int[G.V()];

        DepthFirstOrder dfs = new DepthFirstOrder(G.reverse());

        List<Integer> lst = new LinkedList<>();

        for (int v : dfs.reversePost()) {
            lst.add(v);
        }

        Collections.reverse(lst);

        for (int v : lst) {
            if (!marked[v]) {
                dfs(G, v);
                count++;
            }
        }
    }

    boolean stronglyConnected(int v, int w){
        return id[v] == id[w];
    }

    int count(){
        return count;
    }

    int id(int v){
        return id[v];
    }

    private void dfs(Digraph G, int v){
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
