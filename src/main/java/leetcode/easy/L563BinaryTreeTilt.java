package leetcode.easy;

//121
//-121
//10
//-101
//0
//-2147483647
//2147483646
public class L563BinaryTreeTilt {

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

    public int findTilt(TreeNode root) {
        if( root == null ) return 0;

        return findTiltSum(root, 0);
    }

    public int findTiltSum(TreeNode root, int sum) {
        if( root == null ) return sum;

        sum += Math.abs(sum(root.left, 0) - sum(root.right, 0));
        sum = findTiltSum(root.left, sum);
        sum = findTiltSum(root.right, sum);

        return sum;
    }

    public int sum(TreeNode root, int sum){
        if( root == null ) return sum;
        sum += root.val;
        sum = sum(root.left, sum);
        return sum(root.right, sum);
    }
}
