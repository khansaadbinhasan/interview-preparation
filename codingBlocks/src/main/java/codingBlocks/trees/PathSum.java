package codingBlocks.trees;

import java.util.Scanner;

public class PathSum {

     private class TreeNode {
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


    static int sum = 0;
     private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new PathSum().run();
    }

    public void run(){

        TreeNode root = new TreeNode(sc.nextInt());
        root = takeInput(root);
        sum = sc.nextInt();

        System.out.println(isPossible(root, 0));
    }

    public TreeNode takeInput(TreeNode root){

        String str = sc.next();

        if( str.equals("true") ){
            root.left = new TreeNode(sc.nextInt());
            takeInput(root.left);
        }
        else if( str.equals("false") ) root.left = null;
        else return null;

        str = sc.next();

        if( str.equals("true") ){
            root.right = new TreeNode(sc.nextInt());
            takeInput(root.right);
        }
        else if( str.equals("false") ) root.right = null;
        else return null;

        return root;
    }

    public boolean isPossible(TreeNode root, int currSum){

        if( root == null ) return false;
        if( root.left == null && root.right == null ) return currSum + root.val == sum;

        return isPossible(root.left, currSum + root.val) || isPossible(root.right, currSum + root.val);
    }

}
