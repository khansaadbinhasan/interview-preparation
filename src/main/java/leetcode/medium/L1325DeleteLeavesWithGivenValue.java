package leetcode.medium;

//[1,2,3,2,null,2,4]
//2
//[1,3,3,3,2]
//3
//[1,2,null,2,null,2]
//2
//[1,2,3,2,null,2,4,null,null,null,null,2,2]
//2
public class L1325DeleteLeavesWithGivenValue {

//     Definition for a binary tree node.
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

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if( root == null ) return null;

        removeLeafNodes(root.left, target);
        removeLeafNodes(root.right, target);

        if( root.left != null && root.left.left == null && root.left.right == null && root.left.val == target)
            root.left = null;

        if( root.right != null && root.right.left == null && root.right.right == null && root.right.val == target)
            root.right = null;

        if( root.left == null && root.right == null && root.val == target) return null;

        return root;
    }
}
