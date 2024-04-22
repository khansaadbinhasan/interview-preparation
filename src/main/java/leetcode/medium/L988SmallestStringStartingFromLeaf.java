package leetcode.medium;

import java.util.PriorityQueue;

//[0,1,2,3,4,3,4]
//[25,1,3,1,3,0,2]
//[2,2,1,null,1,0,null,0]
//[1,1,1]
//[1]
//[1,2,3,4,5,6,7,8,9,10,25]
//[1,2,3,null,4,5,6,null,7,8,null,9,10,25,8,4,3,2,10,15]
//[1,null,2,3,null,4,5,null,6,null,7,8,null,9,null,10,25,8,null,null,4,3,2,10,15]
public class L988SmallestStringStartingFromLeaf {

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

    public static void main(String[] args) {
        new L988SmallestStringStartingFromLeaf().run();
    }

    public void run(){
        TreeNode root = new TreeNode(25);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(0);
        root.left.left.left = new TreeNode(1);
        root.left.left.left.left = new TreeNode(0);
        System.out.println(smallestFromLeaf(root));
    }

    public String smallestFromLeaf(TreeNode root) {
        if( root.left == null && root.right == null ) return String.valueOf((char) (root.val + 'a'));
        if( root.left == null ) return smallestFromLeaf(root.right) + (char) (root.val + 'a');
        if( root.right == null ) return smallestFromLeaf(root.left) + (char) (root.val + 'a');

        String leftStr = smallestFromLeaf(root.left) + (char) (root.val + 'a');
        String rightStr = smallestFromLeaf(root.right) + (char) (root.val + 'a');

        int compare = leftStr.compareTo(rightStr);

        if( compare < 0 ) return leftStr;

        return rightStr;
    }


    PriorityQueue<String> stringHeap = new PriorityQueue<>();

    public void smallestFromLeaf(TreeNode root, TreeNode root2) {
        if( root != root2 ) return;

//        stringHeap.add(leftStr);
//        stringHeap.add(rightStr);
    }

    PriorityQueue<String> pq = new PriorityQueue<>();

    public String smallestFromLeaf3(TreeNode root) {
        smallestFromLeaf(root, new StringBuilder(""));
        return pq.poll();
    }

    public void smallestFromLeaf(TreeNode root, StringBuilder s) {
        if( root == null ) return;
        if( root.left == null && root.right == null ) {
            pq.add(
                    (s.append((char) (root.val + 'a'))).reverse().toString()
            );
            return;
        }

        StringBuilder s1 = new StringBuilder(s);
        StringBuilder s2 = new StringBuilder(s);

        if( root.left != null ) smallestFromLeaf(root.left, s1.append((char) (root.val + 'a')));
        if( root.right != null ) smallestFromLeaf(root.right, s2.append((char) (root.val + 'a')));

        return;
    }


}
