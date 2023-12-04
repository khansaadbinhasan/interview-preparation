package leetcode.easy;

//[1,null,2,2]
//[0]

import java.util.*;

public class L501FindModeInBST {

    public static void main(String[] args){
        new L501FindModeInBST().run();
    }

    public void run(){
        TreeNode root = new TreeNode(1);

        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);

        int[] mode = findMode(root);

        for (int i = 0; i < mode.length; i++) {
            System.out.println(mode[i]);
        }
    }

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


    HashMap<Integer, Integer> freqMap = new HashMap<>();

    public int[] findMode(TreeNode root) {

        List<Integer> modeVals = new LinkedList<>();
        int max = 1;

        getFreqMap(root, root);

        for( int key: freqMap.keySet() ){
            int count = freqMap.get(key);
            max = Math.max(count, max);
        }

        for( int key: freqMap.keySet() ){
            int count = freqMap.get(key);

            if( count == max ){
                modeVals.add(key);
            }
        }

        int[] modeValsArr = new int[modeVals.size()];

        for (int i = 0; i < modeVals.size(); i++) {
            modeValsArr[i] = modeVals.get(i);
        }

        return modeValsArr;

    }

    public void getFreqMap(TreeNode root, TreeNode currRoot){

        if( root == null || currRoot == null ) return;

        int count = 0;

        count = countNumberOfVals(root, currRoot.val, count);
        freqMap.put(currRoot.val, count);

        if( currRoot.left != null ) getFreqMap(root, currRoot.left);
        if( currRoot.right != null ) getFreqMap(root, currRoot.right);
    }

    public int countNumberOfVals(TreeNode root, int val, int count){

        if( root == null ) return count;

        if( root.val == val ) count = 1;

        return count + countNumberOfVals(root.left, val, 0) + countNumberOfVals(root.right, val, 0);
    }

}
