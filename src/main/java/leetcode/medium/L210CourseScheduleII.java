package leetcode.medium;

import java.util.*;

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
        System.out.println(Arrays.toString(findOrder2(2, new int[][]{{1, 0}})));
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



}
