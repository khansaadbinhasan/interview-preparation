package leetcode.easy;

//[[0,1],[1,0]]
//[[1,0],[0,1]]
//[[0,1],[1,1]]
//[[1,0],[0,1]]
//[[0,0,0],[0,1,0],[1,1,1]]
//[[1,1,1],[0,1,0],[0,0,0]]
//[[0]]
//[[0]]
//[[0]]
//[[1]]
//[[0,0,0],[0,0,1],[0,0,1]]
//[[0,0,0],[0,0,1],[0,0,1]]
public class L1886DetermineMatrixRotation {

    public static void main(String[] args) {
        new L1886DetermineMatrixRotation().run();
    }

    public void run(){
        boolean rotation = findRotation(
                new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}},
                new int[][]{{1, 1, 1}, {0, 1, 0}, {0, 0, 0}}
        );

        System.out.println(rotation);
    }

    public boolean findRotation(int[][] mat, int[][] target) {
        return equals0(mat, target) || equals90(mat, target) || equals180(mat, target) || equals270(mat, target);
    }

    public boolean equals0(int[][] mat, int[][] target){
        int n = mat.length;

        for( int i = 0; i < n; i++ ){
            for( int j = 0; j < n; j++ ){
                if( target[i][j] != mat[i][j] ) return false;
            }
        }

        return true;
    }

    public boolean equals90(int[][] mat, int[][] target){
        int n = mat.length;

        for( int i = 0; i < n; i++ ){
            for( int j = 0; j < n; j++ ){
                int[] ij = get90DegreeIJ(new int[]{i, j}, n);
                if( target[i][j] != mat[ij[0]][ij[1]] ) return false;
            }
        }

        return true;
    }

    public boolean equals180(int[][] mat, int[][] target){
        int n = mat.length;

        for( int i = 0; i < n; i++ ){
            for( int j = 0; j < n; j++ ){
                int[] ij = get90DegreeIJ(get90DegreeIJ(new int[]{i, j}, n), n);
                if( target[i][j] != mat[ij[0]][ij[1]] ) return false;
            }
        }

        return true;
    }

    public boolean equals270(int[][] mat, int[][] target){
        int n = mat.length;

        for( int i = 0; i < n; i++ ){
            for( int j = 0; j < n; j++ ){
                int[] ij = get90DegreeIJ(new int[]{i, j}, n);
                ij = get90DegreeIJ(get90DegreeIJ(ij, n), n);
                if( target[i][j] != mat[ij[0]][ij[1]] ) return false;
            }
        }

        return true;
    }

    public int[] get90DegreeIJ(int[] ij, int n){
        return new int[]{ij[1], n-1-ij[0]};
    }
}
