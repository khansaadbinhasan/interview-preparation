package leetcode.easy;

import java.util.*;

public class L1863SumOfAllSubsetsOfXORs {

    public static void main(String[] args) {
        new L1863SumOfAllSubsetsOfXORs().run();
    }

    public void run(){
//        LinkedList<LinkedList<Integer>> ll = new LinkedList<>();
//        ll.add(new LinkedList<>());
//        System.out.println(backtrack(new int[]{1,2,3}, 0, ll));
        System.out.println(subsetXORSum2(new int[]{1,2,3,4,5,6,7,8,9,10,11,12}));
        System.out.println(count);
    }


    public int subsetXORSum3(int[] nums) {
        return subsetXORSum(nums, 0, nums[0]);
    }

    public int subsetXORSum(int[] nums, int i, int xor) {
        if( i == nums.length ) return xor;

        int xor1 = subsetXORSum(nums, i+1, xor);
        int xor2 = subsetXORSum(nums, i+1, xor^nums[i]);

        return xor1 + xor2;
    }


    public int subsetXORSum2(int[] nums) {
        return subsetXORSum(nums, 0, new LinkedList<>());
    }

    int count = 0;

    public int subsetXORSum(int[] nums, int i, List<Integer> lst) {
        if( i == nums.length ) return doXor(lst);

        int xor1 = subsetXORSum(nums, i+1, lst);
        lst.add(nums[i]);
        int xor2 = subsetXORSum(nums, i+1, lst);

        count++;

        return xor1 + xor2;
    }

    public int doXor(List<Integer> lst){
        if( lst.size() == 0 ) return 0;
        int xor = lst.get(0);
        for( int i = 1; i < lst.size(); i++ ){
            xor ^= lst.get(i);
        }

        return xor;
    }






    public LinkedList<LinkedList<Integer>> backtrack(int[] lst, int i, LinkedList<LinkedList<Integer>> ll){
        if( i == lst.length ) return ll;

        LinkedList<LinkedList<Integer>> ll2 = new LinkedList<>();

        for( LinkedList<Integer> l: ll ){
            ll2.add(new LinkedList<>(l));
        }

        for( LinkedList<Integer> list: ll2 ){
            list.add(lst[i]);
        }

        ll.addAll(ll2);

        backtrack(lst, i+1, ll);
        return ll;
    }

    public int subsetXORSum(int[] nums) {
        List<List<Integer>> ll = new LinkedList<>();
        ll.add(new LinkedList<>());
        return XORSum(getSubsetList(nums, 0, ll));
    }

    public List<List<Integer>> getSubsetList(int[] nums, int i, List<List<Integer>> numList){

        if( i == nums.length ) return numList;

        List<List<Integer>> numList2 = new LinkedList<>();

        for( List<Integer> l: numList ){
            numList2.add(new LinkedList<>(l));
        }

        for( List<Integer> list: numList2 ){
            list.add(nums[i]);
        }

        numList.addAll(numList2);

        getSubsetList(nums, i+1, numList);

        return numList;
    }

    public int XORSum(List<List<Integer>> numList){
        int sum = 0;
        for( int i = 0; i < numList.size(); i++ ){

            if( numList.get(i).size() == 0 ) continue;

            int xor = numList.get(i).get(0);

            for( int j = 1; j < numList.get(i).size(); j++ ){
                xor = xor ^ numList.get(i).get(j);
            }
            sum += xor;
        }

        return sum;
    }
}
