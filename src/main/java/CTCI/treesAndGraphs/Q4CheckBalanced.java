package CTCI.treesAndGraphs;

public class Q4CheckBalanced {

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

    public boolean isBalancedII(TreeNode root){
        return checkHeight(root) != Integer.MIN_VALUE;
    }

    public int checkHeight(TreeNode root){
        if( root == null ) return -1;

        int leftHeight = checkHeight(root.left);
        if( leftHeight == Integer.MIN_VALUE ) return Integer.MIN_VALUE;

        int rightHeight = checkHeight(root.right);
        if( rightHeight == Integer.MIN_VALUE ) return Integer.MIN_VALUE;

        int heightDiff = leftHeight - rightHeight;

        if( Math.abs(heightDiff) > 1 ) return Integer.MIN_VALUE;
        else return Math.max(leftHeight, rightHeight) + 1;
    }

}
