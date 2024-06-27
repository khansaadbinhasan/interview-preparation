package CTCI.ch4treesAndGraphs;

import java.util.*;

public class Q3ListOfDepths {

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


    void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level){

        if( root == null ) return;

        LinkedList<TreeNode> list = null;

        if( lists.size() == level ){
            list = new LinkedList<TreeNode>();
            lists.add(list);
        }

        else list = lists.get(level);

        list.add(root);

        createLevelLinkedList(root.left, lists, level+1);
        createLevelLinkedList(root.right, lists, level+1);
    }

    ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root){
        ArrayList<LinkedList<TreeNode>> lists =  new ArrayList<>();

        createLevelLinkedList(root, lists, 0);

        return lists;
    }


}
