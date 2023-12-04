package leetcode.medium;

public class L98ValidateBST {

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


    public boolean isValidBST(TreeNode root) {

        if( root == null ) return true;

        return !isGreaterOrEqual(root.left, root.val) && !isLesserOrEqual(root.right, root.val) &&
                isValidBST(root.left) && isValidBST(root.right);

    }

    public boolean isLesserOrEqual(TreeNode root, int val){
        if( root == null ) return false;

        return root.val <= val || isLesserOrEqual(root.left, val) || isLesserOrEqual(root.right, val);
    }

    public boolean isGreaterOrEqual(TreeNode root, int val){
        if( root == null ) return false;

        return root.val >= val || isGreaterOrEqual(root.left, val) || isGreaterOrEqual(root.right, val);
    }

}
