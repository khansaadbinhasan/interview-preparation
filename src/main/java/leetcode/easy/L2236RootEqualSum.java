package leetcode.easy;

//[10,4,6]
//[5,3,1]
//[-5,3,-1]
//[-10, -5,-5]
//[0, 5, -5]
public class L2236RootEqualSum {

    public boolean checkTree(TreeNode root) {
        return root.val == root.left.val + root.right.val;
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
