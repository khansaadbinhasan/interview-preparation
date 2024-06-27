package leetcode.medium;


//[3,0,0]
//[0,3,0]
//[1]
//[1,1,1,1,1,1,1,1,1,1,1]
//[0,0,0,0,0,0,7]
//[1,2,0,1,2,0,0,0,2,2]
public class L979DistributeCoinsInBinaryTree {


    public int distributeCoins2(TreeNode root) {
        if( root == null ) return 0;

        int coins = 0;

        int leftVal = distributeCoins(root.left);
        int rightVal = distributeCoins(root.right);
        coins += Math.abs(leftVal);
        coins += Math.abs(rightVal);

        root.val += leftVal+rightVal-1;

        return coins+root.val;
    }


    public void run2(){
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(7);

        System.out.println(distributeCoins2(root));
    }














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
        new L979DistributeCoinsInBinaryTree().run2();
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

    public int distributeCoins3(TreeNode root) {
        makeVals(root);
        return doSum(root);
    }
    public void makeVals(TreeNode root) {
        if( root == null ) return;

        makeVals(root.left);
        makeVals(root.right);

        root.val += -1;
        if( root.left != null ) root.val += root.left.val;
        if( root.right != null ) root.val += root.right.val;
    }

    public int doSum(TreeNode root){
        if( root == null ) return 0;

        return Math.abs(root.val) + doSum(root.left) + doSum(root.right);
    }
}
