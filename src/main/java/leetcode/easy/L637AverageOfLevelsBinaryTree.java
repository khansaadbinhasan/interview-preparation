package leetcode.easy;

import java.util.*;

//[3,9,20,null,null,15,7]
//[3,9,20,15,7]
//[1]
//[-1]
public class L637AverageOfLevelsBinaryTree {

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

    public List<Double> averageOfLevels(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();


        q.offer(root);
        q.offer(null);

        List<Double> lstAvg = new LinkedList<>();

        double sum = 0;

        lstAvg.add((double) root.val);

        int count = 0;

        while( !q.isEmpty() ){

            TreeNode node = q.poll();

            // System.out.println((node == null) + " " + q.isEmpty());

            if( node == null ) {

                if( q.isEmpty() ) break;

                lstAvg.add(sum / count);
                sum = 0;
                count = 0;
                q.offer(null);

                continue;
            }

            if(node.left != null) {
                q.offer(node.left);
                sum += node.left.val;
                count++;
            }

            if(node.right != null) {
                q.offer(node.right);
                sum += node.right.val;
                count++;
            }
        }

        return lstAvg;
    }

}
