package coursera.algoII;

public class Paths {

    private Graph G;
    private int s;

    public Paths(Graph G, int s){

    }

    //Is there a path from s to v
    boolean hasPathTo(int v){
        return false;
    }

    Iterable<Integer> pathTo(int v){
        return null;
    }

    public String toString(){
        StringBuilder pathsStr = new StringBuilder();
        Paths paths = new Paths(G, s);

        for (int v = 0; v < G.V(); v++) {
            if( paths.hasPathTo(v) ){
                pathsStr.append(v).append(" ");
            }
        }

        return pathsStr.toString();
    }
}
