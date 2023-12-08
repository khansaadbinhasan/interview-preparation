package coursera.algoII;

import coursera.algoII.datastructures.Edge;
import coursera.algoII.datastructures.EdgeWeightedGraph;

import java.util.*;

public class KruskalMST {

    private Queue<Edge> mst = new LinkedList<>();

    public KruskalMST(EdgeWeightedGraph G){

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for( Edge e: G.edges() ){
            pq.add(e);
        }

        UnionFind uf = new UnionFind(G.V());

        while( !pq.isEmpty() && mst.size() < G.V() - 1 ){

            Edge e = pq.poll();
            int v = e.either();
            int w = e.other(v);

            if( !uf.connected(v, w) ){
                uf.union(v, w);
                mst.add(e);
            }
        }

    }

    public Iterable<Edge> edges(){
        return mst;
    }
}
