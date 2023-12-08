package coursera.algoII.datastructures;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

public class EdgeWeightedDiGraph {

    private int V;
    private Set<DirectedEdge>[] adj;

    public EdgeWeightedDiGraph(InputStream in){

    }

    public EdgeWeightedDiGraph(int V){
        this.V = V;
        this.adj = new HashSet[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new HashSet<>();
        }
    }

    public void addEdge(DirectedEdge e){
        int v = e.from();
        adj[v].add(e);
    }

    public Iterable<DirectedEdge> adj(int v){
        return adj[v];
    }

    public int V(){
        return V;
    }

    public String toString(){
        return "";
    }
}
