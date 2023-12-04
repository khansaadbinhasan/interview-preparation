package coursera.algoII;

public class ExampleRuns {

    public static void main(String[] args) {
//        new ExampleRuns().runDFS();
//        new ExampleRuns().runBFS();
        new ExampleRuns().runConnectedComponents();
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
}
