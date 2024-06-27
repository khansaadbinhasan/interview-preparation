package leetcode.blind75;

import java.util.*;



public class L133CloneGraph {

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

        public String toString(){
            return "" + val;
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


    public static void main(String[] args) {
        new L133CloneGraph().run();
    }

    public void run(){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.neighbors.add(n2);n1.neighbors.add(n4);
        n2.neighbors.add(n1);n2.neighbors.add(n3);
        n3.neighbors.add(n2);n3.neighbors.add(n4);
        n4.neighbors.add(n1);n4.neighbors.add(n3);

        cloneGraph3(n1);
    }

    public Node cloneGraph2(Node node) {

        if( node == null ) return null;

        Node[] array = new Node[1000];

        Arrays.fill(array, null);

        List<Node> visited = Arrays.asList(array);

        Node copy = new Node(node.val);

//        visited.set(node.val, copy);

        // for( Node curr: node.neighbors ){
        //     if( visited.get(curr.val) == null ){
        //         Node newNode = new Node(curr.val);
        //         copy.neighbors.add(newNode);
        //         dfs(curr, newNode, visited);
        //     }

        //     else copy.neighbors.add(visited.get(curr.val));
        // }

        dfs2(node, copy, visited);

        return node;

    }

    //copy n1 to n2 --> Run DFS on n1 and copy to n2
    public void dfs2(Node n1, Node n2, List<Node> visited){

        visited.set(n1.val, n1);

        for( Node n: n1.neighbors ){

            if( visited.get(n.val) == null ){
                Node nNode = new Node(n.val);
                n2.neighbors.add(nNode);
                dfs2(n, nNode, visited);
            }

//            else {
//                node.neighbors.add(visited.get(n.val));
//            }
        }
    }

    public Node cloneGraph3(Node node) {
        if( node == null ) return null;

        Node start = new Node(node.val);

        bfs(node, start);

        printGraph(start);

        return start;
    }

    public void bfs(Node n1, Node n2){
        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();

        q1.add(n1);
        q2.add(n2);
        Set<Node> visited = new HashSet<>();

        while( !q1.isEmpty() ){
            Node node1 = q1.poll();
            Node node2 = q2.poll();
            visited.add(node1);
            for( Node nN1: node1.neighbors ){
                if( !visited.contains(nN1) ) {
                    Node nN2 = new Node(nN1.val);
                    node2.neighbors.add(nN2);
                    nN2.neighbors.add(node2);

                    q1.add(nN1);
                    q2.add(nN2);
                }
            }
        }

        System.out.println();
    }

    public void printGraph(Node node){
//        System.out.println( node + " -> [" + node.neighbors +"]");
//        for( Node n: node.neighbors ){
//            System.out.println( n + " -> [" + n.neighbors +"]");
//        }
    }


    public Node cloneGraph4(Node node) {
        if( node == null ) return null;

        Node start = new Node(node.val);
        Map<Node, Node> nodeMap = new HashMap<>();
        nodeMap.put(node, start);

        bfs(node, start, nodeMap);

        return start;
    }

    public void bfs(Node n1, Node n2, Map<Node, Node> nodeMap){
        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();

        q1.add(n1);
        q2.add(n2);

        while( !q1.isEmpty() ){
            Node node1 = q1.poll();
            Node node2 = q2.poll();
            for( Node nN1: node1.neighbors ){
                if( !nodeMap.containsKey(nN1) ) {
                    Node nN2 = new Node(nN1.val);
                    node2.neighbors.add(nN2);
                    // nN2.neighbors.add(node2);
                    nodeMap.put(nN1, nN2);

                    q1.add(nN1);
                    q2.add(nN2);
                }

                else{
                    node2.neighbors.add(nodeMap.get(nN1));
                }
            }
        }
    }

}
