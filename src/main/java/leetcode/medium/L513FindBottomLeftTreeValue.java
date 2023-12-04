package leetcode.medium;

//[2,1,3]
//[1,2,3,4,null,5,6,null,null,7]
//[1]
//[1,2,3,4,5,6,7,8,9]
public class L513FindBottomLeftTreeValue {

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

    public int findBottomLeftValue(TreeNode root) {

        if( root.left == null && root.right == null ) return root.val;

        int leftTreeDepth = findDepth(root.left, 1);
        int rightTreeDepth = findDepth(root.right, 1);

        if( leftTreeDepth >= rightTreeDepth ){
            return findBottomLeftValue(root.left);
        }

        else{
            return findBottomLeftValue(root.right);
        }

    }



    public int findDepth(TreeNode root, int depth){
        if( root == null ) return depth;

        return Math.max( findDepth(root.left, depth+1), findDepth(root.right, depth+1) );
    }


}
