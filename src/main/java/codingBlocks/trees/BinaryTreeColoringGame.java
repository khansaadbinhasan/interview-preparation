package codingBlocks.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeColoringGame {

    private static int count = 0;
    private static TreeNode xNode = null;

    static class TreeNode{

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }

    }

    public static void main(String[] args) {
        new BinaryTreeColoringGame().run();
    }

    public void run() {
        Scanner sc = new Scanner(System.in);

        int numInp = sc.nextInt();
        int numNodes = sc.nextInt();
        int secondPlayerNode = sc.nextInt();

        sc.nextLine();
        sc.nextLine();

        TreeNode root = levelOrderInsertion(null, new TreeNode(1));

        for (int i = 1; i < numNodes; i++) {
            root = levelOrderInsertion(root, new TreeNode(i+1));
        }

        System.out.println(btreeGameWinningMove(root, numNodes, secondPlayerNode) ? 1: 0);
    }

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {

        findNode(root, x);

        count = 0;
        inOrderCount(xNode);

        if( n - count > count ) return true;

        count = 0;
        inOrderCount(xNode.left);

        if( count > n - count ) return true;

        count = 0;
        inOrderCount(xNode.right);

        if( count > n - count ) return true;

        return false;
    }


    public TreeNode findNode(TreeNode root, int x){

        if( root == null ) return null;

        findNode(root.left, x);
        findNode(root.right, x);
        if( root.val == x )  xNode = root;

        return null;
    }

    public void inOrderCount(TreeNode root) {

        if( root == null ) return;

        inOrderCount(root.left);
        count++;
        inOrderCount(root.right);
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
