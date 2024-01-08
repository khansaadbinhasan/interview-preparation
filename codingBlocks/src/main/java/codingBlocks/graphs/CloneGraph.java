package codingBlocks.graphs;

import java.util.*;

public class CloneGraph {

    public static void main(String[] args) {
        new CloneGraph().run();
    }

    public void run(){

    }


    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {

        if( node == null ) return null;

        Node[] array = new Node[1000];

        Arrays.fill(array, null);

        List<Node> visited = Arrays.asList(array);

        Node copy = new Node(node.val);

        visited.set(node.val, copy);

        for( Node curr: node.neighbors ){
            if( visited.get(curr.val) == null ){
                Node newNode = new Node(curr.val);
                copy.neighbors.add(newNode);
                dfs(curr, newNode, visited);
            }

            else copy.neighbors.add(visited.get(curr.val));
        }

        return copy;

    }

    public void dfs(Node curr, Node node, List<Node> visited){

        visited.set(node.val, node);

        for( Node n: curr.neighbors ){

            if( visited.get(n.val) == null ){
                Node nNode = new Node(n.val);
                node.neighbors.add(nNode);
                dfs(n, nNode, visited);
            }

            else {
                node.neighbors.add(visited.get(n.val));
            }
        }
    }
}
