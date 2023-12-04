package leetcode.easy;

//[1,1,1,1,1,null,1]
//[2,2,2,5,2]
//[1]
//[1,1,1]
//[1,2,1]
//[2,1,1]
//[2,1,1,1]
//[1,1,1,1]
public class L965UnivalBinaryTree {

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


    public boolean isUnivalTree(TreeNode root) {

        if( (root == null) || (root.left == null && root.right == null) ) return true;

        if( root.left == null && root.right != null ) return ( root.val == root.right.val ) && isUnivalTree(root.right);

        if( root.left != null && root.right == null ) return ( root.val == root.left.val ) && isUnivalTree(root.left);

        return ( root.val == root.left.val && root.val == root.right.val ) &&
                isUnivalTree(root.left) &&
                isUnivalTree(root.right);

    }


}
