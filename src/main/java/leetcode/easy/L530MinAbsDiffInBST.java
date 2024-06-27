package leetcode.easy;

import java.util.*;

public class L530MinAbsDiffInBST {

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

//    public int getMinimumDifference(TreeNode root) {
//
//    }
//
//    public int getNext(TreeNode root){
//
//    }

    int minDiff = Integer.MAX_VALUE;
    List<Integer> sorted = new LinkedList<>();

    public int getMinimumDifference(TreeNode root) {
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
