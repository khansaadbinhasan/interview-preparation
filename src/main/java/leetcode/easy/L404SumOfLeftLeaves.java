package leetcode.easy;

//[3,9,20,null,null,15,7]
//[1]
//[10]
//[3,9,20,10,1000,15,7]
public class L404SumOfLeftLeaves {

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

    public int sumOfLeftLeaves(TreeNode root) {
        return getSum(root, 0);
    }

    public int getSum(TreeNode root, int sum){

        if( root == null ) return sum;

        if( root.left != null && root.left.left == null && root.left.right == null ){
            sum += root.left.val;
        }

        sum = getSum(root.left, sum);
        return getSum(root.right, sum);
    }
}
