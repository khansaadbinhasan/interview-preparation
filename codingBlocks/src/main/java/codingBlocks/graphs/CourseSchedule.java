package codingBlocks.graphs;

import java.util.*;

public class CourseSchedule {

    public static void main(String[] args) {
        new CourseSchedule().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] prerequisites = new int[m][2];

        for (int i = 0; i < m; i++) {
            prerequisites[i][0] = sc.nextInt();
            prerequisites[i][1] = sc.nextInt();
        }

        System.out.println(canFinish(n, prerequisites)? "YES": "NO");
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
