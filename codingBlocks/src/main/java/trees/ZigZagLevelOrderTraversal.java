package trees;

import java.util.*;

public class ZigZagLevelOrderTraversal {

    private class TreeNode {
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

    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new ZigZagLevelOrderTraversal().run();
    }

    public void run(){

        TreeNode root = new TreeNode(sc.nextInt());
        root = takeInput(root);

        List<List<Integer>> lstlst = zigzagLevelOrder(root);

        for( List<Integer> lst: lstlst ){
            for( Integer val: lst ){
                System.out.print(val + " ");
            }
        }

    }

    public TreeNode takeInput(TreeNode root){

        String str = sc.next();

        if( str.equals("true") ){
            root.left = new TreeNode(sc.nextInt());
            takeInput(root.left);
        }
        else if( str.equals("false") ) root.left = null;
        else return null;

        str = sc.next();

        if( str.equals("true") ){
            root.right = new TreeNode(sc.nextInt());
            takeInput(root.right);
        }
        else if( str.equals("false") ) root.right = null;
        else return null;

        return root;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<Integer> levelOrderList = levelOrderTraversal(root);
        List<List<Integer>> finalList = new LinkedList<>();

        boolean isRight = true;
        List<Integer> tempList = new LinkedList<>();

        for( int i = 0; i < levelOrderList.size(); i++ ){
            Integer val = levelOrderList.get(i);

            if( val != null ) tempList.add(val);

            if( val == null || i == levelOrderList.size() - 1 ) {
                if( !isRight ) Collections.reverse(tempList);

                finalList.add(tempList);

                tempList = new LinkedList<>();
                isRight = !isRight;
            }
        }

        return finalList;
    }

    public List<Integer> levelOrderTraversal(TreeNode root){

        List<Integer> levelOrder = new LinkedList<>();

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        q.offer(null);

        while( !q.isEmpty() ){
            TreeNode node = q.poll();

            if( node != null ){
                levelOrder.add(node.val);
                if( node.left != null ) q.offer(node.left);
                if( node.right != null ) q.offer(node.right);
            }

            else if( !q.isEmpty() ){
                levelOrder.add(null);
                q.offer(null);
            }

        }

        return levelOrder;
    }
}
