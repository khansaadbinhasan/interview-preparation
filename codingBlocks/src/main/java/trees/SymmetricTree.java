package trees;

import java.util.*;

public class SymmetricTree {

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
        new SymmetricTree().run();
    }

    public void run(){

        Scanner sc = new Scanner(System.in);

        String[] nodes = sc.nextLine().trim().split(" ");

        TreeNode root = levelOrderInsertion(null, new TreeNode(Integer.parseInt(nodes[0])));
        for (int i = 1; i < nodes.length; i++) {
            root = levelOrderInsertion(root, new TreeNode(Integer.parseInt(nodes[i])));
        }

        System.out.println(isMirror(root.left, root.right) ? "YES" : "NO");
    }


    public boolean isMirror( TreeNode lst, TreeNode rst ){
        if( lst == null || rst == null ) return lst == rst;

        return lst.val == rst.val && isMirror(lst.left, rst.right) && isMirror(lst.right, rst.left);
    }


    public TreeNode levelOrderInsertion(TreeNode root, TreeNode node) {

        if( root == null ) return node;
        if( node.val == -1 ) return root;

        Queue<TreeNode> treeQueue = new LinkedList<>();

        treeQueue.add(root);

        while (!treeQueue.isEmpty()) {
            TreeNode polledNode = treeQueue.poll();

            if( polledNode == null ) continue;

            if( polledNode.left == null ){
                polledNode.left = node;
                return root;
            }

            else if( polledNode.right == null ){
                polledNode.right = node;
                return root;
            }

            else {
                treeQueue.add(polledNode.left);
                treeQueue.add(polledNode.right);
            }

            treeQueue.add(node.left);
            treeQueue.add(node.right);
        }

        return root;
    }

    public boolean isSymmetric(TreeNode root) {

        if( root.left == null && root.right == null ) return true;

        List<TreeNode> lst1 = new ArrayList<>();
        List<TreeNode> lst2 = new ArrayList<>();

        inOrder(root.left, lst1);
        inOrder(root.right, lst2);

        return lst1.equals(lst2);
    }

    public void inOrder(TreeNode root, List<TreeNode> lst){
        if( root == null ) return;

        inOrder(root.left, lst);
        lst.add(root);
        inOrder(root.right, lst);
    }

}
