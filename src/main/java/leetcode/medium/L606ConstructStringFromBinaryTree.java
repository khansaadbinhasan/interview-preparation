package leetcode.medium;

public class L606ConstructStringFromBinaryTree {

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

    public String tree2str2(TreeNode root) {

        String paraString = "";

        return getParaString(root, "");

    }

    public String getParaString( TreeNode root, String paraString ){
        if( root == null ) return paraString;


        paraString += root.val;
        // if( root.left != null)
        paraString += "(";

        paraString = getParaString( root.left, paraString );

        paraString += ")";
        paraString += "(";
        paraString = getParaString( root.right, paraString );

        // if( root.right != null)
        paraString += ")";

        new StringBuilder();

        return paraString;
    }

    public String tree2str(TreeNode root) {
        StringBuilder ans = new StringBuilder();

        return formString(root, ans).deleteCharAt(0).deleteCharAt(ans.length()-1).toString();
    }

    public StringBuilder formString(TreeNode root, StringBuilder ans){
        if( root == null ) return ans;

        ans.append("(");
        ans.append(root.val);
        if( root.left == null && root.right != null ) ans.append("()");
        formString(root.left, ans);
        formString(root.right, ans);
        ans.append(")");

        return ans;
    }
}
