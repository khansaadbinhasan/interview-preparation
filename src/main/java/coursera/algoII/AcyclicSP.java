package coursera.algoII;

import java.util.Stack;

public class AcyclicSP {

    private double[] distTo;
    private DirectedEdge[] edgeTo;

    public AcyclicSP(EdgeWeightedDiGraph G, int s){

        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];

        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }

        distTo[s] = 0;


        Topological topological = new Topological(G);
        Iterable<Integer> order = topological.order();
        for (int v: order) {
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
        }
    }
}
