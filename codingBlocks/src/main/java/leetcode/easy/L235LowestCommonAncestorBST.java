package leetcode.easy;

//[6,2,8,0,4,7,9,null,null,3,5]
//2
//8
//[6,2,8,0,4,7,9,null,null,3,5]
//2
//4
//[2,1]
//2
//1
//[6,2,8,0,4,7,9,null,null,3,5]
//3
//5
public class L235LowestCommonAncestorBST {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if( root == null ) return null;

        if( p.val < root.val && q.val < root.val )
            return lowestCommonAncestor(root.left, p, q);

        if( p.val > root.val && q.val > root.val )
            return lowestCommonAncestor(root.right, p, q);

        return root;
    }

}
