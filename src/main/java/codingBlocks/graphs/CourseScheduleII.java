package codingBlocks.graphs;

import java.util.*;

//2
//[[1,0]]
//4
//[[1,0],[2,0],[3,1],[3,2]]
//1
//[]
//3
//[[1,0]]
//2
//[]

public class CourseScheduleII {

    public static void main(String[] args) {
        new CourseScheduleII().run();
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

        for( int course: findOrder(n, prerequisites) ){
            System.out.print(course + " ");
        }
    }

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

        System.out.println(count);


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


}
