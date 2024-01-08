package leetcode.easy;


//[3,9,20,null,null,15,7]
//[1,2,2,3,3,null,null,4,4]
//[]
//[1,2,2,3,null,null,3,4,null,null,4]
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

    public boolean isBalanced2(TreeNode root) {
        if( root == null ) return true;

        return getHeight(root) != Integer.MIN_VALUE;
    }

    public int getHeight(TreeNode root){
        if( root == null ) return 0;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if( leftHeight == Integer.MIN_VALUE ) return Integer.MIN_VALUE;
        if( rightHeight == Integer.MIN_VALUE ) return Integer.MIN_VALUE;

        if( Math.abs(leftHeight-rightHeight) > 1 ) return Integer.MIN_VALUE;

        return Math.max(leftHeight, rightHeight)+1;
    }

}
