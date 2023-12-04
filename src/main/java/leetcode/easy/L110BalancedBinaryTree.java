package leetcode.easy;


//[3,9,20,null,null,15,7]
//[1,2,2,3,3,null,null,4,4]
//[]
public class L110BalancedBinaryTree {

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


    public boolean isBalanced(TreeNode root) {

        if( root == null ) return true;

        return (Math.abs(getMaxHeight(root.left, 1) - getMaxHeight(root.right, 1)) <= 1)
                && isBalanced(root.left) && isBalanced(root.right);
    }

    public int getMaxHeight(TreeNode root, int currHeight){
        if( root == null ) return currHeight;

        return Math.max(getMaxHeight(root.left, currHeight), getMaxHeight(root.right, currHeight)) + 1;
    }

}
