package leetcode.medium;

import java.util.*;

public class L105ConstructBinaryTreeFromPreorderandInorderTraversal {


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


    private int index = 0;
    private int N = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        N = inorder.length;

        TreeNode root = build( preorder, inorder );

        return root;
    }

    public TreeNode build(int[] preorder, int[] inorder){
        if( inorder.length == 0 || index >= N ) return null;

        TreeNode root = new TreeNode(preorder[index]);

        int indRoot = getIndexRoot(inorder, root.val);
        index++;

        int[] left;
        int[] right;

        if( indRoot == -1 ){
            left = new int[0];
            right = new int[0];
        }

        else {
            left = Arrays.copyOfRange(inorder, 0, indRoot);
            right = Arrays.copyOfRange(inorder, indRoot+1, inorder.length);
        }

        root.left = build(preorder, left);
        root.right = build(preorder, right);

        return root;
    }

    private int getIndexRoot(int[] inorder, int val) {

        for (int i = 0; i < inorder.length; i++) {
            if( inorder[i] == val ) return i;
        }

        return -1;
    }
}
