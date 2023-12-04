package leetcode.medium;

//[10,5,-3,3,2,null,11,3,-2,null,1]
//8
//[5,4,8,11,null,13,4,7,2,null,null,5,1]
//22
//[1,2,3]
//5
//[1,2]
//0
//[]
//0
//[]
//1
//[5,4,8,11,null,13,4,7,2,null,null,null,1]
//22
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


public class L437PathSumIII {

    class TreeNode{
        public int val;

        public TreeNode left;
        public TreeNode right;
        public TreeNode parent;
    }


    int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if( root == null ) return 0;

        hasPathSum(root, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);

        return count;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if( root == null ) return false;

        boolean hasPathSum = false;

        if( root.val == targetSum ) {
            count++;
            hasPathSum = true;
        }

        return  hasPathSum(root.left, targetSum-root.val) ||
                hasPathSum(root.right, targetSum-root.val);
    }


}
