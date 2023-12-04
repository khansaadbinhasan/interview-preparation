package coursera.algoII;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

public class Graph {

    private int V;
    private Set<Integer>[] adj;
    private int E;

    public Graph(int V){
        this.V = V;
        adj = new Set[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new HashSet<>();
        }
    }

    public Graph(InputStream in){

    }

    void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
    }

    Iterable<Integer> adj(int v){
        return adj[v];
    }

    int V(){
        return V;
    }

    int E(){
        return 0;
    }

    //Compute Degree of v
    public int degree(Graph G, int v){
        int degree = 0;
        for( int w: G.adj(v) ) degree++;
        return degree;
    }

    //Compute Max Degree
    public int maxDegree(Graph G){
        int max = 0;
        for (int v = 0; v < G.V(); v++) {
            if( degree(G, v) > max ){
                max = degree(G, v);
            }
        }

        return max;
    }

    //Compute Average Degree
    public double averageDegree(Graph G){
        return 2.0*G.E()/G.V();
    }

    //Count Self Loops
    public int numberOfSelfLoops(Graph G){
        int count = 0;

        for (int v = 0; v < G.V(); v++) {
            for (int w : G.adj(v) ) {
                if( v == w ) count++;
            }
        }

        return count/2;//Each edge counted twice
    }


    public String toString(){

        StringBuilder graph = new StringBuilder();

        for (int v = 0; v < this.V(); v++) {
            for (int w: this.adj(v)) {
                graph.append(v).append("-").append(w).append("\n");
            }
        }

        return graph.toString();
    }
}
