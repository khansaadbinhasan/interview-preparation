package coursera.algoII;

import coursera.algoII.datastructures.DirectedEdge;
import coursera.algoII.datastructures.EdgeWeightedDiGraph;
import coursera.algoII.datastructures.IndexMinPQ;

import java.util.Stack;

public class DijkstraSP {

    private double[] distTo;
    private DirectedEdge[] edgeTo;
    private IndexMinPQ<Double> pq;

    public DijkstraSP(EdgeWeightedDiGraph G, int s){

        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        pq = new IndexMinPQ<>(G.V());

        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }

        distTo[s] = 0;

        pq.insert(s, 0.0);
        while( !pq.isEmpty() ){
            int v = pq.delMin();
            for( DirectedEdge e: G.adj(v) ){
                relax(e);
            }
        }
        
    }

    public double distTo(int v){
        return distTo[v];
    }

    public Iterable<DirectedEdge> pathTo(int v){
        Stack<DirectedEdge> path = new Stack<>();

        for( DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()] ){
            path.push(e);
        }

        return path;
    }

    public boolean hasPathTo(int v){
        return true;
    }

    public void relax(DirectedEdge e){
        int v = e.from();
        int w = e.to();

        if( distTo[v] + e.weight() < distTo[w] ){
            distTo[w] = (int) (distTo[v] + e.weight());
            edgeTo[w] = e;

            if( pq.contains(w) ) pq.decreaseKey(w, distTo[w]);
            else pq.insert(w, distTo[w]);
        }
    }

}
