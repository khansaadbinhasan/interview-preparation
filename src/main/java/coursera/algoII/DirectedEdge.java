package coursera.algoII;

public class DirectedEdge implements Comparable<DirectedEdge>{

    private final int v, w;
    private final double weight;

    public DirectedEdge(int v, int w, double weight){
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int from(){
        return v;
    }

    public int to(){
        return w;
    }

    public int compareTo(DirectedEdge that){
        if( this.weight < that.weight ) return -1;
        else if( this.weight > that.weight ) return 1;

        return 0;
    }

    public double weight(){
        return weight;
    }

    public String toString(){
        return v + "->" + w;
    }
}
