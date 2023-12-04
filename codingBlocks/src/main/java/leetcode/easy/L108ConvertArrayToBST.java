package leetcode.easy;

import java.util.*;

public class L108ConvertArrayToBST {

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
        new L108ConvertArrayToBST().run();
    }

    public void run(){
        sortedArrayToBST(new int[]{1,2,3,4,5});
    }


    public TreeNode sortedArrayToBST(int[] nums) {

        int start = 0;
        int end = nums.length-1;

        int mid = (start + end) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        bst(root, nums, start, end);

        return root;
    }


    public void bst(TreeNode root, int[] nums, int start, int end){

        if(root == null || start > end) return;

        int mid = (start+end) / 2;

        root.left = new TreeNode(nums[(start+mid)/2]);
        root.right = new TreeNode(nums[(mid+end)/2]);

        bst(root.left, nums, start, mid-1);
        bst(root.right, nums, mid+1, end);
    }
}