package leetcode.easy;

import java.util.*;

//[1,null,2,3]
//[]
//[1]
//[1,2]
//[1,null,2]
public class L145PostOrderTraversal {

    class TreeNode{
        public int val;

        public TreeNode left;
        public TreeNode right;
        public TreeNode parent;
    }


    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ansList = new LinkedList<>();

        postorder(root, ansList);

        return ansList;
    }

    public void postorder(TreeNode root, List<Integer> ansList){
        if( root == null ) return;

        postorder(root.left, ansList);
        postorder(root.right, ansList);
        ansList.add(root.val);
    }


}
