package codingBlocks.trees;

import java.util.*;

public class BSTtoDLL {
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
        new BSTtoDLL().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        String inpStr = sc.nextLine().trim();
        String[] inpArr = inpStr.substring(1, inpStr.length()-1).split(",");

        int[] nums = new int[inpArr.length];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(inpArr[i]);
        }

        TreeNode root = formBST(nums);
        printLinkedList(formDLLfromBST(root));
    }

    private void printLinkedList(TreeNode head) {

        System.out.print("[");

        TreeNode node = head;

        while( node.right != head ){
            System.out.print(node.val + ", ");
            node = node.right;
        }

        System.out.println(node.val + "]");
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

    public TreeNode formDLLfromBST(TreeNode root){
        List<TreeNode> lst = new LinkedList<>();

        inorder(root, lst);

        for (int i = 0; i < lst.size()-1; i++) {
            lst.get(i).right = lst.get(i+1);
            lst.get(i+1).left = lst.get(i);
        }

        lst.get(lst.size()-1).right = lst.get(0);

        return lst.get(0);
    }

    public void inorder( TreeNode root, List<TreeNode> treeLst ){
        if( root == null ) return;

        inorder( root.left, treeLst );
        treeLst.add( root );
        inorder( root.right, treeLst );
    }
}

