package leetcode.medium;


//[1,2,3,4,5,null,6,7,null,null,null,null,8]
//[6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
//[1]
//[1,2,3]
//[1,2,3,4,5]
public class L1302DeepestLeavesSum {

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

    public int deepestLeavesSum(TreeNode root) {
        int maxDepth = maxDepth(root, 0);
        return deepestLeavesSum(root, maxDepth, 1, 0);
    }

    public int deepestLeavesSum(TreeNode root, int maxDepth, int currDepth, int sum) {
        if( root == null ) return sum;

        if( currDepth == maxDepth ) sum += root.val;

        sum = deepestLeavesSum(root.left, maxDepth, currDepth+1, sum);

        return deepestLeavesSum(root.right, maxDepth, currDepth+1, sum);
    }

    public int maxDepth(TreeNode root, int maxDepth){

        if( root == null ) return maxDepth;

        return Math.max(
                maxDepth(root.left, maxDepth + 1),
                maxDepth(root.right, maxDepth + 1)
        );
    }
}
