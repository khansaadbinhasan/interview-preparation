package trees;

import java.util.*;

//2
//1 2 3
//5
//1 2 3
//5

//1
//4 3 5 1 1
//5
public class TotalSubTreeWithGivenSum {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }


    private static int sum = 0;
    private static int k = 0;
    private static int count = 0;

    public static void main(String[] args) {
        new TotalSubTreeWithGivenSum().run();
    }

    public void run() {

        Scanner sc = new Scanner(System.in);


        int T = sc.nextInt();
        List<Integer> ansArr = new ArrayList<>();

        for (int i = 0; i < T; i++) {
            sc.nextLine();
            String[] treeStr = sc.nextLine().trim().split(" ");
            TotalSubTreeWithGivenSum.k = sc.nextInt();

            int[] tree = new int[treeStr.length];

            for (int j = 0; j < treeStr.length; j++) {
                tree[j] = Integer.parseInt(treeStr[j]);
            }

            ansArr.add(subtreesWithGivenSum(tree));
        }

        ansArr.forEach(ans -> System.out.println(ans));
    }

    public int subtreesWithGivenSum(int[] tree){

        if (tree.length == 0) return 0;

        count = 0;

        TreeNode root = levelOrderInsertion(null, new TreeNode(tree[0]) );

        for (int i = 1; i < tree.length; i++) {
            root = levelOrderInsertion(root, new TreeNode(tree[i]));
        }

        inOrderTraversal(root);

        return count;
    }

    public void inOrderTraversal(TreeNode root){
        if( root == null ) return;

        inOrderTraversal(root.left);

        sum = 0;
        inOrderSum(root);
        if( sum == k ) count++;

        inOrderTraversal(root.right);
    }

    public void inOrderSum(TreeNode root) {
        if( root == null ) return;

        inOrderSum(root.left);
        TotalSubTreeWithGivenSum.sum += root.val;
        inOrderSum(root.right);
    }


    public TreeNode levelOrderInsertion(TreeNode root, TreeNode treeNode) {

        if( root == null ) return treeNode;

        Queue<TreeNode> treeQueue = new LinkedList<>();

        treeQueue.add(root);

        while (!treeQueue.isEmpty()) {
            TreeNode polledTreeNode = treeQueue.poll();

            if( polledTreeNode == null ) continue;

            if( polledTreeNode.left == null ){
                polledTreeNode.left = treeNode;
                return root;
            }

            else if( polledTreeNode.right == null ){
                polledTreeNode.right = treeNode;
                return root;
            }

            else {
                treeQueue.add(polledTreeNode.left);
                treeQueue.add(polledTreeNode.right);
            }

            treeQueue.add(treeNode.left);
            treeQueue.add(treeNode.right);
        }

        return root;
    }

    public void inOrderPrinting(TreeNode root){
        if( root == null ) return;

        inOrderPrinting(root.left);
        System.out.print(root.val + " ");
        inOrderPrinting(root.right);
    }

    public void levelOrderPrinting(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            TreeNode treeNode = q.poll();

            if (treeNode == null) continue;

            System.out.print(treeNode.val + " ");

            q.add(treeNode.left);
            q.add(treeNode.right);
        }
    }

}

































//import java.util.*;
//public class Main {
//    public static void main (String args[]) {
//        new Main().run();
//    }
//
//    class Node{
//        int val;
//        Node left;
//        Node right;
//
//        Node(int val){
//            this.val = val;
//            this.left = null;
//            this.right = null;
//        }
//    }
//
//
//    private static int sum = 0;
//    private static int k = 0;
//    private static int count = 0;
//
//    public void run() {
//
//        Scanner sc = new Scanner(System.in);
//
//
//        int T = sc.nextInt();
//        List<Integer> ansArr = new ArrayList<>();
//
//        for (int i = 0; i < T; i++) {
//            sc.nextLine();
//            String[] treeStr = sc.nextLine().trim().split(" ");
//            k = sc.nextInt();
//
//            int[] tree = new int[treeStr.length];
//
//            for (int j = 0; j < treeStr.length; j++) {
//                tree[j] = Integer.parseInt(treeStr[j]);
//            }
//
//            ansArr.add(subtreesWithGivenSum(tree));
//        }
//
//        ansArr.forEach(ans -> System.out.println(ans));
//    }
//
//    public int subtreesWithGivenSum(int[] tree){
//
//        if (tree.length == 0) return 0;
//
//        count = 0;
//        Node root = levelOrderInsertion(null, new Node(tree[0]) );
//
//        for (int i = 1; i < tree.length; i++) {
//            root = levelOrderInsertion(root, new Node(tree[i]));
//        }
//
//        inOrderTraversal(root);
//
//        return count;
//    }
//
//    public void inOrderTraversal(Node root){
//        if( root == null ) return;
//
//        inOrderTraversal(root.left);
//
//        sum = 0;
//        inOrderSum(root);
//        if( sum == k ) count++;
//
//        inOrderTraversal(root.right);
//    }
//
//    public void inOrderSum(Node root) {
//        if( root == null ) return;
//
//        inOrderSum(root.left);
//        sum += root.val;
//        inOrderSum(root.right);
//    }
//
//
//    public Node levelOrderInsertion(Node root, Node node) {
//
//        if( root == null ) return node;
//
//        Queue<Node> treeQueue = new LinkedList<>();
//
//        treeQueue.add(root);
//
//        while (!treeQueue.isEmpty()) {
//            Node polledNode = treeQueue.poll();
//
//            if( polledNode == null ) continue;
//
//            if( polledNode.left == null ){
//                polledNode.left = node;
//                return root;
//            }
//
//            else if( polledNode.right == null ){
//                polledNode.right = node;
//                return root;
//            }
//
//            else {
//                treeQueue.add(polledNode.left);
//                treeQueue.add(polledNode.right);
//            }
//
//            treeQueue.add(node.left);
//            treeQueue.add(node.right);
//        }
//
//        return root;
//    }
//
//    public void inOrderPrinting(Node root){
//        if( root == null ) return;
//
//        inOrderPrinting(root.left);
//        System.out.print(root.val + " ");
//        inOrderPrinting(root.right);
//    }
//
//    public void levelOrderPrinting(Node root) {
//
//        Queue<Node> q = new LinkedList<>();
//
//        q.add(root);
//
//        while (!q.isEmpty()) {
//            Node node = q.poll();
//
//            if (node == null) continue;
//
//            System.out.print(node.val + " ");
//
//            q.add(node.left);
//            q.add(node.right);
//        }
//    }
//}