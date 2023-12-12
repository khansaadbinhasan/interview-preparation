package leetcode.blind75;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

//[2,3,6,7]
//7
//[2,3,5]
//8
//[2]
//1
//[2,3,5]
//10
//[2]
//2
public class L39CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        //put all candidates in a set
        //go through the list and find the modulo with target and sea
        List<List<Integer>> combos = new LinkedList<>();//{{2,2,2,2,2},{7}}

        Set<Integer> set = new HashSet<>();
        for( int i = 0; i < candidates.length; i++ ){
            set.add(candidates[i]);
        }

        //[2,3,5], 10
        for( int i = 0; i < candidates.length; i++ ){//1
            int localTarget = target;//4
            List<Integer> lst = new LinkedList<>();//{}

            while( localTarget > 0 ){
                if( i < candidates.length && set.contains(localTarget-candidates[i]) ){
                    lst.add(localTarget-candidates[i]);
                    i++;
                }
                localTarget -= candidates[i];
                lst.add(candidates[i]);
            }

            if( localTarget == 0 ){
                combos.add(lst);
            }
        }

        return combos;
    }

}
