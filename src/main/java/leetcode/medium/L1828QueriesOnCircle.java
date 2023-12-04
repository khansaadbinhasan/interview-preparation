package leetcode.medium;

//[[1,3],[3,3],[5,3],[2,2]]
//[[2,3,1],[4,3,1],[1,1,2]]
//[[1,1],[2,2],[3,3],[4,4],[5,5]]
//[[1,2,2],[2,2,2],[4,3,2],[4,3,3]]
public class L1828QueriesOnCircle {
    public int[] countPoints(int[][] points, int[][] queries) {

        int[] countArr = new int[queries.length];

        for( int i = 0; i < queries.length; i++ ){
            int count = 0;
            for( int j = 0; j < points.length; j++ ){
                if( isInside(queries[i], points[j]) ) count++;
            }
            countArr[i] = count;
        }

        return countArr;

    }

    public boolean isInside(int[] circle, int[] point){

        int cx = circle[0];
        int cy = circle[1];
        int radius = circle[2];

        int px = point[0];
        int py = point[1];


        return Math.sqrt(Math.pow(px-cx,2)+Math.pow(py-cy,2)) <= radius;

    }


}
