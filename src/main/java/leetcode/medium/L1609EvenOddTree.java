package leetcode.medium;

import java.util.*;

//[1,10,4,3,null,7,9,12,8,6,null,null,2]
//[5,4,2,3,3,7]
//[5,9,1,3,5,7]
//[1]
//[2]
//[1,2,3]
//[1,2,4]
//[11,8,6,1,3,9,11,30,20,18,16,12,10,4,2,17]
//[11,18,14,3,7,null,null,null,null,18,null,6]
//[11,12,8,3,7,11,null,null,null,20]
public class L1609EvenOddTree {

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

    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> nodeQ = new LinkedList<>();
        nodeQ.add(root);
        int level = 0;
        nodeQ.add(null);
        int lastVal = -3;

        while( !nodeQ.isEmpty() ){
            TreeNode node = nodeQ.poll();

            if( node == null ) {
                if( nodeQ.isEmpty() ) break;
                level++;
                nodeQ.add(node);

                if( level % 2 == 0 )  lastVal = -1;
                else lastVal = 1000_002;
                continue;
            }

            // System.out.println(level + " " + node.val + " " + lastVal);

            if( level % 2 == 0 ){
                if( node.val % 2 == 0 ) return false;
                if( lastVal >= node.val ) return false;
            }

            else{
                if( node.val % 2 != 0 ) return false;
                if( lastVal <= node.val ) return false;
            }

            if( node.left != null ) nodeQ.add(node.left);
            if( node.right != null ) nodeQ.add(node.right);
            lastVal = node.val;
        }

        return true;
    }
}
