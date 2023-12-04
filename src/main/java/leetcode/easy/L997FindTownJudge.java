package leetcode.easy;

import java.util.*;

//2
//[[1,2]]
//3
//[[1,3],[2,3]]
//3
//[[1,3],[2,3],[3,1]]
//5
//[]
//3
//[[1,2],[2,3],[3,1]]
//5
//[[1,3],[2,3]]
//5
//[[1,3],[2,3],[4,3],[5,3]]
//4
//[[1,3],[1,4],[2,3],[2,4],[4,3]]
public class L997FindTownJudge {

    public int findJudge(int n, int[][] trust) {

        if( (trust.length == 0) && n == 1 ) return 1;

        Set<Integer> nSet = new HashSet<>();
        Map<Integer, Set<Integer>> trustedTrusterSet = new HashMap<>();
        Set<Integer> trustSet = new HashSet<>();

        for( int i = 1; i <= n; i++ ){
            nSet.add(i);
        }

        for( int i = 0; i < trust.length; i++ ){
            trustedTrusterSet.putIfAbsent(trust[i][1], new HashSet<>());
            trustedTrusterSet.get(trust[i][1]).add(trust[i][0]);
            trustSet.add(trust[i][0]);
        }

        for( int trusted: trustedTrusterSet.keySet() ){
            nSet.remove(trusted);

            if( trustedTrusterSet.get(trusted).equals(nSet) && !trustSet.contains(trusted) ){
                return trusted;
            }

            nSet.add(trusted);
        }

        return -1;
    }
}
