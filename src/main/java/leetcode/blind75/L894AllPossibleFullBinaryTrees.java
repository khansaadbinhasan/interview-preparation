package leetcode.blind75;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//7
//3
//1
//2
//4
//20
//11
//9
public class L894AllPossibleFullBinaryTrees {

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

    //7
    //1
    //3
    //7,5,[[0,0,0]]
    public List<TreeNode> allPossibleFBT(int n) {
        if( n % 2 == 0 || n < 0 ) return new LinkedList<>();
        if( n == 1 ) return Arrays.asList(new TreeNode(0));

        //n-2 → 3
        List<TreeNode> rootNodes = new LinkedList<>();//[]

        for( int numNodes = 1; numNodes < n; numNodes++ ){
            int l = n-1-numNodes;
            int r = numNodes;

            TreeNode root = new TreeNode(0);
            List<TreeNode> leftNodes = allPossibleFBT(l);
            List<TreeNode> rightNodes = allPossibleFBT(r);

            for( int i = 0; i < leftNodes.size(); i++ ){
                for( int j = 0; j < rightNodes.size(); j++ ){
                    root.left = leftNodes.get(i);
                    root.right = rightNodes.get(j);

                    rootNodes.add(root);
                    root = new TreeNode(0);
                }
            }
        }

        return rootNodes;
    }
}
