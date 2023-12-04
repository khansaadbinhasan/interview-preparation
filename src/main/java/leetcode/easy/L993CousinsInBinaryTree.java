package leetcode.easy;

public class L993CousinsInBinaryTree {
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

    public static void main(String[] args) {
        new L993CousinsInBinaryTree().run();
    }

    public void run(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        System.out.println(isCousins(root, 4, 3));
    }


    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode parent1 = getParent(root, x);
        TreeNode parent2 = getParent(root, y);

        if( parent1 == parent2 ) return false;

        int valDepth1 = getValDepth(root, x, 0);
        int valDepth2 = getValDepth(root, y, 0);

        return (valDepth1 == valDepth2) && (parent1 != parent2);
    }

    public int getValDepth(TreeNode root, int val, int depth){
        if( root == null ) return -1;
        if( root.val == val ) return depth;

        int finalDepth = getValDepth(root.left, val, depth+1);

        if( finalDepth != -1 ) return finalDepth;

        return getValDepth(root.right, val, depth+1);
    }

    public TreeNode getParent(TreeNode root, int val){
        if( root == null ) return null;
        if( root.left != null && root.left.val == val ) return root;
        if( root.right != null && root.right.val == val ) return root;

        TreeNode parent = getParent(root.left, val);

        if( parent != null ) {
            return parent;
        }

        return getParent(root.right, val);
    }

}
