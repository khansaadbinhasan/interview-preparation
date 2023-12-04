package CTCI.treesAndGraphs;

public class Q5IsBST {
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


    public boolean isValidBST(TreeNode root) {

        if( root == null ) return true;

        return !isGreaterOrEqual(root.left, root.val) && !isLesserOrEqual(root.right, root.val) &&
                isValidBST(root.left) && isValidBST(root.right);

    }

    public boolean isLesserOrEqual(TreeNode root, int val){
        if( root == null ) return false;

        return root.val <= val || isLesserOrEqual(root.left, val) || isLesserOrEqual(root.right, val);
    }

    public boolean isGreaterOrEqual(TreeNode root, int val){
        if( root == null ) return false;

        return root.val >= val || isGreaterOrEqual(root.left, val) || isGreaterOrEqual(root.right, val);
    }


    int index = 0;

    void copyBST(TreeNode root, int[] array){
        if( root == null ) return;

        copyBST(root.left, array);
        array[index++] = root.val;
        copyBST(root.right, array);
    }

    boolean checkBSTI(TreeNode root){
        int[] array = new int[10000];
        copyBST(root, array);

        for (int i = 1; i <= index; i++) {
            if( array[i] <= array[i-1] ) return false;
        }

        return true;
    }

    Integer last_printed = null;

    boolean checkBSTII(TreeNode n){

        if( n == null ) return true;

        if( !checkBSTII(n.left) ) return false;

        if( last_printed != null && n.val <= last_printed ) return false;

        last_printed = n.val;

        if( !checkBSTII(n.right) ) return false;

        return true;
    }

    boolean checkBSTIII(TreeNode n){
        return checkBSTIII(n, null, null);
    }

    boolean checkBSTIII(TreeNode n, Integer min, Integer max){

        if( n == null ) return true;

        if( (min != null && n.val <= min) || (max != null && n.val > max) )
            return false;

        if( !checkBSTIII(n.left, min, n.val) || !checkBSTIII(n.right, n.val, max) )
            return false;

        return true;
    }



































}
