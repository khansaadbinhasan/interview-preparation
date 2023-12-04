package codingBlocks.trees;

import java.util.*;

//1 2 3 -1 -1 -1 -1

public class RightSideView {

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
        new RightSideView().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        String[] inpStrArr = sc.nextLine().trim().split(" ");

        TreeNode root = levelOrderInsertion(null, new TreeNode(Integer.parseInt(inpStrArr[0])));

        for (int i = 1; i < inpStrArr.length; i++) {
            int val = Integer.parseInt(inpStrArr[i]);
            if( val != - 1) levelOrderInsertion(root, new TreeNode(val));
        }

        rightSideView(root).forEach(val -> System.out.print(val + " "));
    }

    public TreeNode levelOrderInsertion(TreeNode root, TreeNode node) {

        if( root == null ) return node;

        Queue<TreeNode> treeQueue = new LinkedList<>();

        treeQueue.add(root);

        while (!treeQueue.isEmpty()) {
            TreeNode polledNode = treeQueue.poll();

            if( polledNode == null ) continue;

            if( polledNode.left == null ){
                polledNode.left = node;
                return root;
            }

            else if( polledNode.right == null ){
                polledNode.right = node;
                return root;
            }

            else {
                treeQueue.add(polledNode.left);
                treeQueue.add(polledNode.right);
            }

            treeQueue.add(node.left);
            treeQueue.add(node.right);
        }

        return root;
    }


    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSideList = new LinkedList<>();
        List<Integer> levelOrderList = levelOrderTraversal(root);

        Integer nodePrev = Integer.MIN_VALUE;

        for( Integer nodeVal: levelOrderList ){
            if( nodeVal == null && nodePrev != Integer.MIN_VALUE ) rightSideList.add(nodePrev);

            nodePrev = nodeVal;
        }

        return rightSideList;
    }


    public List<Integer> levelOrderTraversal(TreeNode root){

        List<Integer> levelOrderList = new LinkedList<>();

        if( root == null ) return new LinkedList<>();

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        q.offer(null);


        while( !q.isEmpty() ){

            TreeNode node = q.poll();

            if( node != null ){
                if( node.left != null ) q.add(node.left);
                if( node.right != null ) q.add(node.right);

                levelOrderList.add(node.val);
            }

            else if( !q.isEmpty() ){
                q.add(null);
                levelOrderList.add(null);
            }
        }

        levelOrderList.add(null);

        return levelOrderList;
    }
}
