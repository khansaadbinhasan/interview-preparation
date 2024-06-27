package leetcode.easy;

import java.util.*;

public class L783MinimumDistanceBetweenBSTNodes {

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

    int MAX_VAL = 100_000;
    int minDiff = MAX_VAL;

    public int minDiffInBST(TreeNode root) {
        updateRootValWithDiff(root);

        return findMinDiffInBST(root);
    }

    public int findMinDiffInBST(TreeNode root) {
        if( root == null ) return MAX_VAL;
        if( root.left == null && root.right == null ) return MAX_VAL;

        minDiff = Math.min(minDiff, root.val);
        minDiff = Math.min(minDiff, findMinDiffInBST(root.left));
        minDiff = Math.min(minDiff, findMinDiffInBST(root.right));

        return minDiff;
    }

    public void updateRootValWithDiff(TreeNode root){
        if( root == null ) return;

        if( root.left != null && root.right != null ){
            root.val = Math.min(
                    Math.abs(root.val - findMax(root.right)),
                    Math.abs(root.val - findMin(root.left))
            );
        }

        if( root.left == null && root.right != null ){
            root.val = Math.abs(root.val - root.right.val);
        }

        if( root.left != null && root.right == null ){
            root.val = Math.abs(root.val - root.left.val);
        }

        if( root.left == null && root.right == null ){
            root.val = MAX_VAL;
        }

        updateRootValWithDiff(root.left);
        updateRootValWithDiff(root.right);
    }

    public int findMin(TreeNode root){
        if( root == null ) return MAX_VAL;

        while( root.left != null ) root = root.left;

        return root.val;
    }

    public int findMax(TreeNode root){
        if( root == null ) return -1;

        while( root.right != null ) root = root.right;

        return root.val;
    }

    List<Integer> sorted = new LinkedList<>();

    public int minDiffInBST2(TreeNode root) {
        inorder(root);

        for( int i = 1; i < sorted.size(); i++ ){
            minDiff = Math.min(minDiff, sorted.get(i)-sorted.get(i-1));
        }

        return minDiff;
    }

    public void inorder(TreeNode root) {
        if( root == null ) return;

        inorder(root.left);
        sorted.add(root.val);
        inorder(root.right);
    }

}
