package leetcode.blind75;

import java.util.*;

//2
//[[1,0]]
//2
//[[1,0],[0,1]]
//3
//[[1,2],[2,0],[1,1],[1,0]]
//5
//[[0,1],[0,2],[0,4],[1,2],[2,3],[2,4],[3,4]]
//5
//[[0,1],[0,2],[0,4],[1,2],[2,3],[2,4],[3,4],[3,1]]
public class L207CourseSchedule {

    public static void main(String[] args) {
        new L207CourseSchedule().run();
    }

    public void run(){
        System.out.println(canFinish2(2, new int[][]{{1,0}}));
    }


    List<Integer>[] map;
    Set<Integer> set;
    int curr;

    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        map = new LinkedList[numCourses];

        for( int i = 0; i < map.length; i++ ){
            map[i] = new LinkedList<>();
        }

        for( int i = 0; i < prerequisites.length; i++ ){
            map[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        for( int i = 0; i < numCourses; i++ ){
            set = new HashSet<>();
            curr = i;

            for( int k: map[i] ){
                dfs(k);
            }
            if( set.contains(i) ) return false;
        }

        return true;
    }

    public boolean dfs(int n){
        if( set.contains(curr) ) return true;

        if( !set.contains(n) ){
            set.add(n);

            for( int k: map[n] ){
                if( dfs(k) ) return true;
            }
        }

        return false;
    }











    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if(prerequisites.length == 0) return true;

        int[] numIncomingEdges = new int[numCourses];

        Arrays.fill(numIncomingEdges, 0);

        for (int i = 0; i < prerequisites.length; i++) {
            numIncomingEdges[prerequisites[i][1]]++;
        }

        int zeroIndex = getZeroPosition(numIncomingEdges);
        int countCourses = 0;

        while( zeroIndex != -1 ){
            numIncomingEdges[zeroIndex]--;
            countCourses++;

            for (int i = 0; i < prerequisites.length; i++) {
                if( prerequisites[i][0] == zeroIndex ) numIncomingEdges[prerequisites[i][1]]--;
            }

            zeroIndex = getZeroPosition(numIncomingEdges);
        }

        return countCourses == numCourses;
    }

    public int getZeroPosition(int[] numIncomingEdges){
        for (int i = 0; i < numIncomingEdges.length; i++) {
            if( numIncomingEdges[i] == 0 ) return i;
        }

        return -1;
    }

}
