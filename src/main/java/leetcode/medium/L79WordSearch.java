package leetcode.medium;

//[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
//"ABCCED"
//[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
//"SEE"
//[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
//"ABCB"
//[["A"]]
//"A"
//[["A"]]
//"B"
//[["A","B","C","E"],["S","F","E","S"],["A","D","E","E"]]
//"ABCESEEEFS"
public class L79WordSearch {


    public static void main(String[] args) {
        new L79WordSearch().run();
    }

    public void run(){
        System.out.println(exist(new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}}, "ABCESEEEFS"));
    }

    int m, n;
    String s;

    public boolean exist(char[][] board, String word) {
        m = board.length;//3
        n = board[0].length;//4
        s = word;//ABCB

        for( int i = 0; i < m; i++ ){//0,3
            for( int j = 0; j < n; j++ ){//0,4
                if( dfs(board, i, j, 0, new boolean[m][n]) ) return true;
            }
        }

        return false;
    }

    //p is pointer of String
    //ABCESEEEFS
    boolean dfs(char[][] mat, int i, int j, int p, boolean[][] marked){//0,1,1
        if( p >= s.length() ) return true;//
        if( i < 0 || i >= m || j < 0 || j >= n ) return false;

        if( !marked[i][j] && (mat[i][j] == s.charAt(p)) ){
            marked[i][j] = true;
            return dfs(mat, i+1,j,p+1, clone(marked)) || dfs(mat, i-1,j,p+1, clone(marked)) || dfs(mat, i,j+1,p+1, clone(marked)) || dfs(mat, i,j-1,p+1, clone(marked));
        }

        return false;
    }

    public boolean[][] clone(boolean[][] markings){
        boolean[][] marked = new boolean[markings.length][markings[0].length];

        for (int i = 0; i < markings.length; i++) {
            for (int j = 0; j < markings[0].length; j++) {
                marked[i][j] = markings[i][j];
            }
        }

        return marked;
    }


    //p is pointer of String
    //ABCESEEEFS
    boolean dfs2(char[][] mat, int i, int j, int p, boolean[][] markings){//0,1,1
        boolean[][] marked = new boolean[markings.length][markings[0].length];

        for( int k = 0; k < markings.length; k++ ){
            marked[k] = markings[k].clone();
        }

        if( p >= s.length() ) return true;//
        if( i < 0 || i >= m || j < 0 || j >= n ) return false;

        if( !marked[i][j] && (mat[i][j] == s.charAt(p)) ){
            marked[i][j] = true;
            return dfs(mat, i+1,j,p+1, marked) || dfs(mat, i-1,j,p+1, marked) || dfs(mat, i,j+1,p+1, marked) || dfs(mat, i,j-1,p+1, marked);
        }

        return false;
    }

    //p is pointer of String
    //ABCESEEEFS
    boolean dfs3(char[][] mat, int i, int j, int p, boolean[][] marked){//0,1,1
        // boolean[][] marked = new boolean[markings.length][markings[0].length];

        // for( int k = 0; k < markings.length; k++ ){
        //     marked[k] = markings[k].clone();
        // }

        if( p >= s.length() ) return true;//
        if( i < 0 || i >= m || j < 0 || j >= n || marked[i][j] || mat[i][j] != s.charAt(p) ) return false;

        boolean res = false;

        marked[i][j] = true;
        res = dfs(mat, i+1,j,p+1, marked) || dfs(mat, i-1,j,p+1, marked) || dfs(mat, i,j+1,p+1, marked) || dfs(mat, i,j-1,p+1, marked);
        marked[i][j] = false;

        return res;
    }


}
