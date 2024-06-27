package CTCI.ch4treesAndGraphs;

public class Q6InorderSuccessor {

    public class TreeNode {
        int val;

        TreeNode left;
        TreeNode right;
        TreeNode parent;
        boolean visited;

        TreeNode() {}

        TreeNode(int val) { this.val = val; }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.visited = false;
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




    public TreeNode successor(TreeNode root){
        if( root == null ) return null;

        TreeNode successor = successor(root.left);

        if( successor != null && !root.left.visited ) {
            return successor;
        }
        if( !root.visited ) return root;
        TreeNode right = successor(root.right);
        if( right != null ) return right;

        return successor(root.parent);
    }

    public static void main(String[] args) {
        new Q6InorderSuccessor().run();
    }

    public void run(){
        TreeNode root = new TreeNode(1);
        root.parent = null; root.left = new TreeNode(2); root.right = new TreeNode(3);
        root.left.parent = root; root.right.parent = root;
        System.out.println(successor(root).val + " --> 2");
        System.out.println(successor(root.left).val + " --> 2");
        System.out.println(successor(root.right).val + " --> 3");

    }






}
