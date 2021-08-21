package trees;

import java.util.*;

public class KthSmallestInBst {

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
        new KthSmallestInBst().run();
    }

    public void run(){

        Scanner sc = new Scanner(System.in);

        String inpStr = sc.nextLine().trim();
        String[] inpArr = inpStr.substring(1, inpStr.length()-1).split(",");

        TreeNode root = levelOrderInsertion(inpArr);


        int k = sc.nextInt();

        System.out.println(kthSmallest(root, k));
    }

    public TreeNode levelOrderInsertion(String[] inpArr) {

        Queue<TreeNode> treeQueue = new LinkedList<>();

        TreeNode root = new TreeNode(Integer.parseInt(inpArr[0]));
        treeQueue.add(root);

        int i = 1;

        while ( !treeQueue.isEmpty() && i < inpArr.length ) {
            TreeNode polledNode = treeQueue.poll();

            if( polledNode != null ) {
                String leftVal = inpArr[i];

                if( !leftVal.equals("null") ) {
                    polledNode.left = new TreeNode(Integer.parseInt(leftVal));
                    treeQueue.add(polledNode.left);
                }
                else polledNode.left = null;

                i++;

                if( i < inpArr.length ){
                    String rightVal = inpArr[i];
                    if( !rightVal.equals("null") ){
                        polledNode.right = new TreeNode(Integer.parseInt(rightVal));
                        treeQueue.add(polledNode.right);
                    }
                    else polledNode.right = null;

                    i++;
                }
            }
        }

        return root;
    }

    public int kthSmallest(TreeNode root, int k) {

        List<Integer> treeLst = new LinkedList<>();

        inorder( root, treeLst );

        return treeLst.get(k-1);

    }

    public void inorder( TreeNode root, List<Integer> treeLst ){
        if( root == null ) return;

        inorder( root.left, treeLst );
        treeLst.add( root.val );
        inorder( root.right, treeLst );
    }
}
