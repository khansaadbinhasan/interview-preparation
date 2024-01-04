package CTCI.ch4treesAndGraphs;

public class Q2MinimalTree {

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

    public TreeNode sortedArrayToBST(int[] nums) {
        return insertNode( nums, 0, nums.length-1 );
    }

    public TreeNode insertNode( int[] nums, int start, int end ){
        if( end < start ) return null;

        int mid = (start + end) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = insertNode( nums, start, mid-1 );
        root.right = insertNode( nums, mid+1, end );

        return root;
    }


}
