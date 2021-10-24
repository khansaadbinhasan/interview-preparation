package leetcode.easy;

//[[1,1],[3,4],[-1,0]]
//[[3,2],[-2,2]]
//[[1,1]]
//[[-2,-2],[1,1]]
public class L1266MinTimeVisitingAllPoints {

    public int minTimeToVisitAllPoints(int[][] points) {

        int time = 0;

        for( int i = 1; i < points.length; i++ ){

            int[] point1 = points[i-1];
            int[] point2 = points[i];

            int xDist = Math.abs(point2[0] - point1[0]);
            int yDist = Math.abs(point2[1] - point1[1]);

            time += Math.max(xDist, yDist);

        }

        return time;
    }


}
