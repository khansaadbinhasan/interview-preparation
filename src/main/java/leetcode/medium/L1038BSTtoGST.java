package leetcode.medium;

public class L1038BSTtoGST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode bstToGst(TreeNode root) {
        return bstToGst(root, 0);
    }

    public TreeNode bstToGst(TreeNode root, int rootSum) {
        if (root == null) return root;

        root.val = getSum(root.right, rootSum) + root.val;
        bstToGst(root.left, root.val);
        bstToGst(root.right, rootSum);

        return root;
    }

    public int getSum(TreeNode root, int sum) {
        if (root == null) return sum;

        sum += root.val;
        sum = getSum(root.right, sum);
        return getSum(root.left, sum);
    }

}
