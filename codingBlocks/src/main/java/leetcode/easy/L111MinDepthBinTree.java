package leetcode.easy;

//[3,9,20,null,null,15,7]
//[2,null,3,null,4,null,5,null,6]
//[]
//[1]
//[1,2,3,4,5,6,7,8,9,0]
public class L111MinDepthBinTree {

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

    public int minDepth(TreeNode root) {

        if( root == null ) return 0;

        if( root.left == null && root.right == null ) return 1;

        if( root.left == null && root.right != null ) return minDepth(root.right) + 1;
        if( root.right == null && root.left != null ) return minDepth(root.left) + 1;


        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

}
