package leetcode.easy;

//[4,2,7,1,3]
//2
//[4,2,7,1,3]
//5
//[1]
//2
//[1]
//1
public class L700SearchBST {

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

    public TreeNode searchBST(TreeNode root, int val) {

        if( root == null ) return null;

        if( val == root.val ) return root;

        TreeNode node = null;

        if( val < root.val ) node = searchBST(root.left, val);
        else if( val > root.val ) node = searchBST(root.right, val);

        return node;
    }

}
