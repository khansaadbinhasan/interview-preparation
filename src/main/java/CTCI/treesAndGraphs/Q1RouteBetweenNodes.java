package CTCI.treesAndGraphs;

import java.util.*;

public class Q1RouteBetweenNodes {


     class DirectedGraphNode {
        int label;
        ArrayList<DirectedGraphNode> neighbors;
        DirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<DirectedGraphNode>();
        }
    };


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

}
