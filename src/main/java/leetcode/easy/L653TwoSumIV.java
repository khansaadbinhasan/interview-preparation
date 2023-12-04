package leetcode.easy;

//[5,3,6,2,4,null,7]
//9
//[5,3,6,2,4,null,7]
//28
//[1]
//1
//[2,1,3]
//4
//[2,1,3]
//3
//[2,1,3]
//5
//[2,1,3]
//9
public class L653TwoSumIV {

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

    public boolean findTarget(TreeNode root, int k) {
        return findTarget(root, root, k);
    }

    public boolean findTarget(TreeNode root, TreeNode node, int k) {
        if( node == null ) return false;

        return  findElem(root, node, k-node.val) ||
                findTarget(root, node.left, k) ||
                findTarget(root, node.right, k);
    }

    public boolean findElem(TreeNode root, TreeNode node, int val){
        if( root == null ) return false;
        if( (root != node) && (root.val == val) ) return true;

        if( val < root.val ) return findElem(root.left, node, val);

        return findElem(root.right, node, val);
    }
}
