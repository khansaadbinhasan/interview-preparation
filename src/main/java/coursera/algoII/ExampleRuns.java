package coursera.algoII;

import coursera.algoII.datastructures.*;

public class ExampleRuns {

    public static void main(String[] args) {
//        new ExampleRuns().runDFS();
//        new ExampleRuns().runBFS();
//        new ExampleRuns().runConnectedComponents();
//        new ExampleRuns().runTopologicalSort();
//        new ExampleRuns().runKosaraju();
//        new ExampleRuns().runKruskal();
//        new ExampleRuns().runLazyPrim();
//        new ExampleRuns().runShortestPath();
//        new ExampleRuns().runShortestPathAcyclic();
        new ExampleRuns().runFordFulkerson();
    }

    private void runFordFulkerson() {
//        FlowNetwork graphForFordFulkerson = getGraphForFordFulkerson();
//        FordFulkerson fordFulkerson = new FordFulkerson(graphForFordFulkerson, 0, 5);

        FordFulkerson fordFulkerson = new FordFulkerson(getGraphForFordFulkersonII(), 0, 7);
        System.out.println("expected flow 28, actual: " + fordFulkerson.value());
    }

    public void runShortestPathAcyclic(){

        AcyclicSP dijkstraSP = new AcyclicSP(getGraphForDijkstra(), 0);

        for( DirectedEdge e: dijkstraSP.pathTo(6) ){
            System.out.println(e);
        }

    }

    public void runShortestPath(){

        DijkstraSP dijkstraSP = new DijkstraSP(getGraphForDijkstra(), 0);

        for( DirectedEdge e: dijkstraSP.pathTo(6)){
            System.out.println(e);
        }

    }

    public void runLazyPrim(){
        EdgeWeightedGraph edgeWeightedGraph = getGraphForMST();
        LazyPrimMST mst = new LazyPrimMST(edgeWeightedGraph);

        for( Edge edge: mst.edges() ){
            System.out.println(edge);
        }

//        System.out.println(mst.weight());
    }


    public void runKruskal(){
        EdgeWeightedGraph edgeWeightedGraph = getGraphForMST();
        KruskalMST mst = new KruskalMST(edgeWeightedGraph);

        for( Edge edge: mst.edges() ){
            System.out.println(edge);
        }

//        System.out.println(mst.weight());
    }

    public void runKosaraju(){
        KosarajuSharirSCC kosarajuSharirSCC = new KosarajuSharirSCC(getGraphForKosaraju());

        System.out.println(kosarajuSharirSCC);
    }

    public void runTopologicalSort(){
        Digraph g = getGraphForTopologicalSort();

        DepthFirstOrder depthFirstOrder = new DepthFirstOrder(g);

        for (int v: depthFirstOrder.reversePost()){
            System.out.println(v);
        }
    }

    public void runConnectedComponents(){
        Graph graphForDFS = getGraphForDFS();
        CC depthFirstPaths = new CC(graphForDFS);

        System.out.println(depthFirstPaths);
//        System.out.println(depthFirstPaths.toString(graphForDFS, 0));
    }


    public void runDFS(){
        Graph graphForDFS = getGraphForDFS();
        DepthFirstPaths depthFirstPaths = new DepthFirstPaths(graphForDFS, 0);

        System.out.println(depthFirstPaths.toString(3));
//        System.out.println(depthFirstPaths.toString(graphForDFS, 0));
    }

    public void runBFS(){
        Graph graphForBFS = getGraphForBFS();
        BreadthFirstPaths breadthFirstPaths = new BreadthFirstPaths(graphForBFS, 0);

        System.out.println(breadthFirstPaths.toString(5));
//        System.out.println(depthFirstPaths.toString(graphForDFS, 0));
    }

    public Graph getGraphForDFS(){

        Graph g = new Graph(13);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 6);
        g.addEdge(0, 5);

        g.addEdge(1, 0);

