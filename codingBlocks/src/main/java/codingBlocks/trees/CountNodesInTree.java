package codingBlocks.trees;

import java.util.Scanner;

//1 true 2 true 4 false false false true 3 false false
//1 true 2 false false true 3 false false
//1 true 2 false false false

public class CountNodesInTree {


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
        new CountNodesInTree().run();
    }

    private Scanner sc = new Scanner(System.in);

    public void run(){

        TreeNode root = new TreeNode(sc.nextInt());
        root = takeInput(root);

        System.out.println(countNodes(root));
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

    public int depth(TreeNode root){
        if( root == null ) return 0;

        int d = 0;

        while( root.left != null ){
            root = root.left;
            d++;
        }

        return d;
    }

    public boolean check(TreeNode nn, int idx, int d){
        if( nn == null ) return false;

        int l = 1;
        int r = (int) Math.pow(2,d);
        int pivot = 0;

        for (int i = 0; i < d; i++) {
            pivot = (l+r) / 2;

            if( idx <= pivot ){
                nn = nn.left;
                r = pivot;
            }

            else {
                nn = nn.right;
                l = pivot + 1;
            }
        }

        return nn != null;
    }


    public int countNodes(TreeNode root) {

        if( root == null ) return 0;

        int d = depth(root);

        if( d == 0 ) return 1;

        int left = 1;
        int right = (int) Math.pow(2, d);
        int n_d = 0;

        while( left <= right ){
            int pivot = (left + right) / 2;

            if( check(root, pivot, d) ){
                left = pivot + 1;
                n_d = pivot;
            }

            else right = pivot - 1;
        }

        return (int) Math.pow(2, d)-1 + n_d;
    }
}
