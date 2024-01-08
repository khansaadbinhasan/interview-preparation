package CTCI.ch4treesAndGraphs;

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

//        weaveLists(first, second, results, prefix);

//        System.out.println(results);

        System.out.println(weaveLists(first, second));
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

    public ArrayList<LinkedList<Integer>> weaveLists(LinkedList<Integer> lst1, LinkedList<Integer> lst2){
        ArrayList<LinkedList<Integer>> lst = new ArrayList<>();

        if( lst1.size() == 0 ) {
            lst.add(new LinkedList<>(lst2));
            return lst;
        }

        if( lst2.size() == 0 ) {
            lst.add(new LinkedList<>(lst1));
            return lst;
        }

        if( lst1.size() == 1 && lst2.size() == 1 ){
            LinkedList<Integer> ans = new LinkedList<>();
            ans.addAll(new LinkedList<>(lst1));
            ans.addAll(new LinkedList<>(lst2));
            lst.add(ans);

            LinkedList<Integer> ans2 = new LinkedList<>();
            ans2.addAll(new LinkedList<>(lst2));
            ans2.addAll(new LinkedList<>(lst1));
            lst.add(ans2);

            return lst;
        }

        int num = lst1.removeLast();

        ArrayList<LinkedList<Integer>> listLists1 = weaveLists(lst1, lst2);

        for(LinkedList<Integer> list: listLists1){
            list.add(num);
        }

        lst1.add(num);


        num = lst2.removeLast();

        ArrayList<LinkedList<Integer>> listLists2 = weaveLists(lst1, lst2);

        for(LinkedList<Integer> list: listLists2){
            list.add(num);
        }

        lst2.add(num);

        listLists1.addAll(listLists2);

        return listLists1;
    }

    ArrayList<LinkedList<Integer>> allSeqs(TreeNode root){
        ArrayList<LinkedList<Integer>> result  = new ArrayList<>();

        if( root == null ) {
            result.add(new LinkedList<>());
            return result;
        }

        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(root.val);

        ArrayList<LinkedList<Integer>> leftRes = allSeqs(root.left);
        ArrayList<LinkedList<Integer>> rightRes = allSeqs(root.right);

        for( LinkedList<Integer> left: leftRes ){
            for( LinkedList<Integer> right: rightRes ){
                ArrayList<LinkedList<Integer>> weaved = weaveLists(left, right);
                result.addAll(weaved);
            }
        }

        return result;
    }

}
