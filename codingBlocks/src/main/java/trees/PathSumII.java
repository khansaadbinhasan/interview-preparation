package trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class PathSumII {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        new PathSumII().run();
    }

    public void run() {
        Scanner sc = new Scanner(System.in);

        String[] inpLine = sc.nextLine().trim().split(" ");

        TreeNode root = new TreeNode(Integer.parseInt(inpLine[0]));

        for (int i = 1; i < inpLine.length; i++) {
            int val = Integer.parseInt(inpLine[i]);

            if( val != -1 ) root = levelOrderInsertion(root, new TreeNode(val));
        }

        System.out.println(pathSum2(root, sc.nextInt()).size());
    }

    List<List<Integer>> ans;

    public void pathSumHelper(TreeNode root, int sum, List<Integer> l){
        if( root == null ) return;

        l.add(root.val);
        sum -= root.val;

        if( root.left == null && root.right == null && sum == 0 ) ans.add(l);

        pathSumHelper(root.left, sum, l);
        pathSumHelper(root.right, sum, l);

        l.remove(l.size()-1);
    }

    public List<List<Integer>> pathSum2(TreeNode root, int sum){
        if( root == null ) return new LinkedList<>();

        ans = new LinkedList<>();

        pathSumHelper(root, sum, new LinkedList<>());

        return ans;
    }

    public TreeNode levelOrderInsertion(TreeNode root, TreeNode node) {

        if (root == null) return node;

        Queue<TreeNode> treeQueue = new LinkedList<>();

        treeQueue.add(root);

        while (!treeQueue.isEmpty()) {
            TreeNode polledNode = treeQueue.poll();

            if (polledNode == null) continue;

            if (polledNode.left == null) {
                polledNode.left = node;
                return root;
            } else if (polledNode.right == null) {
                polledNode.right = node;
                return root;
            } else {
                treeQueue.add(polledNode.left);
                treeQueue.add(polledNode.right);
            }

            treeQueue.add(node.left);
            treeQueue.add(node.right);
        }

        return root;
    }


    private List<Integer> pathList = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        if (root == null) return new LinkedList<>();

        List<List<Integer>> listPathSums = new LinkedList<>();

        sumPaths(root, targetSum, root.val, listPathSums);

        return listPathSums;
    }

    public void sumPaths(TreeNode root, int targetSum, int currentSum, List<List<Integer>> listPathSums) {

        if ((root.left == null && root.right == null) ||
                (root.left == null && root.right.val + currentSum > targetSum) ||
                (root.right == null && root.left.val + currentSum > targetSum) ||
                (root.left != null && root.right != null &&
                        root.left.val + currentSum > targetSum && root.right.val + currentSum > targetSum)) {

            pathList = new LinkedList<>();
            return;
        }


        if (root.left != null && root.left.right == null && root.left.left == null &&
                root.left.val + currentSum == targetSum) {
            if (pathList.isEmpty()) pathList.add(root.val);
            pathList.add(root.left.val);

            listPathSums.add(pathList);
            pathList = new LinkedList<>();

            return;
        }

        if (root.right != null && root.right.right == null && root.right.left == null &&
                root.right.val + currentSum == targetSum) {
            if (pathList.isEmpty()) pathList.add(root.val);
            pathList.add(root.right.val);

            listPathSums.add(pathList);
            pathList = new LinkedList<>();

            return;
        }

        if (root.right != null && root.right.val + currentSum < targetSum) {
            if (pathList.isEmpty()) pathList.add(root.val);
            pathList.add(root.right.val);

            sumPaths(root.right, targetSum, root.right.val + currentSum, listPathSums);
        }


        if (root.left != null && root.left.val + currentSum < targetSum) {
            if (pathList.isEmpty()) pathList.add(root.val);
            pathList.add(root.left.val);

            sumPaths(root.left, targetSum, root.left.val + currentSum, listPathSums);
        }
    }
}