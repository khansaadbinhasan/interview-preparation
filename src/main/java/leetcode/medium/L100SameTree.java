package leetcode.medium;

import java.util.*;

public class L100SameTree {

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

    public boolean isSameTree(TreeNode p, TreeNode q) {

        List<TreeNode> lst1 = new ArrayList<>();
        List<TreeNode> lst2 = new ArrayList<>();

        preorder(p, lst1);
        preorder(q, lst2);


        // System.out.println(lst1);
        // System.out.println(lst2);

        return equals(lst1, lst2);

    }

    public boolean equals( List<TreeNode> lst1, List<TreeNode> lst2 ){
        if( lst1.size() != lst2.size() ) return false;

        for( int i = 0; i < lst1.size(); i++ ){

            if( lst1.get(i) == null && lst2.get(i) == null ) continue;
            if( lst1.get(i) == null && lst2.get(i) != null ) return false;
            if( lst1.get(i) != null && lst2.get(i) == null ) return false;

            if( lst1.get(i).val != lst2.get(i).val ) return false;
        }

        return true;
    }

    public void preorder(TreeNode root, List<TreeNode> lst){

        lst.add(root);

        if( root == null ) return;

        preorder( root.left, lst );
        preorder( root.right, lst );
    }

}
