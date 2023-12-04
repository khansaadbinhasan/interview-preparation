package leetcode.medium;


//[3,0,0]
//[0,3,0]
//[1]
//[1,1,1,1,1,1,1,1,1,1,1]
//[0,0,0,0,0,0,7]
//[1,2,0,1,2,0,0,0,2,2]
public class L979DistributeCoinsInBinaryTree {

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
        new L979DistributeCoinsInBinaryTree().run();
    }

    public void run(){
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(3);
        root.right = new TreeNode(0);

        System.out.println(distributeCoins(root));
    }

    public int distributeCoins(TreeNode root) {
        return distributeCoins(root, 0);
    }


    public int distributeCoins(TreeNode root, int count) {
        if( root == null ) return count;

        int leftSum = findSum(root.left, 0);
        int rightSum = findSum(root.right, 0);

        int leftCount = nodeCount(root.left, 0);
        int rightCount = nodeCount(root.right, 0);


        if( leftSum > leftCount ){
            count += leftSum-leftCount;
            root.val += leftSum-leftCount;
            leftSum = leftCount;
        }

        if( rightSum > rightCount ){
            count += rightSum-rightCount;
            root.val += rightSum-rightCount;
            rightSum = rightCount;
        }

        if( root.val > 1 ){
            if( leftCount > leftSum ){
                count += leftCount-leftSum;
                root.left.val += leftCount-leftSum;
                leftSum = leftCount;
            }

            if( rightCount > rightSum ){
                count += rightCount-rightSum;
                root.right.val += rightCount-rightSum;
                rightSum = rightCount;
            }
        }


        return distributeCoins(root.right, distributeCoins(root.left, count));
    }

    public int findSum(TreeNode root, int sum){
        if( root == null ) return sum;

        sum += root.val;

        return findSum(root.right, findSum(root.left, sum));
    }

    public int nodeCount(TreeNode root, int count){
        if(root == null) return count;

        count++;

        return nodeCount(root.right, nodeCount(root.left, count));
    }
}
