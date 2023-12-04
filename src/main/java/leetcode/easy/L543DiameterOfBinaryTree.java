package leetcode.easy;

//[1,2,3,4,5]
//[1,2]
//[1,4,3,2,null,1,3,3,4,4,5,5,6,7]
//[1,null,3,3,3,3,3,3,3,3]
//[1]
public class L543DiameterOfBinaryTree {

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

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if( root == null ) return 0;

        max = Math.max(max, findMax(root.left) + findMax(root.right));
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);

        return max;
    }

    public int findMax(TreeNode root){
        if( root == null ) return 0;

        return  Math.max(findMax(root.left), findMax(root.right)) + 1;
    }

}
