package codingBlocks.trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


//1 2 3 4 5 6 7 -1 -1 -1 -1

public class LargestValueEachRow {

    private class TreeNode {
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

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }


    public static void main(String[] args) {
        new LargestValueEachRow().run();
    }

    private void run() {

        Scanner sc = new Scanner(System.in);

        String[] inpArr = sc.nextLine().trim().split(" ");

        TreeNode root = levelOrderInsertion(null, new TreeNode(Integer.parseInt(inpArr[0])));


        for (int i = 1; i < inpArr.length; i++) {
            int val = Integer.parseInt(inpArr[i]);

            if( val != -1 ) root = levelOrderInsertion(root, new TreeNode(val));
        }

        List<Integer> ansLst = largestValues(root);

        for( int num: ansLst){
            System.out.print(num + " ");
        }

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


    public List<Integer> largestValues(TreeNode root) {

        if( root == null ) return new LinkedList<>();

        List<Integer> largestValuesList = new LinkedList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.add(null);

        int max = Integer.MIN_VALUE;

        while( !q.isEmpty() ){

            TreeNode node = q.poll();

            if( node != null ){
                if( node.left != null ) q.offer(node.left);
                if( node.right != null ) q.offer(node.right);

                max = Math.max(max, node.val);
            }

            else if( !q.isEmpty() ){
                q.offer(null);
                largestValuesList.add(max);
                max = Integer.MIN_VALUE;
            }

        }

        largestValuesList.add(max);

        return largestValuesList;
    }

    public void levelOrderPrinting(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node == null) continue;

            System.out.print(node.val + " ");

            q.add(node.left);
            q.add(node.right);
        }
    }

}
