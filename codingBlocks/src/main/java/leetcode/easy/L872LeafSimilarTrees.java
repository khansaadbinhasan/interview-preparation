package leetcode.easy;

import java.util.*;

//[3,5,1,6,2,9,8,null,null,7,4]
//[3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
//[1]
//[1]
//[1]
//[2]
//[1,2]
//[2,2]
//[1,2,3]
//[1,3,2]
public class L872LeafSimilarTrees {

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

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        List<Integer> lst1 = new LinkedList<>();
        List<Integer> lst2 = new LinkedList<>();


        inorder(root1, lst1);
        inorder(root2, lst2);

        return lst1.equals(lst2);
    }

    public List<Integer> inorder(TreeNode root, List<Integer> valueLst){

        if( root == null ) return valueLst;

        if( root.left == null && root.right == null )
            valueLst.add(root.val);

        inorder(root.left, valueLst);
        inorder(root.right, valueLst);

        return valueLst;
    }

}
