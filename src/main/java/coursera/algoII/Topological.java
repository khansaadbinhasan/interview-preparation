package coursera.algoII;

import coursera.algoII.datastructures.DirectedEdge;
import coursera.algoII.datastructures.EdgeWeightedDiGraph;

import java.util.Collections;
import java.util.Stack;

public class Topological {

    private boolean[] marked;
    private Stack<Integer> reversePost;
    private int s;

    public Topological(EdgeWeightedDiGraph G){
        reversePost = new Stack<>();
        marked = new boolean[G.V()];

        for (int v = 0; v < G.V(); v++) {
            if( !marked[v] ) dfs(G, v);
        }
    }

    private void dfs(EdgeWeightedDiGraph G, int v){
        marked[v] = true;

        for( DirectedEdge w: G.adj(v) ){
            if( !marked[w.to()] ) {
                dfs(G, w.to());
            }
        }

        reversePost.push(v);
    }

    public Iterable<Integer> order(){
        Collections.reverse(reversePost);
        return reversePost;
    }

}
