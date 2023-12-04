package leetcode.medium;

import java.util.*;

//[3,1,2,1]
//5
//[4,1,2,2]
//4
//[7,5,5,8,3]
//8
//[1]
//2
public class L1409QueriesOnPermutationWithKey {


    public int[] processQueries(int[] queries, int m) {

        int[] ans = new int[queries.length];
        LinkedList<Integer> perm = new LinkedList<>();

        for( int i = 1; i <= m; i++ ){
            perm.add(i);
        }

        for( int i = 0; i < queries.length; i++ ){
            int ind = perm.indexOf(queries[i]);
            perm.addFirst(perm.remove(ind));
            ans[i] = ind;
        }

        return ans;
    }

}
