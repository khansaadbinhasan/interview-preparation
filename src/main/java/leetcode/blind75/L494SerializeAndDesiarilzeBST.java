package leetcode.blind75;

import java.util.Arrays;

//[2,1,3]
//[]
//[1,2,3,4,5,6,7,8,9]
//[9,8,7,6,5,4,3,2,1]
//[1]
//[1,2]
//[1,2,3,4]
//[5,6,4,3,7,8]
//[4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2]
public class L494SerializeAndDesiarilzeBST {



    /**
     * Definition for a binary tree node.
     */
     public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
     }

//    public class Codec {
//
//
//        // Encodes a tree to a single string.
//        public String serialize(TreeNode root) {
//            return preorder(root) + "" + inorder(root);
//        }
//
//
//        private String preorder(TreeNode root){
//            if( root == null ) return "";
//            return root.val + "" + serialize(root.left) + "" + serialize(root.right);
//        }
//
//        private String inorder(TreeNode root){
//            if( root == null ) return "";
//            return serialize(root.left) + "" + root.val + "" + serialize(root.right);
//        }
//
//        // Decodes your encoded data to tree.
//        public TreeNode deserialize(String data) {
//            String[] s = data.split("");
//            String[] preorder = s[0].split("");
//            String[] inorder = s[1].split("");
//            TreeNode[] preorderNodes = new TreeNode[preorder.length];
//            TreeNode[] inorderNodes = new TreeNode[inorder.length];
//
//            for( int i = 0; i < preorder.length; i++ ){
//                preorderNodes[i] = new TreeNode(Integer.valueOf(preorder[i]));
//                inorderNodes[i] = new TreeNode(Integer.valueOf(inorder[i]));
//            }
//
//            return formTree(preorder, inorder);
//        }
//
//        //inorder → [0,[1],2],3,[7,5,[4],6]
//        //preorder → 3,1,0,2,[4,5,7,6]
//
//        //inorder → Find the left and right subtrees
//        //preorder  → find root in tree
//
//        //root = inorder[0];
//        //to get subarray you need to go in preorder array, find the root and the left of those will be left sub arr and right is right
//        //root.left = formTree(inorder, preorder);//subarr
//        //root.right = formTree(inorder, preorder);//subarr
//        public TreeNode formTree(TreeNode[] preorder, TreeNode[] inorder){
//            int startIndex = 0;
//            int endIndex = 0;
//
//            TreeNode root = preorder[0];
//
//            TreeNode[] preorderSubList;
//            TreeNode[] inorderSubList;
//
//
//            for( int i = 0; i < inorder.length; i++ ){
//                if( inorder.get(i).val == root.val ) {
//                    endIndex = i;
//                    startIndex = i+1;
//                }
//            }
//
//            root.left = formTree(Arrays.copyOfRange(preorder, 1, endIndex+1), Arrays.copyOfRange(inorder, 0, endIndex));
//            root.right = formTree(Arrays.copyOfRange(preorder, endIndex+1), Arrays.copyOfRange(inorder, startIndex));
//
//            return root;
//        }
//    }
//
//
//// Your Codec object will be instantiated and called as such:
//// Codec ser = new Codec();
//// Codec deser = new Codec();
//// String tree = ser.serialize(root);
//// TreeNode ans = deser.deserialize(tree);
//// return ans;
//

    public static void main(String[] args) {
        new L494SerializeAndDesiarilzeBST().run();
    }

    public void run(){
         Codec ser = new Codec();
         Codec deser = new Codec();
//         String tree = ser.serialize(root);
        String tree = "4,-7,-3,-9,9,6,0,-1,6,-4,-7,-6,5,-6,9,-2,-3,-4" + "r" + "-7,4,0,-1,6,-4,6,9,-9,5,-6,-7,-2,9,-6,-3,-4,-3";
         TreeNode ans = deser.deserialize(tree);
//         return ans;
    }

    public class Codec {
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

            TreeNode[] preorderSubList;
            TreeNode[] inorderSubList;


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
    }

}
