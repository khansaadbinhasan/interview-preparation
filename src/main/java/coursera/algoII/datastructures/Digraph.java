package coursera.algoII.datastructures;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

public class Digraph {

    private int V;
    private Set<Integer>[] adj;
    private int E;

    public Digraph(int V){
        this.V = V;
        adj = new Set[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new HashSet<>();
        }
    }

    public Digraph(InputStream in){

    }

    public void addEdge(int v, int w){
        adj[v].add(w);
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public int V(){
        return V;
    }

    public int E(){
        return 0;
    }

    //Compute Degree of v
    public int degree(Digraph G, int v){
        int degree = 0;
        for( int w: G.adj(v) ) degree++;
        return degree;
    }

    //Compute Max Degree
    public int maxDegree(Digraph G){
        int max = 0;
        for (int v = 0; v < G.V(); v++) {
            if( degree(G, v) > max ){
                max = degree(G, v);
            }
        }

        return max;
    }

    //Compute Average Degree
    public double averageDegree(Digraph G){
        return 2.0*G.E()/G.V();
    }

    //Count Self Loops
    public int numberOfSelfLoops(Digraph G){
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

    public Digraph reverse(){
        Digraph reversedGraph = new Digraph(this.V());

        for (int i = 0; i < this.V(); ++i) {
            for (Integer neighbor : adj[i]) {
                reversedGraph.addEdge(neighbor, i);
            }
        }

        return reversedGraph;
    }
}
