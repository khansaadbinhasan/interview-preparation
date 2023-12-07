package coursera.algoII;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class LazyPrimMST {

    private boolean[] marked;
    private PriorityQueue<Edge> pq;
    private Queue<Edge> mst = new LinkedList<>();

    public LazyPrimMST(EdgeWeightedGraph G){

        pq = new PriorityQueue<>();
        marked = new boolean[G.V()];

        visit(G,0);

        while( !pq.isEmpty() ){
            Edge e = pq.poll();
            int v = e.either();
            int w = e.other(v);
            if( marked[v] && marked[w] ) continue;
            mst.add(e);
            if(!marked[v]) visit(G, v);
            if(!marked[w]) visit(G, w);
        }
    }

    public void visit(EdgeWeightedGraph G, int v){
        marked[v] = true;

        for( Edge e: G.adj(v) ){
            if( !marked[e.other(v)] ) pq.add(e);
        }
    }

    public Iterable<Edge> edges(){
        return mst;
    }
}
