package leetcode.medium;

//[4,2,7,1,3]
//5
//[40,20,60,10,30,50,70]
//25
//[4,2,7,1,3,null,null,null,null,null,null]
//5
//[1]
//2
//[40,20,60,10,30,50,70]
//7
public class L701InsertIntoBinaryTree {

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

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if( root == null ) return root = new TreeNode(val);

        if( val > root.val ) {
            if( root.right == null ) {
                root.right = new TreeNode(val);
                return root;
            }
            insertIntoBST(root.right, val);
        }
        else {
            if( root.left == null ) {
                root.left = new TreeNode(val);
                return root;
            }
            insertIntoBST(root.left, val);
        }

        return root;
    }
}
