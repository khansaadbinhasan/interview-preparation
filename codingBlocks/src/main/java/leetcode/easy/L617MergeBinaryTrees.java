package leetcode.easy;

//[1,3,2,5]
//[2,1,3,null,4,null,7]
//[1]
//[1,2]
//[]
//[1]
//[1]
//[]
public class L617MergeBinaryTrees {

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


        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if( root2 == null ) return root1;

        if( root1 == null ) root1 = new TreeNode();

        return mergeTrees2(root1, root2);
    }

    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2){
        if( root1 == null || root2 == null ) return null;

        if( root1.left == null && root2.left != null ) root1.left = new TreeNode();
        mergeTrees2(root1.left, root2.left);

        if( root1.val != 0 ) root1.val += root2.val;
        else root1.val = root2.val;

        if( root1.right == null && root2.right != null ) root1.right = new TreeNode();
        mergeTrees2(root1.right, root2.right);

        return root1;
    }

}
