package leetcode.easy;

import java.util.*;

public class L144PreorderTraversal {

    class TreeNode{
        public int val;

        public TreeNode left;
        public TreeNode right;
        public TreeNode parent;
    }


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ansList = new LinkedList<>();

        preorder(root, ansList);

        return ansList;
    }

    public void preorder(TreeNode root, List<Integer> ansList){
        if( root == null ) return;

        ansList.add(root.val);
        preorder(root.left, ansList);
        preorder(root.right, ansList);

    }


}
