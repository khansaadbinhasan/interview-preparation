package codingBlocks.trees;

import java.util.*;


//7
//50 20 60 10 30 55 70
//3
public class InorderSuccessorInBst {

    private class Node{
        int val;
        Node left;
        Node right;

        Node(){}

        Node(int val){
            this.val = val;
        }
    }

    private int min = Integer.MAX_VALUE;
    private boolean isLastEqual = false;
    private int inorderSucc = Integer.MAX_VALUE;

    public static void main(String[] args) {
        new InorderSuccessorInBst().run();
    }

    private void run() {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        int nodeVal = sc.nextInt();
        Node root = getBinaryTree(nums);

//        inorderSuccessor(root, nodeVal);
//        System.out.println(inorderSucc == Integer.MAX_VALUE ? "": inorderSucc);

//        System.out.println(find(root, 5));

        System.out.println(getSuccessor(root, nodeVal).val);
    }

    public Node findMin( Node root ){
        while( root.left != null ) root = root.left;

        return root;
    }

    public Node getSuccessor(Node root, int val){
        Node current = find(root,val);

        if( current == null ) return null;

        if( current.right != null ) return findMin(current.right);
        else {
            Node successor = null;
            Node ancestor = root;

            while( ancestor != current ){
                if( current.val < ancestor.val ){
                    successor = ancestor;
                    ancestor = ancestor.left;
                }

                else ancestor = ancestor.right;
            }

            return successor;
        }

    }

    public Node find( Node root, int val ){
        int level = 0;

        boolean isfoundVal = false;

        while( !isfoundVal && root != null){

            if( val == root.val ) {
                isfoundVal = true;
                return root;
            }

            else if( val < root.val ) root = root.left;
            else if( val > root.val ) root = root.right;

            level++;
        }

        return null;
    }

    public void inorderSuccessor(Node root, int val){
        if( root == null ) return;

        inorderSuccessor(root.left, val);

        if( root.val != val && isLastEqual ) {
            inorderSucc = root.val;
            isLastEqual = false;
            return;
        }

        if( root.val == val ) isLastEqual = true;

        inorderSuccessor(root.right, val);
    }

    public Node getBinaryTree(int[] nums){

        if( nums.length == 0 ) return null;

        Node root = new Node(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            insertNode(root, new Node(nums[i]));
        }

        return root;
    }

    public void insertNode( Node root, Node node ){

        if( root == null ) return;

        if( node.val <= root.val ) {
            if( root.left == null ) root.left = node;
            else insertNode(root.left, node);
        }

        else {
            if( root.right == null ) root.right = node;
            else insertNode(root.right, node);
        }
    }


    public void levelOrderPrinting(Node root) {

        Queue<Node> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node == null) continue;

            System.out.print(node.val + " ");

            q.add(node.left);
            q.add(node.right);
        }
    }

}