        g.addEdge(2, 0);

        g.addEdge(3, 4);
        g.addEdge(3, 5);

        g.addEdge(4, 3);
        g.addEdge(4, 5);
        g.addEdge(4, 6);

        g.addEdge(5, 0);
        g.addEdge(5, 3);
        g.addEdge(5, 4);

        g.addEdge(6, 0);
        g.addEdge(6, 4);

        g.addEdge(7, 8);

        g.addEdge(8, 7);

        g.addEdge(9, 10);
        g.addEdge(9, 11);
        g.addEdge(9, 12);

        g.addEdge(10, 9);

        g.addEdge(11, 9);
        g.addEdge(11, 12);

        g.addEdge(12, 9);
        g.addEdge(12, 11);

        return g;
    }

    public Graph getGraphForBFS(){

        Graph g = new Graph(13);

        g.addEdge(0, 5);
        g.addEdge(0, 2);
        g.addEdge(0, 1);

        g.addEdge(1, 0);
        g.addEdge(1, 2);

        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 1);
        g.addEdge(2, 0);

        g.addEdge(3, 2);
        g.addEdge(3, 4);
        g.addEdge(3, 5);

        g.addEdge(4, 2);
        g.addEdge(4, 3);

        g.addEdge(5, 0);
        g.addEdge(5, 3);

        return g;
    }

    public Digraph getGraphForTopologicalSort(){

        Digraph g = new Digraph(7);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 5);

        g.addEdge(1, 4);

        g.addEdge(3, 2);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(3, 6);

        g.addEdge(5, 2);

        g.addEdge(6, 0);

        return g;
    }

    public Digraph getGraphForKosaraju(){

        Digraph g = new Digraph(13);

        g.addEdge(0, 1);
        g.addEdge(0, 5);

        g.addEdge(2, 0);
        g.addEdge(2, 3);

        g.addEdge(3, 2);
        g.addEdge(3, 5);

        g.addEdge(4, 2);
        g.addEdge(4, 3);

        g.addEdge(5, 4);

        g.addEdge(6, 0);
        g.addEdge(6, 4);
        g.addEdge(6, 8);
        g.addEdge(6, 9);

        g.addEdge(7, 6);
        g.addEdge(7, 9);

        g.addEdge(8, 6);

        g.addEdge(9, 10);
        g.addEdge(9, 11);

        g.addEdge(10, 12);

        g.addEdge(11, 12);
        g.addEdge(11, 4);

        g.addEdge(12, 9);

        return g;
    }

    public EdgeWeightedGraph getGraphForMST(){

        EdgeWeightedGraph g = new EdgeWeightedGraph(8);

        g.addEdge(new Edge(0, 2, 26));
        g.addEdge(new Edge(0, 7, 16));
        g.addEdge(new Edge(0, 4, 38));
        g.addEdge(new Edge(0, 6, 58));

        g.addEdge(new Edge(1, 2, 36));
        g.addEdge(new Edge(1, 3, 29));
        g.addEdge(new Edge(1, 5, 32));
        g.addEdge(new Edge(1, 7, 19));

        g.addEdge(new Edge(2, 0, 26));
        g.addEdge(new Edge(2, 3, 17));
        g.addEdge(new Edge(2, 6, 40));
        g.addEdge(new Edge(2, 7, 34));
        g.addEdge(new Edge(2, 1, 36));

        g.addEdge(new Edge(3, 6, 52));
        g.addEdge(new Edge(3, 1, 29));
        g.addEdge(new Edge(3, 2, 17));

        g.addEdge(new Edge(4, 5, 35));
        g.addEdge(new Edge(4, 6, 93));
        g.addEdge(new Edge(4, 7, 37));
        g.addEdge(new Edge(4, 0, 38));

        g.addEdge(new Edge(5, 1, 32));
        g.addEdge(new Edge(5, 4, 35));
        g.addEdge(new Edge(5, 7, 28));

        g.addEdge(new Edge(6, 0, 58));
        g.addEdge(new Edge(6, 2, 40));
        g.addEdge(new Edge(6, 3, 52));
        g.addEdge(new Edge(6, 4, 93));

        g.addEdge(new Edge(7, 0, 16));
        g.addEdge(new Edge(7, 1, 19));
        g.addEdge(new Edge(7, 2, 34));
        g.addEdge(new Edge(7, 4, 37));
        g.addEdge(new Edge(7, 5, 28));

        return g;
    }


    public FlowNetwork getGraphForFordFulkerson(){

        FlowNetwork g = new FlowNetwork(8);

        g.addEdge(new FlowEdge(0, 1, 1));
        g.addEdge(new FlowEdge(0, 2, 1));

        g.addEdge(new FlowEdge(1, 0, 9));
        g.addEdge(new FlowEdge(1, 2, 4));

        g.addEdge(new FlowEdge(2, 0, 4));
        g.addEdge(new FlowEdge(2, 4, 8));
        g.addEdge(new FlowEdge(2, 1, 8));

        g.addEdge(new FlowEdge(3, 1, 9));
        g.addEdge(new FlowEdge(3, 4, 15));
        g.addEdge(new FlowEdge(3, 5, 1));

        g.addEdge(new FlowEdge(4, 1, 4));
        g.addEdge(new FlowEdge(4, 5, 6));

        g.addEdge(new FlowEdge(5, 4, 4));
        g.addEdge(new FlowEdge(5, 3, 9));

        return g;
    }

    public FlowNetwork getGraphForFordFulkersonII(){

        FlowNetwork g = new FlowNetwork(8);

        g.addEdge(new FlowEdge(0, 1, 10));
        g.addEdge(new FlowEdge(0, 2, 5));
        g.addEdge(new FlowEdge(0, 3, 15));

        g.addEdge(new FlowEdge(1, 2, 4));
        g.addEdge(new FlowEdge(1, 5, 15));
        g.addEdge(new FlowEdge(1, 4, 9));

        g.addEdge(new FlowEdge(2, 3, 4));
        g.addEdge(new FlowEdge(2, 5, 8));

        g.addEdge(new FlowEdge(3, 6, 16));

        g.addEdge(new FlowEdge(4, 5, 15));
        g.addEdge(new FlowEdge(4, 7, 10));

        g.addEdge(new FlowEdge(5, 7, 10));
        g.addEdge(new FlowEdge(5, 6, 15));

        g.addEdge(new FlowEdge(6, 2, 6));
        g.addEdge(new FlowEdge(6, 7, 10));

        return g;
    }


    public EdgeWeightedDiGraph getGraphForDijkstra(){

        EdgeWeightedDiGraph g = new EdgeWeightedDiGraph(8);

        g.addEdge(new DirectedEdge(0, 1, 5));
        g.addEdge(new DirectedEdge(0, 4, 9));
        g.addEdge(new DirectedEdge(0, 7, 8));

        g.addEdge(new DirectedEdge(1, 2, 12));
        g.addEdge(new DirectedEdge(1, 3, 15));
        g.addEdge(new DirectedEdge(1, 7, 4));

        g.addEdge(new DirectedEdge(2, 3, 3));
        g.addEdge(new DirectedEdge(2, 6, 11));

        g.addEdge(new DirectedEdge(3, 6, 9));

        g.addEdge(new DirectedEdge(4, 5, 4));
        g.addEdge(new DirectedEdge(4, 6, 20));
        g.addEdge(new DirectedEdge(4, 7, 5));

        g.addEdge(new DirectedEdge(5, 2, 1));
        g.addEdge(new DirectedEdge(5, 6, 13));

        g.addEdge(new DirectedEdge(7, 2, 7));
        g.addEdge(new DirectedEdge(7, 5, 6));

        return g;
    }

}
