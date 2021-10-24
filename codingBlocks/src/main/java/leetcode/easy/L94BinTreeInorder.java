package leetcode.easy;

import java.util.*;

public class L94BinTreeInorder {

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

    List<Integer> inorderLst = new LinkedList<>();

    public List<Integer> inorderTraversal(TreeNode root) {

        if( root == null ) return inorderLst;


        inorderTraversal(root.left);
        inorderLst.add(root.val);
        inorderTraversal(root.right);


        return inorderLst;
    }


}
