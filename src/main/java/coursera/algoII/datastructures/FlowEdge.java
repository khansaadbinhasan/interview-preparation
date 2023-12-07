package coursera.algoII.datastructures;

public class FlowEdge implements Comparable<FlowEdge>{

    private final int v, w;
    private final double capacity;
    private double flow;

    public FlowEdge(int v, int w, double capacity){
        this.v = v;
        this.w = w;
        this.capacity = capacity;
    }

    public int from(){
        return v;
    }

    public int to(){
        return w;
    }

    public int other(int vertex){
        if( vertex == v ) return w;
        else if( vertex == w ) return v;

        throw new RuntimeException("Illegal Endpoint");
    }

    public double capacity(){
        return capacity;
    }

    public double flow(){
        return flow;
    }

    public double residualCapacity(int vertex){
        if( vertex == v ) return flow;
        else if( vertex == w ) return capacity-flow;
        else throw new IllegalArgumentException();
    }

    public void addResidualFlowToCapacity(int vertex, double delta){
        if( vertex == v ) flow -= delta;
        else if( vertex == w ) flow += delta;
        else throw new IllegalArgumentException();
    }

    public int compareTo(FlowEdge that){
        if( this.capacity < that.capacity) return -1;
        else if( this.capacity > that.capacity) return 1;

        return 0;
    }

    public String toString(){
        return v + "->" + w;
    }
}
