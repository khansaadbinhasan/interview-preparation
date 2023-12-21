package leetcode.blind75;

import java.util.LinkedList;
import java.util.List;

public class L230KthSmallestElementInBST {

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

    public int kthSmallest(TreeNode root, int k) {

        List<Integer> treeLst = new LinkedList<>();

        inorder( root, treeLst );

        return treeLst.get(k-1);

    }

    public void inorder( TreeNode root, List<Integer> treeLst ){
        if( root == null ) return;

        inorder( root.left, treeLst );
        treeLst.add( root.val );
        inorder( root.right, treeLst );
    }

}
