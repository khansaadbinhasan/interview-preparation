package leetcode.easy;

import java.util.*;

//[2,2,5,null,null,5,7]
//[2,2,2]
//[1,1,100]
//[2]
public class L671SecondMinInBinTree {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public int findSecondMinimumValue(TreeNode root) {
        fillMinHeap(root);
        int min = minHeap.poll();
        if( minHeap.isEmpty() ) return -1;
        int min2 = minHeap.poll();

        while( min == min2 && !minHeap.isEmpty() ){
            min2 = minHeap.poll();
        }

        return min == min2 ? -1: min2;
    }

    public void fillMinHeap(TreeNode root){
        if( root == null ) return;

        minHeap.add(root.val);

        fillMinHeap(root.left);
        fillMinHeap(root.right);
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
}
