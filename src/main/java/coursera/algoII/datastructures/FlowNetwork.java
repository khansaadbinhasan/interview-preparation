package coursera.algoII.datastructures;

import java.util.HashSet;
import java.util.Set;

public class FlowNetwork {

    private final int V;
    private Set<FlowEdge>[] adj;

    public FlowNetwork(int V){
        this.V = V;
        adj = new Set[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new HashSet<>();
        }
    }

    public void addEdge(FlowEdge e){
        int v = e.from();
        int w = e.to();
        adj[v].add(e);
        adj[w].add(e);
    }

    public Iterable<FlowEdge> adj(int v){
        return adj[v];
    }

    public Iterable<FlowEdge> edges(){
        return null;
    }

    public int V(){
        return V;
    }

    public int E(){
        return 0;
    }

    public String toString(){
        return "";
    }
}
