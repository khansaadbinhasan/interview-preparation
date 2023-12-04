package leetcode.easy;


//[[1,1],[2,3],[3,2]]
//[[1,1],[2,2],[3,3]]
//[[1,1],[1,1],[3,3]]
//[[1,1],[1,1],[1,1]]
//[[1,1],[5,5],[10,3]]
//[[0,0],[5,0],[10,0]]
//[[0,0],[0,5],[10,0]]
//[[1,1],[2,2],[7,7]]
//[[0,1],[2,1],[0,0]]
//[[0,1],[2,1],[0,0]]
//[[52,86],[12,65],[24,71]]
public class L1037IsValidBoomerange {

    public static void main(String[] args) {
        new L1037IsValidBoomerange().run();
    }

    public void run(){
        System.out.println(isBoomerang(new int[][]{{52,86},{12,65},{24,71}}));
    }

    public boolean isBoomerang(int[][] points) {

        double x = getDist(points[0], points[1]);
        double y = getDist(points[0], points[2]);
        double z = getDist(points[2], points[1]);

        if( x == 0 || y == 0 || z == 0 ) return false;

        double slope1 = getSlope(points[0], points[1]);
        double slope2 = getSlope(points[1], points[2]);
        double slope3 = getSlope(points[0], points[2]);

        return (slope1 != slope2) || (slope3 != slope2) || (slope1 != slope3);
    }

    public double getSlope(int[] point1, int[] point2){

        if( point2[0] == point1[0] ) return -9000;

        return (double) (point2[1] - point1[1]) / (point2[0]-point1[0]);
    }

    public double getDist(int[] point1, int[] point2){
        return Math.sqrt(
                Math.pow(point1[0]-point2[0], 2) + Math.pow(point1[1]-point2[1], 2)
        );
    }
}
