package leetcode.easy;

//10
//[[0,3],[2,5],[0,9],[1,15]]
//26
//[[1,1],[3,7],[2,12],[7,17]]
//2
//[[0,10],[1,20]]

public class L2432EmployeeWorkedLongest {

    public static void main(String[] args){
        int i = new L2432EmployeeWorkedLongest().hardestWorker(
                26, new int[][]{new int[]{1,1}, new int[]{3,7}, new int[]{2,12}, new int[]{7,17}}
                );

        System.out.println(i);
    }


    public int hardestWorker(int n, int[][] logs) {

        int id = logs[0][0];
        int max = logs[0][1];
        int oldMax = max;

        for( int i = 1; i < logs.length; i++ ){
            int newMax = logs[i][1] - logs[i-1][1];
            max = Math.max(oldMax, newMax);

            if( max > oldMax ) {
                id = logs[i][0];
                oldMax = max;
            }

            if( newMax == oldMax ) {
                id = Math.min(id, logs[i][0]);
            }
        }

        return id;
    }

}
