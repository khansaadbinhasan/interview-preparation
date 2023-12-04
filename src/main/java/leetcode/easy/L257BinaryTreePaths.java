package leetcode.easy;

import java.util.*;


//[1,2,3,null,5]
//[1]
//[1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9]
public class L257BinaryTreePaths {

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

    List<String> pathList = new LinkedList<>();

    public List<String> binaryTreePaths(TreeNode root) {


        path(root, "");



        return pathList;
    }

    public void path(TreeNode root, String currPath){
        if( root == null ) {
            return;
        }

        if( !currPath.isEmpty() ) currPath += "->";
        currPath += root.val;

        if( root.left == null && root.right == null ){
            pathList.add(currPath);
            return;
        }

        path(root.left, currPath);
        path(root.right, currPath);
    }
}
