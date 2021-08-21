package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



//1 4 6 -1 -1 -1 -1
public class MaxPathSum {

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

    public static void main(String[] args) {
        new MaxPathSum().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        String[] inpStrArr = sc.nextLine().trim().split(" ");

        TreeNode root = levelOrderInsertion(null, new TreeNode(Integer.parseInt(inpStrArr[0])));

        for (int i = 1; i < inpStrArr.length; i++) {
            int val = Integer.parseInt(inpStrArr[i]);
            if( val != - 1) levelOrderInsertion(root, new TreeNode(val));
        }

        System.out.println(maxPathSum(root));
    }

    public TreeNode levelOrderInsertion(TreeNode root, TreeNode node) {

        if( root == null ) return node;

        Queue<TreeNode> treeQueue = new LinkedList<>();

        treeQueue.add(root);

        while (!treeQueue.isEmpty()) {
            TreeNode polledNode = treeQueue.poll();

            if( polledNode == null ) continue;

            if( polledNode.left == null ){
                polledNode.left = node;
                return root;
            }

            else if( polledNode.right == null ){
                polledNode.right = node;
                return root;
            }

            else {
                treeQueue.add(polledNode.left);
                treeQueue.add(polledNode.right);
            }

            treeQueue.add(node.left);
            treeQueue.add(node.right);
        }

        return root;
    }

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
}
