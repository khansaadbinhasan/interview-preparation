package leetcode.medium;


//[1,2,3]
//[-10,9,20,null,null,15,7]
//[1,2,3,4,5,6,7]
//[-1,-2,-3,-4,-5,-6,-7,-100,-1000]
//[0,1,-1,-10,100,-100,9,99,10,-90]
public class L124BinaryTreeMaxPathSum {

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

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        getPathSum(root);

        return maxSum;
    }

    public int getPathSum(TreeNode node){

        if( node == null ) return 0;

        int leftSum = getPathSum(node.left);
        int rightSum = getPathSum(node.right);
        int currSum = getMaxOfArr(new int[]{leftSum + node.val, node.val + rightSum, node.val});

        maxSum = getMaxOfArr(new int[]{maxSum, currSum, leftSum + node.val + rightSum});

        return currSum;
    }

    public int getMaxOfArr(int[] nums){
        int maxVal = Integer.MIN_VALUE;

        for( int num: nums ){
            if( num > maxVal ) maxVal = num;
        }

        return maxVal;
    }

    int globalMax = Integer.MIN_VALUE;

    public int maxPathSum2(TreeNode root) {
        if( root == null ) return 0;
        maxSum(root);
        return globalMax;
    }

    public int maxSum(TreeNode root) {
        if( root == null ) return 0;

        int leftSum = maxSum(root.left);
        int rightSum = maxSum(root.right);
        int currSum = Math.max(Math.max(root.val+leftSum, root.val+rightSum),root.val);

        globalMax = Math.max(Math.max(currSum, globalMax), leftSum + root.val + rightSum);

        return currSum;
    }
}
