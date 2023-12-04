package leetcode.medium;

import java.util.*;

//[3,9,20,null,null,15,7]
//[1]
//[]
//[1,2,3,4]
//[1,2,3,4,5,null,7,null,8,9,null,0]
//[1,2,3]
public class L102BinaryTreeLevelOrderTraversal {
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


    public List<List<Integer>> levelOrder(TreeNode root) {

        if( root == null ) return new LinkedList<>();

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        q.offer(null);

        List<List<Integer>> ansLst = new LinkedList<>();

        while( !q.isEmpty() ){

            TreeNode node = q.poll();

            List<Integer> lst = new LinkedList<>();

            while( node != null && !q.isEmpty() ){
                lst.add(node.val);

                if( node.left != null ) q.offer(node.left);
                if( node.right != null ) q.offer(node.right);

                node = q.poll();
            }

            ansLst.add(lst);

            if( !q.isEmpty() ) q.offer(null);

        }

        return ansLst;
    }

}
