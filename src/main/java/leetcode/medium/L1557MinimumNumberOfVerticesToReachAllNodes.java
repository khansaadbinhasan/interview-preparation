package leetcode.medium;

import java.util.*;

public class L1557MinimumNumberOfVerticesToReachAllNodes {

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {

        Map<Integer, Integer> indegreeMap = new HashMap<>();

        for( List<Integer> e: edges ){
            indegreeMap.putIfAbsent(e.get(0), 0);
            indegreeMap.putIfAbsent(e.get(1), 0);
            indegreeMap.put( e.get(1), indegreeMap.get(e.get(1)) + 1 );
        }

        List<Integer> ans = new LinkedList<>();

        for( int node: indegreeMap.keySet() ){
            if( indegreeMap.get(node) == 0 ) ans.add(node);
        }

        return ans;
    }


}
