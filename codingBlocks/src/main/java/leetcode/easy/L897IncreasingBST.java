package leetcode.easy;

import java.util.*;

//[5,3,6,2,4,null,8,1,null,null,null,7,9]
//[5,1,7]
//[1]
//[2,1,4,null,null,3]
public class L897IncreasingBST {

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


    List<TreeNode> lst = new LinkedList<>();

    public TreeNode increasingBST(TreeNode root) {

        if( root == null ) return null;

        inorder(root);


        root = lst.get(0);
        root.left = null;

        TreeNode root2 = root;

        for( int i = 1; i < lst.size(); i++ ){
            root2.left = null;
            root2 = root2.right = lst.get(i);
        }

        root2.left = null;

        return root;

    }

    public TreeNode inorder(TreeNode root){

        if( root == null ) return null;

        inorder(root.left);
        lst.add(root);
        inorder(root.right);

        return root;
    }


}
