package CTCI.treesAndGraphs;

import java.util.*;

public class Q9PermuationBST {

    class TreeNode{
        public int val;

        public TreeNode left;
        public TreeNode right;
        public TreeNode parent;
    }

    public static void main(String[] args) {
        new Q9PermuationBST().run();
    }

    public void run(){
        LinkedList<Integer> first = new LinkedList<>();
        LinkedList<Integer> second = new LinkedList<>();
        ArrayList<LinkedList<Integer>> results = new ArrayList<>();
        LinkedList<Integer> prefix = new LinkedList<>();

        first.add(1); first.add(2);
        second.add(3); second.add(4);
//        first.addAll(1,2);

        weaveLists(first, second, results, prefix);

        System.out.println(results);
    }

    public int numOfWays(int[] nums) {
        return 79;
    }

    ArrayList<LinkedList<Integer>> allSequences(TreeNode node){
        ArrayList<LinkedList<Integer>> results = new ArrayList<>();

        if( node == null ) {
            results.add(new LinkedList<>());
            return results;
        }

        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(node.val);

        ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.left);
        ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);

        for( LinkedList<Integer> left: leftSeq ){
            for( LinkedList<Integer> right: rightSeq ){
                ArrayList<LinkedList<Integer>> weaved = new ArrayList<>();

                weaveLists(left, right, weaved, prefix);

                results.addAll(weaved);
            }
        }

        return results;
    }


    public void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second,
                           ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix){
        if( first.size() == 0 || second.size() == 0 ) {

            LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();

            result.addAll(first);
            result.addAll(second);
            results.add(result);

            return;
        }

        int headFirst = first.removeFirst();
        prefix.addLast(headFirst);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        first.addFirst(headFirst);

        int headSecond = second.removeFirst();
        prefix.addLast(headSecond);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        second.addFirst(headSecond);
    }

}
