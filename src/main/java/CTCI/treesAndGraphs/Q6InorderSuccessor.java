package CTCI.treesAndGraphs;

public class Q6InorderSuccessor {

    public class TreeNode {
        int val;

        TreeNode left;
        TreeNode right;
        TreeNode parent;

        TreeNode() {}

        TreeNode(int val) { this.val = val; }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    TreeNode inorderSuccessor(TreeNode n){
        if( n == null ) return null;

        if( n.right != null ) return leftMostChild(n.right);
        else {
            TreeNode q = n;
            TreeNode x = q.parent;

            while( x != null && x.left != q ){
                q = x;
                x = x.parent;
            }

            return x;
        }
    }

    TreeNode leftMostChild(TreeNode n){

        if( n == null ) return null;

        while( n.left != null ) {
            n = n.left;
        }

        return n;
    }



}
