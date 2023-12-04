package leetcode.easy;

//[5,4,8,11,null,13,4,7,2,null,null,null,1]
//22
//[1,2,3]
//5
//[1,2]
//0
//[]
//0
//[]
//1
//[1,2]
//1
//[1,2]
//2
public class L112PathSumI {

    class TreeNode{
        public int val;

        public TreeNode left;
        public TreeNode right;
        public TreeNode parent;
    }


    public boolean hasPathSum(TreeNode root, int targetSum) {
        if( root == null ){
            // if( targetSum == 0 ) return true;
            return false;
        }

        return  (root.val == targetSum && (root.left == null && root.right == null)) ||
                hasPathSum(root.left, targetSum-root.val) ||
                hasPathSum(root.right, targetSum-root.val);
    }


}
