package leetcode.easy;

import java.util.*;

//[2,1,3,null,null,0,1]
//[0]
//[3,2,3,2,2,3,2,1,1,2,3,0,1,0,3,null,null,null,null,0,2,3,2,null,null,null,null,null,null,0,0,null,null,1,1,0,0,1,3,null,null,null,null,null,null,null,null,null,null,null,null,null,null,3,0,1,1,null,null,null,null,null,null]
public class L2331EvaluateBinaryTree {

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

    public boolean evaluateTree(TreeNode root) {
        if( root.left == null && root.right == null ) {
            return root.val == 1;
        }

        boolean leftOp = evaluateTree(root.left);
        boolean rightOp = evaluateTree(root.right);

        if( root.val == 2 ) return leftOp || rightOp;
        else return leftOp && rightOp;
    }

}
