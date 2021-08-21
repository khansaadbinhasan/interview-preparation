package trees;

import java.util.Arrays;
import java.util.Scanner;


//4
//4 1 3 2
//4 3 2 1

//5
//9 3 15 20 7
//9 15 7 20 3


public class InorderPostorderBinaryTree {

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
        new InorderPostorderBinaryTree().run();
    }

    static int index = 0;

    public void run(){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] inorder = new int[N];
        int[] postorder = new int[N];

        for (int i = 0; i < N; i++) {
            inorder[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            postorder[i] = sc.nextInt();
        }

        index = N-1;
        TreeNode root = buildTree(inorder, postorder);

        preorderPrinting(root);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if( inorder.length == 0 || index < 0 ) return null;

        TreeNode root = new TreeNode(postorder[index]);

        int indRoot = getIndexRoot(inorder, root.val);
        index--;

        int[] left = Arrays.copyOfRange(inorder, 0, indRoot);
        int[] right = Arrays.copyOfRange(inorder, indRoot+1, inorder.length);

        if( indRoot == -1 ){
            left = new int[0];
            right = new int[0];
        }

        root.right = buildTree(right, postorder);
        root.left = buildTree(left, postorder);

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

        System.out.print(root.val + " ");
        preorderPrinting(root.left);
        preorderPrinting(root.right);
    }
}
