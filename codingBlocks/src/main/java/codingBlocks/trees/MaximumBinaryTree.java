package codingBlocks.trees;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumBinaryTree {

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
        new MaximumBinaryTree().run();
    }

    public void run(){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        TreeNode root = constructMaximumBinaryTree(nums);
        inOrderPrinting(root);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {

        if( nums.length == 0 ) return null;

        int maxIndex = getMaxIndex(nums);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, maxIndex));
        root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, maxIndex+1, nums.length));

        return root;
    }

    public int getMaxIndex(int[] nums){

        if( nums.length == 0 ) return -1;

        int maxInd = 0;

        for (int i = 1; i < nums.length; i++) {
            if( nums[i] > nums[maxInd] ) maxInd = i;
        }

        return maxInd;
    }

    public void inOrderPrinting(TreeNode root){
        if( root == null ) return;

        inOrderPrinting(root.left);
        System.out.print(root.val + " ");
        inOrderPrinting(root.right);
    }

}
