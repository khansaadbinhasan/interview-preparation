package codingBlocks.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ConnectLevelOrder {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public static void main(String[] args) {
        new ConnectLevelOrder().run();
    }

    private int numNodes = 0;
    private int power = 0;

    private void run() {
        Scanner sc = new Scanner(System.in);

        String[] inpArr = sc.nextLine().trim().split(" ");

        Node root = levelOrderInsertion(null, new Node(Integer.parseInt(inpArr[0])));

        for( int i = 1; i < inpArr.length; i++ ){
            root = levelOrderInsertion(root, new Node(Integer.parseInt(inpArr[i])));
        }

        connectDfs(root);

        levelOrderTraversalModded(root);
    }

    public Node connectDfs(Node root){

        Queue<Node> q = new LinkedList<>();

        q.offer(root);
        q.offer(null);

        while( !q.isEmpty() ){
            Node node = q.poll();

            if( node != null ){
                node.next = q.peek();

                if( node.left != null ) q.offer(node.left);
                if( node.right != null ) q.offer(node.right);
            }

            else if( !q.isEmpty() ) {
                q.offer(null);
            }
        }

        return root;

    }

    public Node connect(Node root){
        if( root == null ) return null;

        Queue<Node> q = new LinkedList<>();

        q.offer(root);

        while( !q.isEmpty() ){
            Node node = q.poll();

            if( node == null ) continue;

            numNodes++;

            if( numNodes == Math.pow(2, power) ){
                node.next = null;
                numNodes = 0;
                power++;
            }

            else {
                node.next = q.peek();
            }

            q.offer(node.left);
            q.offer(node.right);
        }

        return root;
    }

    public Node levelOrderInsertion(Node root, Node node) {

        if( root == null ) return node;

        Queue<Node> treeQueue = new LinkedList<>();

        treeQueue.add(root);

        while (!treeQueue.isEmpty()) {
            Node polledNode = treeQueue.poll();

            if( polledNode == null || polledNode.val == -1 ) continue;

            if( polledNode.left == null ){
                polledNode.left = node;
                return root;
            }

            else if( polledNode.right == null ){
                polledNode.right = node;
                return root;
            }

            else {
                treeQueue.add(polledNode.left);
                treeQueue.add(polledNode.right);
            }

            treeQueue.add(node.left);
            treeQueue.add(node.right);
        }



        return root;
    }

    public void levelOrderTraversalModded(Node root){
        if( root == null ) return;

        Queue<Node> q = new LinkedList<>();

        q.offer(root);

        while( !q.isEmpty() ){

            Node node = q.poll();

            if( node == null || node.val == -1 ) continue;

            if( node.next == null ) System.out.print("-1" + " ");
            else System.out.print(node.next.val + " ");

            q.offer(node.left);
            q.offer(node.right);

        }
    }


    public void levelOrderTraversal(Node root){
        if( root == null ) return;

        Queue<Node> q = new LinkedList<>();

        q.offer(root);

        while( !q.isEmpty() ){

            Node node = q.poll();

            if( node == null ) continue;

            System.out.print(node.val + " ");

            q.offer(node.left);
            q.offer(node.right);

        }
    }
}
