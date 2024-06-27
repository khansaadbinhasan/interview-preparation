package leetcode.medium;

import java.util.*;

//2
//[[0,1]]
//3
//[[1,0]]
//2
//[]
//2
//[[1,0]]
//4
//[[1,0],[2,0],[3,1],[3,2]]
//1
//[]
//5
//[[1,0],[2,0],[3,2],[4,0],[4,2],[4,3]]
//7
//[[1,0],[2,0],[3,2],[4,0],[4,2],[4,3]]
//3
//[[0,2],[1,2],[2,0]]
//4
//[[0,1],[3,1],[1,3],[3,2]]
public class L210CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] order = new int[numCourses];

        int[] numIncomingEdges = new int[numCourses];

        Arrays.fill(numIncomingEdges, 0);

        for (int i = 0; i < prerequisites.length; i++) {
            numIncomingEdges[prerequisites[i][1]]++;
        }

        int zeroIndex = getZeroPosition(numIncomingEdges);

        int ind = 0;
        Set<Integer> s = getCount(numCourses, prerequisites);

        int count = 0;

        while( zeroIndex != -1 ){
            numIncomingEdges[zeroIndex]--;
            count++;

            order[numCourses - ++ind] = zeroIndex;

            for (int i = 0; i < prerequisites.length; i++) {
                if( prerequisites[i][0] == zeroIndex ){
                    numIncomingEdges[prerequisites[i][1]]--;
                }
            }

            zeroIndex = getZeroPosition(numIncomingEdges);
        }


        return count == numCourses? order: new int[0];
    }

    public int getZeroPosition(int[] numIncomingEdges){
        for (int i = 0; i < numIncomingEdges.length; i++) {
            if( numIncomingEdges[i] == 0 ) return i;
        }

        return -1;
    }

    public Set<Integer> getCount(int numCourses, int[][] prerequisites){

        Set<Integer> courseSet = new HashSet<>();

        for( int i = 0; i < prerequisites.length; i++ ){
            for( int j = 0; j < prerequisites[i].length; j++ ){
                courseSet.add(prerequisites[i][j]);
            }
        }

        return courseSet;
    }


    public static void main(String[] args) {
        new L210CourseScheduleII().run();
    }

    public void run(){
        System.out.println(Arrays.toString(new Solution().findOrder(2, new int[][]{{0, 1}})));
    }

    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> set = new HashSet<>();

    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        createMap(prerequisites);

        if( hasCycle(numCourses) ) return new int[]{};

        int[] ans = new int[numCourses];
        int ind = 0;
        Set<Integer> set2 = new HashSet<>();


        for( int i = 0; i < numCourses; i++ ){
            for( int j = i; j < numCourses; j++ ){
                if( map.containsKey(j) ){
                    List<Integer> lst = new ArrayList<>(map.get(j));
                    for( int elem: lst ){
                        if( !map.containsKey(elem) ) map.get(j).remove(Integer.valueOf(elem));
                    }

                    if( map.get(j).isEmpty() ){
                        map.remove(j);
                    }
                }

                if( !map.containsKey(j) && !set2.contains(j) ) {
                    set2.add(j);
                    ans[ind++] = j;
                }
            }
        }

        return ans;
    }

    public boolean hasCycle(int numCourses){

        for( int i = 1; i < numCourses; i++ ){
            set = new HashSet<>();
            if( isCycle(i,i) )
                return true;
        }

        return false;
    }


    public boolean isCycle(int key, int initKey){
        if( set.contains(initKey) && key == initKey )
            return true;

        set.add(key);

        if( !map.containsKey(key) ) return false;

        for( int k: map.get(key) )
            if( isCycle(k, initKey) )
                return true;

        return false;
    }

    public void createMap(int[][] prerequisites){
        for( int i = 0; i < prerequisites.length; i++ ){
            if( !map.containsKey(prerequisites[i][0]) )
                map.put(prerequisites[i][0], new ArrayList<>());

            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
    }

    class Solution {
        Map<Integer, List<Integer>> map = new HashMap<>();//{{1->0},{2->0},{3->[1,2]}}
        Set<Integer> visitedSet = new HashSet<>();
        Set<Integer> set;
        int ind = 0;
        int numCourses;
        int[][] prerequisites;

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            this.numCourses = numCourses;
            this.prerequisites = prerequisites;

            createMap(prerequisites);

            if( hasCycle(numCourses) ) return new int[]{};

            int[] ans = new int[numCourses];
            Arrays.fill(ans, -1);

            //iterate and add all courses that have no dependency
            for( int i = 0; i < numCourses; i++ ){//4
                topSort(ans, i);
            }

            return ans;
        }

        public void topSort(int[] ans, int key){
            if( visitedSet.contains(key) ) return;

            List<Integer> deps = map.get(key);

            visitedSet.add(key);

            for( int i = 0; i < deps.size(); i++ ){
                topSort(ans, deps.get(i));
            }

            boolean visited = true;
            for( int i = 0; i < deps.size(); i++ ){
                if( !visitedSet.contains(deps.get(i)) ){
                    visited=false;
                    break;
                }
            }

            if( visited ) ans[ind++] = key;

        }

        public boolean hasCycle(int numCourses){

            for( int i = 0; i < numCourses; i++ ){
                set = new HashSet<>();
                if( isCycle(i) )
                    return true;
            }

            return false;
        }


        public boolean isCycle(int key){
            if( set.contains(key) )
                return true;

            set.add(key);

            if( !map.containsKey(key) ) return false;

            for( int k: map.get(key) )
                if( isCycle(k) )
                    return true;

            set.remove(key);

            return false;
        }

        public void createMap(int[][] prerequisites){
            for( int i = 0; i < prerequisites.length; i++ ){
                if( !map.containsKey(prerequisites[i][0]) )
                    map.put(prerequisites[i][0], new ArrayList<>());

                map.get(prerequisites[i][0]).add(prerequisites[i][1]);
            }

            for( int i = 0; i < numCourses; i++ ){
                if( !map.containsKey(i) ) map.put(i, new ArrayList<>());
            }
        }
    }


}