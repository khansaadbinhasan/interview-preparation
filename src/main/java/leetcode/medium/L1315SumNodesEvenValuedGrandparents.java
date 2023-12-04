package leetcode.medium;

//[6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
//[1]
public class L1315SumNodesEvenValuedGrandparents {

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

    public int sumEvenGrandparent(TreeNode root) {
        return sumEvenGrandparent(root, 0);
    }

    public int sumEvenGrandparent(TreeNode root, int sum) {
        if( root == null ) return sum;

        if( root.val % 2 == 0 && isGrandParent(root) ){
            if( root.left != null ){
                if( root.left.left != null ) sum += root.left.left.val;
                if( root.left.right != null ) sum += root.left.right.val;
            }

            if( root.right != null ){
                if( root.right.left != null ) sum += root.right.left.val;
                if( root.right.right != null ) sum += root.right.right.val;
            }
        }

        sum = sumEvenGrandparent(root.left, sum);
        return sumEvenGrandparent(root.right, sum);
    }

    public boolean isGrandParent(TreeNode root){
        return (root.left != null && (root.left.left != null || root.left.right != null)) || (root.right != null && (root.right.left != null || root.right.right != null));
    }
}
