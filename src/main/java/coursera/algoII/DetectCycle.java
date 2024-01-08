package coursera.algoII;

import java.util.*;

public class DetectCycle {
    Map<Integer, List<Integer>> map = new HashMap<>();//{{1->0},{2->0},{3->[1,2]}}
    int numCourses;
    int[][] prerequisites;
    Set<Integer> vis = new HashSet<>();

    public boolean hasCycle(){
        for( int key: map.keySet() ) {
            if( isCycle(key, key) ){
                return true;
            }
            vis.clear();
        }

        return false;
    }

    public boolean isCycle(int node, int startNode){
        if( node == startNode && vis.contains(node) ) return true;
        if( vis.contains(node) ) return false;

        vis.add(node);

        List<Integer> deps = map.get(node);

        for( int dep: deps ){
            if( isCycle(dep, startNode) ) return true;
        }

        return false;
    }

}
