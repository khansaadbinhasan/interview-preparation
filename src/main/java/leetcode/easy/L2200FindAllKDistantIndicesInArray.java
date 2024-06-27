package leetcode.easy;

import java.util.*;

//[3,4,9,1,3,9,5]
//9
//1
//[2,2,2,2,2]
//2
//2
//[1]
//1
//1
public class L2200FindAllKDistantIndicesInArray {

//    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
//
//        List<Integer> kDistantIndices = new LinkedList<>();
//
//        if( nums[0] == key ) kDistantIndices.add(0);
//
//        for( int i = 1; i < nums.length; i++ ){
//            int index = 0;
//            if( nums[i] == key ){
//                index = i;
//                kDistantIndices.add(index--);
//                while( index >= 0 && index >= kDistantIndices.get(0) ) {
//                    index--;
//                }
//                while( index >= 0 && index >= index-k ){
//                    kDistantIndices.add(index--);
//                }
//
//                index = i+1;
//                while( index < nums.length && index <= kDistantIndices.get(kDistantIndices.size()-1) ){
//                    index++;
//                }
//                while( index < nums.length && index <= index+k ){
//                    kDistantIndices.add(index++);
//                }
//            }
//
//            // i = index;
//        }
//
//
//        kDistantIndices.sort(Comparator.naturalOrder());
//
//        return kDistantIndices;
//    }

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {

        List<Integer> ans = new LinkedList<>();

        for( int i = 0; i < nums.length; i++ ){
            if( nums[i] == key ) {
                int start = Math.max(0, i-k);
                int end = Math.min(nums.length-1, i+k);

                while( ans.size() > 0 && start <= ans.get(ans.size()-1) ) start++;

                for( int j = start; j <= end; j++ ){
                    ans.add(j);
                }
            }
        }

        return ans;
    }

}
