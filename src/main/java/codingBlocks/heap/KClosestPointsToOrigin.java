package codingBlocks.heap;

import java.util.*;

public class KClosestPointsToOrigin {

    class Point implements Comparable{
        int x;
        int y;
        double dist00;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
            this.dist00 = this.getDist(0,0);
        }

        @Override
        public int compareTo(Object o) {
            Point that = (Point) o;
            return gid(this.dist00 - that.dist00);
        }

        public int gid( double num ){
            return num != 0 ? (int) (num + 1 * num / Math.abs(num)): 0;
        }

        public double getDist(int x, int y){
            return Math.sqrt(Math.pow(this.x-x, 2) + Math.pow(this.y-y, 2));
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }

    public static void main(String[] args) {
        new KClosestPointsToOrigin().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] points = new int[N][2];

        for (int i = 0; i < N; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }

        int k = sc.nextInt();

        int[][] ans = kClosest(points, k);

        for (int i = 0; i < k; i++) {
            System.out.println(ans[i][0] + " " + ans[i][1]);
        }
    }

    public int[][] kClosest(int[][] points, int k) {

        int[][] ans = new int[k][2];

        PriorityQueue<Point> pointsPQ = new PriorityQueue<>(Collections.reverseOrder());

        for (int[] point : points) {
            Point p = new Point(point[0], point[1]);

            if (pointsPQ.size() >= k) {
                if (pointsPQ.peek().compareTo(p) > 0) pointsPQ.poll();
                else continue;
            }

            pointsPQ.offer(p);
        }

        int i = 0;

        while( !pointsPQ.isEmpty() ){
            Point p = pointsPQ.poll();

            ans[i][0] = p.x;
            ans[i][1] = p.y;

            i++;
        }

        return ans;
    }

}
