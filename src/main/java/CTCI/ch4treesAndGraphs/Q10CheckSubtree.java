package CTCI.ch4treesAndGraphs;


//[3,4,5,1,2]
//[4,1,2]
//[3,4,5,1,2,null,null,null,null,0]
//[4,1,2]
//[1]
//[1]
//[1]
//[2]
//[1,2,3,null,4,5,6,null,null,7,8]
//[1,2,3]
//[1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,2]
//[1,null,1,null,1,null,1,null,1,null,1,2]
public class Q10CheckSubtree {

    class TreeNode{
        public int val;

        public TreeNode left;
        public TreeNode right;
        public TreeNode parent;
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if( subRoot == null ) return true;
        if( root == null ) return false;

        if( isSubtree2(root, subRoot) ) return true;

        return  isSubtree(root.left, subRoot) ||
                isSubtree(root.right, subRoot);
    }

    public boolean isSubtree2(TreeNode root, TreeNode subRoot) {

        if( subRoot == null ) return true;
        if( root == null ) return false;

        if(
                (
                        (root.left == null || subRoot.left == null) &&
                                root.left != subRoot.left
                ) ||
                        (
                                (root.right == null || subRoot.right == null) &&
                                        root.right != subRoot.right
                        )
        )
            return false;

        return  (root.val == subRoot.val) &&
                (root.left == subRoot.left || root.left.val == subRoot.left.val) &&
                (root.right == subRoot.right || root.right.val == subRoot.right.val) &&
                isSubtree2(root.left, subRoot.left) &&
                isSubtree2(root.right, subRoot.right);
    }

}
