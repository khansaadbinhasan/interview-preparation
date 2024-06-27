package leetcode.medium;

import java.util.*;

//[[1,2],[3],[3],[]]
//[[4,3,1],[3,2,4],[3],[4],[]]
//[[1],[]]
//[[1],[2],[]]
//[[1,2],[2],[]]
public class L797AllPathsFromSourceToTarget {

    public static void main(String[] args) {
        new L797AllPathsFromSourceToTarget().run();
    }

    public void run(){
        System.out.println(allPathsSourceTarget(new int[][]{{1,2},{3},{3},{}}));
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> allPaths = new LinkedList<>();
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> paths = new LinkedList<>();

        paths.add(0);
        allPaths.add(paths);

        while(!allPaths.isEmpty()){
            for( int i = 0; i < allPaths.size(); i++ ){
                List<Integer> path = allPaths.get(i);
                int end = path.get(path.size()-1);

                for( int j = 0; j < graph[end].length; j++ ){
                    List<Integer> p = new LinkedList<>(path);
                    p.add(graph[end][j]);
                    allPaths.add(p);

                    if( graph[end][j] == graph.length-1 ){
                        ans.add(p);
                        allPaths.remove(p);
                    }
                }
                allPaths.remove(path);
            }
        }

        return ans;
    }

}
