package trees;

import sun.reflect.generics.tree.Tree;

import java.util.Scanner;

public class LowestCommonAncestor {

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

    private Scanner sc =  new Scanner(System.in);

    public static void main(String[] args) {
        new LowestCommonAncestor().run();
    }

    public void run(){

        TreeNode root = new TreeNode(sc.nextInt());
        root = takeInput(root);

        TreeNode p = new TreeNode(sc.nextInt());
        TreeNode q = new TreeNode(sc.nextInt());

        System.out.println(lowestCommonAncestor(root, p, q).val);

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

    public TreeNode lca( TreeNode root, TreeNode p, TreeNode q ){

        if( root == null ) return null;

        if( root.val == p.val || root.val == q.val ) return root;

        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);


        if( left == null && right == null ) return null;
        else if( left != null && right != null ) return root;
        else if( left != null && right == null ) return left;
        else if( left == null && right != null ) return right;

        return null;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if( root == null ) return null;

        if( isRootCorrect(root, p, q) ) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if( left != null ) return left;
        if( right != null ) return right;

        return null;
    }

    public boolean isRootCorrect(TreeNode root, TreeNode p, TreeNode q){

        return  (isContain(root.left, p.val) && isContain(root.right, q.val)) ||
                (isContain(root.right, p.val) && isContain(root.left, q.val)) ||
                ((root.val == p.val) && isContain(root.right, q.val)) ||
                ((root.val == q.val) && isContain(root.right, p.val)) ||
                ((root.val == p.val) && isContain(root.left, q.val)) ||
                ((root.val == q.val) && isContain(root.left, p.val));
    }

    public boolean isContain(TreeNode root, int value){

        if( root == null ) return false;

        return  root.val == value ||
                isContain(root.left, value) ||
                isContain(root.right, value);
    }

}
