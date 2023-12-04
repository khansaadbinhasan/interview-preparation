package leetcode.easy;

//["cba","daf","ghi"]
//["a","b"]
//["zyx","wvu","tsr"]
//["a"]
//["rrjk","furt","guzm"]
public class L1379FindCorresponding {

     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {

        if( cloned == null ) return null;
        if( cloned.val == target.val ) return cloned;

        TreeNode leftNode = getTargetCopy(original, cloned.left, target);
        TreeNode rightNode = getTargetCopy(original, cloned.right, target);

        if( leftNode != null ) return leftNode;
        if( rightNode != null ) return rightNode;

        return null;

    }

}
