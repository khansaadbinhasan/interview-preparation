package leetcode.easy;

//[1,0,1,0,1,0,1]
//[0]
//[1]
//[0,1,1,1,1,1,1]
//[1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,1,1,1,0,0,0,1,1,1,0,0,0,0,1,1,1,0,0,1]
//[1,0,1,0,1]
//[1,0,null,1,0,null,1]
public class L1022SumOfRootToLeafBinaryNumbers {

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

    public int sumRootToLeaf(TreeNode root) {

        return Integer.parseInt(sumRootToLeaf(root, null));

    }

    public String sumRootToLeaf(TreeNode root, TreeNode prev){

        if( root == null ) return String.valueOf(prev.val);

        String left = String.valueOf(root.val) + String.valueOf(sumRootToLeaf(root.left, root));

        String right = String.valueOf(root.val) + String.valueOf(sumRootToLeaf(root.right, root));


        System.out.println(left);
        System.out.println(right);

        return String.valueOf(Integer.parseInt(left, 2) + Integer.parseInt(right, 2));

    }


    int sum = 0;

    public int sumRootToLeaf2(TreeNode root) {
        getNumList(root, "");
        return sum;
    }

    public void getNumList(TreeNode root, String prev){
        if( root == null ) return;

        if( root.left == null && root.right == null ) {
            sum += Integer.parseInt(prev+root.val, 2);
            return;
        }

        prev += root.val;
        getNumList(root.left, prev);
        getNumList(root.right, prev);
    }

}
