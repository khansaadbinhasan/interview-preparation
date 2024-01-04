package leetcode.easy;

import java.util.*;

public class L101SymmetricTree {

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

    public boolean isSymmetric(TreeNode root) {

        if( root.left == null && root.right == null ) return true;

        List<Integer> lst1 = new LinkedList<>();
        List<Integer> lst2 = new LinkedList<>();

        inOrder(root.left, lst1);
        inOrder(root.right, lst2);

        Collections.reverse(lst2);

        return lst1.equals(lst2);
    }

    public void inOrder(TreeNode root, List<Integer> lst){
        if( root == null ){
            lst.add(-1);
            return;
        }

        inOrder(root.left, lst);
        if( lst.contains(root.val) ) lst.add(root.val+1);
        else lst.add(root.val);
        inOrder(root.right, lst);
    }

    public static void main(String[] args) {
        new L101SymmetricTree().run();
    }

    public void run(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        System.out.println(levelOrderTraversal(root));
    }

    public boolean isSymmetric2(TreeNode root) {
        List<List<Integer>> lst = levelOrderTraversal(root);

        System.out.println(lst);

        lst.remove(0);

        for( int i = 0; i < lst.size(); i++ ){
            if( lst.get(i).size() % 2 != 0 ) return false;
            if( !palindrome(lst.get(i)) ) return false;
        }

        return true;
    }

    public boolean palindrome(List<Integer> lst){
        int p1 = 0;
        int p2 = lst.size()-1;

        while( p1 < p2 ){
            if( lst.get(p1) != lst.get(p2) ) return false;
            p1++;
            p2--;
        }

        return true;
    }

    public List<List<Integer>> levelOrderTraversal(TreeNode root){
        List<List<Integer>> levelOrderList = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        q.add(new TreeNode(Integer.MIN_VALUE));

        List<Integer> currLevel = new LinkedList<>();

        while( !q.isEmpty() ){
            TreeNode node = q.poll();
            while( node == null ) {
                currLevel.add(null);
                node = q.poll();
            }

            if( node.val == Integer.MIN_VALUE ) {
                levelOrderList.add(currLevel);
                currLevel = new LinkedList<>();
                if( q.isEmpty() ) break;
                q.add(node);
                continue;
            }

            currLevel.add(node.val);
            q.add(node.left);
            q.add(node.right);
        }

        return levelOrderList;
    }

    public boolean isSymmetric3(TreeNode root) {
        if( root == null ) return true;

        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right){
        if( left == null && right == null ) return true;
        if( left == null && right != null ) return false;
        if( left != null && right == null ) return false;
        if( left.val != right.val ) return false;

        return isSymmetric(left.right, right.left) && isSymmetric(left.left, right.right);
    }
}
