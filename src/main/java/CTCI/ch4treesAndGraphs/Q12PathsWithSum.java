package CTCI.ch4treesAndGraphs;

import java.util.HashMap;

public class Q12PathsWithSum {

    class TreeNode{
        public int val;

        public TreeNode left;
        public TreeNode right;
        public TreeNode parent;
    }


    int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if( root == null ) return 0;

        hasPathSum(root, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);

        return count;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if( root == null ) return false;

        boolean hasPathSum = false;

        if( root.val == targetSum ) {
            count++;
            hasPathSum = true;
        }

        return  hasPathSum(root.left, targetSum-root.val) ||
                hasPathSum(root.right, targetSum-root.val);
    }


    public int countPathsWithSum(TreeNode root, int targetSum){
        return countPathsWithSum(root, targetSum, 0, new HashMap<>());
    }

    public int countPathsWithSum(TreeNode node, int targetSum,
                                 int runningSum, HashMap<Integer, Integer> pathCount){

        if( node == null ) return 0;

        runningSum += node.val;

        int sum = runningSum - targetSum;
        int totalPaths = pathCount.getOrDefault(sum, 0);

        if( runningSum == targetSum ) totalPaths++;

        incrementHashTable(pathCount, runningSum, 1);
        totalPaths += countPathsWithSum(node.left, targetSum, runningSum, pathCount);
        totalPaths += countPathsWithSum(node.right, targetSum, runningSum, pathCount);
        incrementHashTable(pathCount, runningSum, -1);

        return totalPaths;
    }

    public void incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int delta){
        int newCount = hashTable.getOrDefault(key, 0) + delta;

        if( newCount == 0 ) hashTable.remove(key);
        else hashTable.put(key, newCount);
    }

}
