package codingBlocks.trees;

import java.util.Scanner;

//4 true 2 true 3 false false true 1 false false true 6 true 5 false false false
//10 2

public class AddRowToTree {

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

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }


    public static void main(String[] args) {
        new AddRowToTree().run();
    }

    private Scanner sc = new Scanner(System.in);

    public void run(){
        TreeNode root = new TreeNode(sc.nextInt());
        root = takeInput(root);

        int val = sc.nextInt();
        int depth = sc.nextInt();

        root = addOneRow(root, val, depth);
        preorderPrinting(root);
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

    public TreeNode addOneRow(TreeNode root, int val, int depth) {

        if( root == null ) return null;

        if( depth == 1 ){
            TreeNode node = new TreeNode(val);
            node.left = root;

            return node;
        }

        return addRow(root, 1, val, depth);
    }

    public TreeNode addRow(TreeNode root, int currDepth, int val, int depth){
        if( root == null ) return null;
        if( currDepth >= depth ) return null;

        if( currDepth == depth - 1 ){
            TreeNode node1 = new TreeNode(val);
            node1.left = root.left;
            root.left = node1;

            TreeNode node2 = new TreeNode(val);
            node2.right = root.right;
            root.right = node2;

            return root;
        }

        addRow(root.left, currDepth+1, val, depth);
        addRow(root.right, currDepth+1, val, depth);

        return root;
    }

    public void preorderPrinting(TreeNode root){
        if( root == null ) return;

        System.out.print(root.left == null ? "":root.left.val);
        System.out.print(" <- ");
        System.out.print(root.val + " -> ");
        System.out.println(root.right == null ? "":root.right.val);
        preorderPrinting(root.left);
        preorderPrinting(root.right);
    }
}
