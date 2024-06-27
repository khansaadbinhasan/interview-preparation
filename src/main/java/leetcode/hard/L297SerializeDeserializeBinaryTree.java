package leetcode.hard;

import java.util.*;

public class L297SerializeDeserializeBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public class Codec2 {


        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            return preorder(root) + "r" + inorder(root);
        }


        private String preorder(TreeNode root){
            if( root == null ) return "";

            String preorder = "" + root.val;

            String s = preorder(root.left);
            if( !s.isEmpty() ) preorder += "," + s;
            s = preorder(root.right);
            if( !s.isEmpty() ) preorder += "," + s;

            return preorder;
        }

        private String inorder(TreeNode root){
            if( root == null ) return "";

            String inorder = "";
            String s = inorder(root.left);
            if(!s.isEmpty()) inorder += s + ",";
            inorder += root.val;
            s = inorder(root.right);
            if(!s.isEmpty()) inorder += "," +s;

            return inorder;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if( data.length() == 1 ) return null;
            System.out.println(data);
            String[] s = data.split("r");
            String[] preorder = s[0].split(",");
            String[] inorder = s[1].split(",");
            TreeNode[] preorderNodes = new TreeNode[preorder.length];
            TreeNode[] inorderNodes = new TreeNode[inorder.length];

            for( int i = 0; i < preorder.length; i++ ){
                preorderNodes[i] = new TreeNode(Integer.valueOf(preorder[i]));
                inorderNodes[i] = new TreeNode(Integer.valueOf(inorder[i]));
            }

            return formTree(preorderNodes, inorderNodes);
        }

        //inorder → [0,[1],2],3,[7,5,[4],6]
        //preorder → 3,1,0,2,[4,5,7,6]

        //inorder → Find the left and right subtrees
        //preorder  → find root in tree

        //root = inorder[0];
        //to get subarray you need to go in preorder array, find the root and the left of those will be left sub arr and right is right
        //root.left = formTree(inorder, preorder);//subarr
        //root.right = formTree(inorder, preorder);//subarr
        public TreeNode formTree(TreeNode[] preorder, TreeNode[] inorder){
            if( preorder.length == 0 || inorder.length == 0 ) return null;

            int startIndex = 0;
            int endIndex = 0;

            TreeNode root = preorder[0];

            for( int i = 0; i < inorder.length; i++ ){
                if( inorder[i].val == root.val ) {
                    endIndex = i;
                    startIndex = i+1;
                    break;
                }
            }

            root.left = formTree(Arrays.copyOfRange(preorder, 1, endIndex+1), Arrays.copyOfRange(inorder, 0, endIndex));
            root.right = formTree(Arrays.copyOfRange(preorder, endIndex+1, preorder.length), Arrays.copyOfRange(inorder, startIndex, inorder.length));

            return root;
        }

        // public TreeNode buildTree(int[] preorder, int[] inorder) {
        //     if( preorder.length == 0 || inorder.length == 0 ) return null;

        //     TreeNode root = new TreeNode(preorder[0]);

        //     int ind = getIndex(inorder, root.val);

        //     root.left = buildTree(Arrays.copyOfRange(preorder, 1, ind+1), Arrays.copyOfRange(inorder, 0, ind));
        //     root.right = buildTree(Arrays.copyOfRange(preorder, ind+1, preorder.length), Arrays.copyOfRange(inorder, 1+ind, inorder.length));

        //     return root;
        // }

        // private int getIndex(int[] inorder, int val){
        //     for( int i = 0; i < inorder.length; i++ ){
        //         if( inorder[i] == val ) {
        //             return i;
        //         }
        //     }

        //     return -1;
        // }
    }
    // Your Codec object will be instantiated and called as such:
    // Codec ser = new Codec();
    // Codec deser = new Codec();
    // String tree = ser.serialize(root);
    // TreeNode ans = deser.deserialize(tree);
    // return ans;


    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if( root == null ) return "" + Integer.MIN_VALUE;

            String s = "";

            s += root.val;
            if( root.left == null ) s += "," + Integer.MIN_VALUE;
            else s += "," + serialize(root.left);
            if( root.right == null ) s += "," + Integer.MIN_VALUE;
            else s += "," + serialize(root.right);

            return s;
        }

        int ind = 0;

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            System.out.println(data);
            String[] preorderStr = data.split(",");
            int[] preorder = new int[preorderStr.length];

            for( int i = 0; i < preorderStr.length; i++ ){
                preorder[i] = Integer.valueOf(preorderStr[i]);
            }

            return formTree(preorder);
        }

        public TreeNode formTree(int[] preorder){
            if( ind >= preorder.length ) return null;
            if( preorder[ind] == Integer.MIN_VALUE ) {
                ind++;
                return null;
            }

            TreeNode root = new TreeNode(preorder[ind]);
            ind++;
            root.left = formTree(preorder);
            root.right = formTree(preorder);

            return root;
        }
    }
    // Your Codec object will be instantiated and called as such:
    // Codec ser = new Codec();
    // Codec deser = new Codec();
    // TreeNode ans = deser.deserialize(ser.serialize(root));
}
