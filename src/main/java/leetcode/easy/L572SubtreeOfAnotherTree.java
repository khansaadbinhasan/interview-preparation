package leetcode.easy;

//[3,4,5,1,2]
//[4,1,2]
//[3,4,5,1,2,null,null,null,null,0]
//[4,1,2]
//[1]
//[1]
//[1]
//[2]
//[1,2,3,null,4,5,6,null,null,7,8]
//[1,2,3]
//[1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,2]
//[1,null,1,null,1,null,1,null,1,null,1,2]
public class L572SubtreeOfAnotherTree {

    class TreeNode{
        public int val;

        public TreeNode left;
        public TreeNode right;
        public TreeNode parent;
    }


    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if( subRoot == null ) return true;
        if( root == null ) return false;

        if( isSubtree2(root, subRoot) ) return true;

        return  isSubtree(root.left, subRoot) ||
                isSubtree(root.right, subRoot);
    }

    public boolean isSubtree2(TreeNode root, TreeNode subRoot) {

        if( subRoot == null ) return true;
        if( root == null ) return false;

        if(
                (
                        (root.left == null || subRoot.left == null) &&
                                root.left != subRoot.left
                ) ||
                        (
                                (root.right == null || subRoot.right == null) &&
                                        root.right != subRoot.right
                        )
        )
            return false;

        return  (root.val == subRoot.val) &&
                (root.left == subRoot.left || root.left.val == subRoot.left.val) &&
                (root.right == subRoot.right || root.right.val == subRoot.right.val) &&
                isSubtree2(root.left, subRoot.left) &&
                isSubtree2(root.right, subRoot.right);
    }


    public boolean isSubtree3(TreeNode root, TreeNode subRoot) {
        if( root == subRoot ) return true;
        if( root == null ) return false;
        if( subRoot == null ) return false;

        return isEqual(root, subRoot) || isSubtree3(root.left, subRoot) || isSubtree3(root.right, subRoot);
    }

    public boolean isEqual(TreeNode root, TreeNode subRoot){
        if( root == subRoot ) return true;
        if( root == null ) return false;
        if( subRoot == null ) return false;

        return ( root.val == subRoot.val ) && isEqual(root.left, subRoot.left) && isEqual(root.right, subRoot.right);
    }

    public boolean isSubtree5(TreeNode root, TreeNode subRoot) {
        StringBuilder sb1 = constructPreorder(root, new StringBuilder());
        StringBuilder sb2 = constructPreorder(subRoot, new StringBuilder());

        System.out.println(sb1);
        System.out.println(sb2);

        return sb1.indexOf(sb2.toString()) == -1? false: true;
    }

    public StringBuilder constructPreorder(TreeNode root, StringBuilder s){
        if( root == null ) return s.append("N");

        s.append("s").append(root.val).append(",");
        constructPreorder(root.left, s);
        constructPreorder(root.right, s);

        return s;
    }

}
