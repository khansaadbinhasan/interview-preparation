package leetcode.medium;

//[4,8,5,0,1,null,6]
//[1]
//[1,2,3,4,5,6,7,8,9,10]
//[1,null,3,null,1,null,3]
public class L2265CountNodesEqualAverage {

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

    public static void main(String[] args) {
        new L2265CountNodesEqualAverage().run();
    }

    public void run(){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        root.right.right.right = new TreeNode(3);
        System.out.println(averageOfSubtree(root));
    }

    public int averageOfSubtree(TreeNode root) {
        return averageOfSubtree(root, 0);
    }

    public int averageOfSubtree(TreeNode root, int count) {
        if( root == null ) return count;

        return averageOfSubtree(root.left, count) + averageOfSubtree(root.right, count) + (isAverageEqual(root)?1:0);
    }

    public boolean isAverageEqual(TreeNode root){
        if( root == null ) return false;

        return root.val == (getSum(root, 0) / getCount(root, 0));
    }

    public int getSum(TreeNode root, int sum){
        if( root == null ) return sum;

        return getSum(root.left, sum) + getSum(root.right, sum) + root.val;
    }

    public int getCount(TreeNode root, int count){
        if( root == null ) return count;

        return getCount(root.left, count) + getCount(root.right, count)+1;
    }

}
