package trees;

import java.util.LinkedList;
import java.util.Queue;

//          1
//         /  \
//        2    3
//       / \  / \
//      4   5 6  7

//4 2 5 1 6 3 7

public class LevelOrderTraversal {

    class TreeNode {
        int key;
        TreeNode left;
        TreeNode right;

        TreeNode(int key)
        {
            this.key = key;
        }
    }

    public static void main(String[] args) {
        new LevelOrderTraversal().run();
    }


    public void run(){
//        Node root = new Node(1);
//        root.left = new Node(2);
//        root.right = new Node(3);
//        root.left.left = new Node(4);
//        root.left.right = new Node(5);
//        root.right.left = new Node(6);
//        root.right.right = new Node(7);
//
//        levelOrderPrinting(root);
//
//
//        System.out.println("\n\n");

        TreeNode root = levelOrderInsertion(null, new TreeNode(1));
        root = levelOrderInsertion(root, new TreeNode(2));
        root = levelOrderInsertion(root, new TreeNode(3));
        root = levelOrderInsertion(root, new TreeNode(4));
        root = levelOrderInsertion(root, new TreeNode(5));
        root = levelOrderInsertion(root, new TreeNode(6));
        root = levelOrderInsertion(root, new TreeNode(7));

        levelOrderPrinting(root);
        System.out.println();
        inOrderPrinting(root);
    }

    public void inOrderPrinting(TreeNode root){
        if( root == null ) return;

        inOrderPrinting(root.left);
        System.out.print(root.key + " ");
        inOrderPrinting(root.right);
    }

    public TreeNode levelOrderInsertion(TreeNode root, TreeNode node) {

        if( root == null ) return node;

        Queue<TreeNode> treeQueue = new LinkedList<>();

        treeQueue.add(root);

        while (!treeQueue.isEmpty()) {
            TreeNode polledNode = treeQueue.poll();

            if( polledNode == null ) continue;

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


    public void levelOrderPrinting(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node == null) continue;

            System.out.print(node.key + " ");

            q.add(node.left);
            q.add(node.right);
        }
    }

}