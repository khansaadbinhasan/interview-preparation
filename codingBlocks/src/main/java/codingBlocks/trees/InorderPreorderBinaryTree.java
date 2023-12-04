package codingBlocks.trees;

import java.util.Arrays;
import java.util.Scanner;

public class InorderPreorderBinaryTree {

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
        new InorderPreorderBinaryTree().run();
    }

    public void run(){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] inorder = new int[n];
        int[] preorder = new int[n];

        for (int i = 0; i < n; i++) {
            preorder[i] = sc.nextInt();
        }

        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            inorder[i] = sc.nextInt();
        }

        TreeNode root = buildTree(preorder, inorder);
        preorderPrinting(root);
    }

    private static int index = 0;
    private static int N = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        N = inorder.length;

        return build( preorder, inorder );
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

    public void preorderPrinting(TreeNode root){
        if( root == null ) return;

        System.out.print(root.left == null ? "END":root.left.val);
        System.out.print(" => ");
        System.out.print(root.val + " <= ");
        System.out.println(root.right == null ? "END":root.right.val);
        preorderPrinting(root.left);
        preorderPrinting(root.right);
    }
}
