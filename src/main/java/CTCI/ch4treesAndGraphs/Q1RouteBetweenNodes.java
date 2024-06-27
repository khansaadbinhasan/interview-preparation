package CTCI.ch4treesAndGraphs;

import java.util.*;

public class Q1RouteBetweenNodes {


     class DirectedGraphNode {
        int label;
        ArrayList<DirectedGraphNode> neighbors;
        DirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<DirectedGraphNode>();
        }
    }


    /*
     * @param graph: A list of Directed graph node
     * @param s: the starting Directed graph node
     * @param t: the terminal Directed graph node
     * @return: a boolean value
     */
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph, DirectedGraphNode s, DirectedGraphNode t) {
        // write your code here

        Queue<DirectedGraphNode> q = new LinkedList<>();

        q.offer(s);

        while( !q.isEmpty() ){

            DirectedGraphNode node = q.poll();

            if( node == t ) return true;

            for( DirectedGraphNode n: node.neighbors ){
                if( n == t ) return true;

                q.offer(n);
            }
        }

        return false;

    }

    Map<Integer, List<Integer>> adjList;
    Set<Integer> visited;

    public static void main(String[] args) {
        new Q1RouteBetweenNodes().run();
    }

    public void run(){
        adjList = new HashMap<>();
        visited = new HashSet<>();

        adjList.put(1, Arrays.asList(2,3));
        adjList.put(2, Arrays.asList(3,4));
        adjList.put(3, Arrays.asList(4));
        adjList.put(4, new LinkedList<>());

        System.out.println(routeBetweenNodes(1,4));
        visited.clear();
        System.out.println(routeBetweenNodes(4,1));
        visited.clear();
        System.out.println(routeBetweenNodes(2,3));
    }

    //A -> [D,B]
    //B -> [C]
    //1 -> [2,3] (A)
    //2 -> [3,4] (B)
    //3 -> [4]   (C)
    //4 -> []    (D)
    public boolean routeBetweenNodes(int A, int D){
        if( visited.contains(D) ) return true;

        visited.add(A);

        for (int i = 0; i < adjList.get(A).size(); i++) {
            if( routeBetweenNodes(adjList.get(A).get(i), D) ) return true;
        }

        return false;
    }

}
