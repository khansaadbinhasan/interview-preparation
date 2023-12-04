package codingBlocks.trees;

import java.util.*;

//8 3 -1 -1 35 -1 52 -1 92 72 67 -1 -1 -1 97 -1 -1

public class CovertBSTToGreaterTree {

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
        new CovertBSTToGreaterTree().run();
    }

    private Scanner sc = new Scanner(System.in);

    public void run(){
        TreeNode root = preorderInput();
        preorder(convertBST(root));
    }

    public TreeNode preorderInput(){
        int val = sc.nextInt();

        if( val == -1 ) return null;

        TreeNode node = new TreeNode(val);
        node.left = preorderInput();
        node.right = preorderInput();

        return node;
    }

    public TreeNode convertBST(TreeNode root) {

        if( root == null ) return null;

        int[] nodeValsArr = getNodeValsArr(root);

        Map<Integer, Integer> map = fillMap(nodeValsArr);

        replaceOldValsWithMapVals(root, map);

        return root;
    }

    public Map<Integer, Integer> fillMap(int[] nodeVals){

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        map.put(nodeVals[0], nodeVals[0]);

        int currVal = nodeVals[0];

        for( int i = 1; i < nodeVals.length; i++ ){
            map.put(nodeVals[i], currVal + nodeVals[i]);
            currVal = currVal + nodeVals[i];
        }

        return map;
    }

    public void replaceOldValsWithMapVals(TreeNode root, Map<Integer, Integer> map){
        if( root == null ) return;

        root.val = map.get(root.val);
        replaceOldValsWithMapVals(root.left, map);
        replaceOldValsWithMapVals(root.right, map);
    }

    public int[] getNodeValsArr(TreeNode root){

        List<Integer> lstVals = new LinkedList<>();

        fillInPreorder(root, lstVals);

        lstVals.sort(Collections.reverseOrder());

        int[] nodeValArr = new int[lstVals.size()];

        for( int i = 0; i < nodeValArr.length; i++ ){
            nodeValArr[i] = lstVals.get(i);
        }

        return nodeValArr;
    }

    public void fillInPreorder(TreeNode root, List<Integer> lstVals){
        if( root == null ) return;

        lstVals.add(root.val);
        fillInPreorder(root.left, lstVals);
        fillInPreorder(root.right, lstVals);
    }

    public void preorder(TreeNode root){
        if( root == null ) return;

        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }
}
