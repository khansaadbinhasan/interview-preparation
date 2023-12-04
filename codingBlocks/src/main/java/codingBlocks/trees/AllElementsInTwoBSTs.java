package codingBlocks.trees;

import java.util.*;

public class AllElementsInTwoBSTs {

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
        new AllElementsInTwoBSTs().run();
    }

    public void run(){

        Scanner sc = new Scanner(System.in);

        String[] inpArr1 = sc.nextLine().trim().split(" ");
        String[] inpArr2 = sc.nextLine().trim().split(" ");

        TreeNode root1 = levelOrderInsertion(inpArr1);
        TreeNode root2 = levelOrderInsertion(inpArr2);

        System.out.println(getAllElements(root1, root2));
    }

    public TreeNode levelOrderInsertion(String[] inpArr) {

        Queue<TreeNode> treeQueue = new LinkedList<>();

        TreeNode root = new TreeNode(Integer.parseInt(inpArr[0]));
        treeQueue.add(root);

        int i = 1;

        while ( !treeQueue.isEmpty() && i < inpArr.length ) {
            TreeNode polledNode = treeQueue.poll();

            if( polledNode != null ) {
                String leftVal = inpArr[i];

                if( !leftVal.equals("N") ) {
                    polledNode.left = new TreeNode(Integer.parseInt(leftVal));
                    treeQueue.add(polledNode.left);
                }
                else polledNode.left = null;

                i++;

                if( i < inpArr.length ){
                    String rightVal = inpArr[i];
                    if( !rightVal.equals("N") ){
                        polledNode.right = new TreeNode(Integer.parseInt(rightVal));
                        treeQueue.add(polledNode.right);
                    }
                    else polledNode.right = null;

                    i++;
                }
            }
        }

        return root;
    }


    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        List<Integer> treeLst1 = new ArrayList<>();
        List<Integer> treeLst2 = new ArrayList<>();
        List<Integer> sortedList = new LinkedList<>();

        inorder( root1, treeLst1 );
        inorder( root2, treeLst2 );

        System.out.println(treeLst1);
        System.out.println(treeLst2);

        int pointer1 = 0;
        int pointer2 = 0;

        while( pointer1 < treeLst1.size() && pointer2 < treeLst2.size() ){
            if( treeLst1.get(pointer1) < treeLst2.get(pointer2) ){
                sortedList.add(treeLst1.get(pointer1));
                pointer1++;
            }

            else{
                sortedList.add(treeLst2.get(pointer2));
                pointer2++;
            }
        }

        while( pointer1 < treeLst1.size() ){
            sortedList.add(treeLst1.get(pointer1));
            pointer1++;
        }

        while( pointer2 < treeLst2.size() ){
            sortedList.add(treeLst2.get(pointer2));
            pointer2++;
        }

        return sortedList;
    }

    public void inorder( TreeNode root, List<Integer> treeLst ){
        if( root == null ) return;

        inorder( root.left, treeLst );
        treeLst.add(root.val);
        inorder( root.right, treeLst );
    }

}
