package leetcode.easy;

//[4,2,7,1,3,6,9]
//[2,1,3]
//[]
public class L226InvertBinaryTree {

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

    public TreeNode invertTree(TreeNode root) {

        if( root == null ) return null;

        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;

        invertTree(root.right);
        invertTree(root.left);

        return root;
    }

}
