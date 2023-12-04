package leetcode.easy;

//[10,5,15,3,7,null,18]
//7
//15
//[10,5,15,3,7,13,18,1,null,6]
//6
//10
public class L938RangeSumOfBST {

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

    int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        if( root == null ) return sum;

        if( root.val >= low && root.val <= high ) sum += root.val;
        rangeSumBST(root.left, low, high);
        rangeSumBST(root.right, low, high);

        return sum;
    }


}
