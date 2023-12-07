package coursera.algoII;

import coursera.algoII.datastructures.DirectedEdge;
import coursera.algoII.datastructures.EdgeWeightedDiGraph;

import java.util.Stack;

public class SP {

    private int[] distTo;
    private DirectedEdge[] edgeTo;

    public SP(EdgeWeightedDiGraph G, int s){

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

    public void edgeRelaxation(DirectedEdge e){
        int v = e.from();
        int w = e.to();

        if( distTo[v] + e.weight() < distTo[w] ){
            distTo[w] = (int) (distTo[v] + e.weight());
            edgeTo[w] = e;
        }
    }

}
