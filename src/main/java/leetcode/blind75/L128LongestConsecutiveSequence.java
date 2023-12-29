package leetcode.blind75;

import java.util.*;

//[100,4,200,1,3,2]
//[0,3,7,2,5,8,4,6,0,1]
public class L128LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        int lenSubSequence = 0;

        Set<Integer> numSet1 = new HashSet<>();
        Set<Integer> numSet2 = new HashSet<>();


        for(int num: nums) numSet1.add(num);
        for(int num: nums) numSet2.add(num);


        for( int num: numSet1 ){

            if( numSet2.contains(num) ){
                numSet2.remove(num);

                int numMin1 = num-1;
                int numPlus1 = num+1;

                int currLen = 1;

                while( numSet1.contains(numMin1) || numSet1.contains(numPlus1) ){
                    if( numSet1.contains(numMin1) ) {
                        numMin1 = numMin1-1;
                        numSet2.remove(numMin1);
                        currLen++;
                    }

                    if( numSet1.contains(numPlus1) ) {
                        numPlus1 = numPlus1+1;
                        numSet2.remove(numPlus1);
                        currLen++;
                    }
                }

                lenSubSequence = Math.max(lenSubSequence, currLen);
            }

        }

        return lenSubSequence;

    }

    public static void main(String[] args) {
        new L128LongestConsecutiveSequence().run();
    }

    public void run(){
        System.out.println(longestConsecutive2(new int[]{100,4,200,1,3,2}));
    }

    public int longestConsecutive2(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for( int i = 0; i < nums.length; i++ ){
            set.add(nums[i]);
        }

        Map<Integer, Integer> map = new HashMap<>();

        for( int n: nums ){
            if( !map.containsKey(n) ) map.put(n, n);
            if( set.contains(n-1) ) map.put(n,n-1);
        }

        int max = 0;

        while( !map.isEmpty() ){
            int key = Integer.MAX_VALUE;
            Iterator<Integer> iterator = map.keySet().iterator();
            if( iterator.hasNext() ){
                key = iterator.next();
            }
            int seq = 1;

            while(!map.isEmpty() && map.containsKey(--key)){
                map.put(key, key);
                map.remove(key);
            }
            map.remove(key);
            max = Math.max(max, seq);
        }

        return max;
    }

    public int longestConsecutive3(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for( int i = 0; i < nums.length; i++ ){
            set.add(nums[i]);
        }

        Map<Integer, Integer> map = new HashMap<>();

        for( int n: nums ){
            if( !map.containsKey(n) ) map.put(n, n);
            if( set.contains(n-1) ) map.put(n,n-1);
        }

        Iterator<Integer> iterator = map.keySet().iterator();

        while( iterator.hasNext() ){
            int key = iterator.next();

            while(!map.isEmpty() && map.containsKey(--key)){
                map.put(key+1, map.get(key));
                map.remove(key);
            }
            map.remove(key);
        }

        int max = 0;

        for( int key: map.keySet() ){
            max = Math.max(max, map.get(key) - key + 1);
        }

        return max;
    }


    public int longestConsecutive5(int[] nums) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for( int i = 0; i < nums.length; i++ ){
            set1.add(nums[i]);
            set2.add(nums[i]);
        }

        int max = 0;

        for( int key: set1 ){

            int sum = 1;
            int currKey = key;

            while( !set2.isEmpty() && set2.contains(--currKey) ){
                set2.remove(currKey);
                sum++;
            }

            currKey = key;

            while( !set2.isEmpty() && set2.contains(++currKey) ){
                set2.remove(currKey);
                sum++;
            }

            set2.remove(key);
            max = Math.max(max, sum);

            if( set2.isEmpty() ) break;
        }

        return max;
    }



}



















