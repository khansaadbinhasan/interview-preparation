package leetcode.medium;

public class L2385AmountOfTimeForBinaryTreeToBeInfected {

    public class TreeNode {
        int val;

        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) { this.val = val; }
    }


    public int amountOfTime(TreeNode root, int start) {
        int leftH = getHeight(root.left);
        int rightH = getHeight(root.right);
        int startH = getHeight(getStart(root, start));

        boolean isInLeft = isInTree(root.left, start);

        if( root.val == start ) {
            return Math.max(rightH, leftH);
        }

        if( isInLeft ) {
            return Math.max(rightH+(leftH-startH)+1, startH);//2+3-1+1
        }

        return Math.max(leftH+(rightH-startH)+1, startH);
    }

    public int getHeight(TreeNode root){
        if( root == null ) return 0;

        return Math.max(getHeight(root.left), getHeight(root.right))+1;
    }

    public boolean isInTree(TreeNode root, int start){
        if( root == null ) return false;
        if( root.val == start ) return true;

        return isInTree(root.left, start) || isInTree(root.right, start);
    }

    public TreeNode getStart(TreeNode root, int start){
        if( root == null ) return null;
        if(root.val == start) return root;

        if( getStart( root.left, start ) != null ) return root.left;

        return getStart(root.right, start);
    }

}
