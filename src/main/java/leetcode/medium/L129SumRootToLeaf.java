package leetcode.medium;

public class L129SumRootToLeaf {

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

    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0, 0);
    }

    public int sumNumbers(TreeNode root, int currNumber, int sum) {
        if( root == null ) return sum+currNumber;

        int n1 = currNumber*10 + root.val;
        int n2 = currNumber*10 + root.val;

        return sumNumbers(root.right, n2, sumNumbers(root.left, n1, sum));
    }

    public static void main(String[] args) {
        new L129SumRootToLeaf().run();
    }

    public void run(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(sumNumbers(root));
    }

}
