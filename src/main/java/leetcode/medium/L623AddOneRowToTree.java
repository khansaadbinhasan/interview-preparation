package leetcode.medium;

import java.util.*;

public class L623AddOneRowToTree {

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

    public TreeNode addOneRow(TreeNode root, int val, int depth) {

        if( root == null ) return null;

        List<List<TreeNode>> levelOrder = levelOrderTraversal(root);
        List<TreeNode> rowList = new LinkedList<>();

        int numNodesToAdd = (int) Math.pow(2, depth);

        for (int i = 0; i < numNodesToAdd; i++) {
            rowList.add(new TreeNode(val));
        }

        levelOrder.add(depth, rowList);

        return levelOrderInsertion(levelOrder);
    }

    public TreeNode levelOrderInsertion(List<List<TreeNode>> levelOrder){

        if( levelOrder.size() == 0 || levelOrder.get(0).size() == 0 ) return null;

        TreeNode root = levelOrder.get(0).get(0);
        TreeNode node = root;

        for (int i = 1; i < levelOrder.size(); i++) {
            int index = 0;
            for (int j = 0; j < levelOrder.get(i-1).size(); j++) {
                if( index < levelOrder.get(i).size() ){

                    node.left = levelOrder.get(i).get(index);
                    index++;

                    if( index < levelOrder.get(i).size() ){
                        node.right = levelOrder.get(i).get(index);
                        index++;
                    }

                }
            }

            node = levelOrder.get(i).get(0);
        }


        return root;
    }

    public List<List<TreeNode>> levelOrderTraversal(TreeNode root){

        List<List<TreeNode>> levelOrder = new LinkedList<>();
        List<TreeNode> tempList = new LinkedList<>();

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        q.offer(null);

        while( !q.isEmpty() ){
            TreeNode node = q.poll();

            if( node != null ){
                tempList.add(node);
                if( node.left != null ) q.offer(node.left);
                if( node.right != null ) q.offer(node.right);
            }

            else if( !q.isEmpty() ){
                levelOrder.add(tempList);
                tempList.clear();
                q.offer(null);
            }

        }

        return levelOrder;
    }

    public TreeNode addOneRow2(TreeNode root, int val, int depth) {

        if( depth == 1 ) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        return addOneRow(root, val, depth, 1);
    }

    public TreeNode addOneRow(TreeNode root, int val, int depth, int currDepth) {
        if( root == null ) return null;
        if( currDepth > depth ) return null;

        if( depth-1 == currDepth ){
            TreeNode left = new TreeNode(val);
            TreeNode right = new TreeNode(val);
            left.left = root.left;
            right.right = root.right;
            root.left = left;
            root.right = right;
        }

        addOneRow(root.left, val, depth, currDepth+1);
        addOneRow(root.right, val, depth, currDepth+1);

        return root;
    }

}
