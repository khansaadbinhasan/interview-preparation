package leetcode.medium;

import java.util.*;




public class L662MaxWidthOfBinaryTree {

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

    public int widthOfBinaryTree(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();

        int width = 0;
        int maxW = 0;

        q.add(root);
        q.add(null);

        while( !q.isEmpty() ){
            TreeNode node = q.poll();

            // System.out.println(node != null ? node.val: "null");

            if( node == null ) {
                if( !q.isEmpty() ) q.add(node);
                width = 0;
                continue;
            }

            if( node.left != null ) q.add(node.left);
            if( node.right != null ) q.add(node.right);

            width++;
            maxW = Math.max(maxW, width);
        }

        return maxW;

    }

}
