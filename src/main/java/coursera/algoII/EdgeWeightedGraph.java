package coursera.algoII;

import java.io.InputStream;
import java.util.*;

public class EdgeWeightedGraph{

    private int V;
    private Set<Edge>[] adj;

    public EdgeWeightedGraph(InputStream in){

    }

    public EdgeWeightedGraph(int V){
        this.V = V;
        this.adj = new HashSet[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new HashSet<>();
        }
    }

    public void addEdge(Edge e){
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
    }

    public Iterable<Edge> adj(int v){
        return adj[v];
    }

    public Iterable<Edge> edges() {
        Set<Edge> edges = new HashSet<>();
        for (int v = 0; v < V; v++) {
            for (Edge e : adj[v]) {
                if (e.other(v) > v) {
                    edges.add(e);
                }
            }
        }
        return edges;
    }


    public int V(){
        return V;
    }

    public String toString(){
        return "";
    }
}
