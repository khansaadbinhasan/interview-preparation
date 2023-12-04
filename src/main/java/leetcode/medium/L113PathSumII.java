package leetcode.medium;

import java.util.*;


//[5,4,8,11,null,13,4,7,2,null,null,5,1]
//22
//[1,2,3]
//5
//[1,2]
//0
//[]
//0
//[]
//1
//[5,4,8,11,null,13,4,7,2,null,null,null,1]
//22
//[1,2]
//0
//[]
//0
//[]
//1
//[1,2]
//1
//[1,2]
//2

public class L113PathSumII {

    class TreeNode{
        public int val;

        public TreeNode left;
        public TreeNode right;
        public TreeNode parent;
    }


    List<List<Integer>> pathSumList = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if( root == null ) return null;

        pathSum(root, targetSum, new LinkedList<>());

        return pathSumList;

    }

    public List<Integer> pathSum(TreeNode root, int targetSum, LinkedList<Integer> path) {
        if( root == null ) return null;

        if(root.val == targetSum && root.left == null && root.right == null){
            path.add(root.val);
            pathSumList.add(path);
        }


        List<Integer> leftList = pathSum(root.left, targetSum-root.val, new LinkedList<>(path));
        List<Integer> rightList = pathSum(root.right, targetSum-root.val, new LinkedList<>(path));

        if( leftList != null ) pathSumList.add(leftList);
        if( rightList != null ) pathSumList.add(rightList);

        return null;
    }


}
