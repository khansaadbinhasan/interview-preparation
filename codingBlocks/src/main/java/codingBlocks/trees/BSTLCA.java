package codingBlocks.trees;

import java.util.Scanner;

public class BSTLCA {

     public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
     }

    public static void main(String[] args) {
        new BSTLCA().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int[] nums = new int[sc.nextInt()];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }

        TreeNode p = new TreeNode(sc.nextInt());
        TreeNode q = new TreeNode(sc.nextInt());

        System.out.println(lowestCommonAncestor(formBST(nums), p, q).val);
    }

    public TreeNode formBST(int[] nums){

        TreeNode root = new TreeNode(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            insertInBst(root, new TreeNode(nums[i]));
        }

         return root;
    }

    public void insertInBst(TreeNode root, TreeNode node){
        if( node.val < root.val && root.left == null ) root.left = node;
        else if( node.val > root.val && root.right == null ) root.right = node;

        if( node.val < root.val ) insertInBst(root.left, node);
        else if( node.val > root.val ) insertInBst(root.right, node);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if( (p.val <= root.val && q.val >= root.val) ||
                (p.val >= root.val && q.val <= root.val)
        ) return root;

        if( p.val < root.val && q.val < root.val )
        {
            lowestCommonAncestor(root.left, p, q);
            return root.left;
        }

        if( p.val > root.val && q.val > root.val )
        {
            lowestCommonAncestor(root.right, p, q);
            return root.right;
        }

        return null;
    }


}
