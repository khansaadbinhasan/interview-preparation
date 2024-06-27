package leetcode.medium;

import java.util.*;

public class L1382BalanceABST {

    List<Integer> sorted = new LinkedList<>();

    public TreeNode balanceBST(TreeNode root) {
        inorder(root);

        return createTree(sorted);
    }

    public TreeNode createTree(List<Integer> nodes){
        if( nodes.isEmpty() ) return null;

        int mid = nodes.size()/2;

        TreeNode root = new TreeNode(nodes.get(mid));

        root.left = createTree(nodes.subList(0,mid));
        root.right = createTree(nodes.subList(mid+1, nodes.size()));

        return root;
    }

    public void inorder(TreeNode root){
        if( root == null ) return;

        inorder(root.left);
        sorted.add(root.val);
        inorder(root.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
