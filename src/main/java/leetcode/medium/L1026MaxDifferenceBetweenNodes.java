package leetcode.medium;

import java.util.*;


public class L1026MaxDifferenceBetweenNodes {

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

    public int maxAncestorDiff(TreeNode root) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        maxAncestorDiff(root, pq);

        return pq.poll();
    }

    public void maxAncestorDiff(TreeNode root, PriorityQueue<Integer> diffs){
        if( root == null ) return;

        diffs.add(findDiff(root, root.val, 0));

        maxAncestorDiff(root.left, diffs);
        maxAncestorDiff(root.right, diffs);
    }

    public int findDiff(TreeNode root, int rootVal, int currDiff){
        if( root == null ) return currDiff;

        if( Math.abs(root.val - rootVal) > currDiff  ) currDiff = Math.abs(root.val - rootVal);

        return Math.max(findDiff(root.left, rootVal, currDiff), findDiff(root.right, rootVal, currDiff));
    }


}
