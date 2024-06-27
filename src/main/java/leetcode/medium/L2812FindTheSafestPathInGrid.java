package leetcode.medium;

import java.util.*;

//[[1,0,0],[0,0,0],[0,0,1]]
//[[0,0,1],[0,0,0],[0,0,0]]
//[[0,0,0,1],[0,0,0,0],[0,0,0,0],[1,0,0,0]]
//[[1]]
//[[0,1,1],[0,1,1],[0,1,1]]
//[[1,1],[1,1]]
//[[0,1,0,1],[1,0,1,0],[0,1,0,0],[1,0,0,1]]
//[[0,1,0,1,1,1,1,1,1,1],[1,0,1,0,0,0,0,0,0,0],[0,1,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,1,0,0,1],[0,0,0,0,0,0,1,0,0,1],[0,0,0,0,0,0,1,0,0,1],[0,0,0,0,0,0,1,0,0,1],[0,0,0,0,0,0,1,0,0,1],[0,0,0,0,0,0,1,0,0,1],[0,0,0,0,0,0,1,0,0,0]]
public class L2812FindTheSafestPathInGrid {
    public static void main(String[] args) {
        new L2812FindTheSafestPathInGrid().run();
    }

    private void run() {
        printArr();
        LinkedList<List<Integer>> gridList = new LinkedList<>();



        List<Integer> row1 = Arrays.asList(0,0,1);
        List<Integer> row2 = Arrays.asList(0,0,0);
        List<Integer> row3 = Arrays.asList(0,0,0);

        gridList.add(row1);
        gridList.add(row2);
        gridList.add(row3);

//        System.out.println(maximumSafenessFactor(gridList));


//                Arrays.asList(0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1)
//                Arrays.asList(0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1)
//                Arrays.asList(0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1)
//                Arrays.asList(0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1)
//                Arrays.asList(0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1)
//                Arrays.asList(0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1)
//                Arrays.asList(0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1)
//                Arrays.asList(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1)
//                Arrays.asList(1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1)
//                Arrays.asList(1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1)
//                Arrays.asList(1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0)
//                Arrays.asList(1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0)
//                Arrays.asList(1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0)
//                Arrays.asList(1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0)
//                Arrays.asList(1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0)
//                Arrays.asList(1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0)
//                Arrays.asList(1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0)
//                Arrays.asList(1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0)

    }

    public void printArr(){
        String s = "[[0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1],[0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1],[0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1],[0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1],[1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1],[1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1],[1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0],[1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0],[1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0],[1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0],[1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0],[1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0],[1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0]]";
        System.out.println(s.replaceAll("\\[","Arrays.asList(")
                .replaceAll("],","),").replaceAll("]]",""));
    }

    boolean[][] visited;
    List<List<int[]>> allPaths;

    public int maximumSafenessFactor(List<List<Integer>> gridList) {
        allPaths = new LinkedList<>();
        int[][] grid = new int[gridList.size()][gridList.get(0).size()];
        visited = new boolean[grid.length][grid[0].length];
        List<int[]> ones = new LinkedList<>();

        for( int i = 0; i < grid.length; i++ ){
            for( int j = 0; j < grid[i].length; j++ ){
                grid[i][j] = gridList.get(i).get(j);
                if( grid[i][j] == 1 ) ones.add(new int[]{i,j});
            }
        }

        int maxSafeness = 0;

        dfs(grid, 0, 0, new LinkedList<>());

        for( List<int[]> path: allPaths ){
            int safeness = 500;
            for( int[] coord: path ){
                safeness = Math.min(safeness, getSafeness(coord[0],coord[1], ones));
            }
            maxSafeness = Math.max(maxSafeness, safeness);
        }

        return maxSafeness;
    }

    public List<int[]> dfs(int[][] grid, int i, int j, List<int[]> paths){
        if( i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 1 || visited[i][j] )
        {
            return null;
        }

        if( grid[i][j] == 0 ) paths.add(new int[]{i,j});
        visited[i][j] = true;
        dfs(grid, i+1, j, new LinkedList<>(paths));
        dfs(grid, i-1, j, new LinkedList<>(paths));
        dfs(grid, i, j+1, new LinkedList<>(paths));
        dfs(grid, i, j-1, new LinkedList<>(paths));
        visited[i][j] = false;
        if( i == grid.length-1 && j == grid[i].length-1 ) allPaths.add(paths);

        return paths;
    }

    public int getSafeness(int i, int j, List<int[]> ones){
        int safeness = 500;
        for( int[] coord: ones ){
            safeness = Math.min(safeness, manhattan(i, j, coord[0], coord[1]));
        }
        return safeness;
    }

    public int manhattan(int i, int j, int a, int b){
        return Math.abs(i-a)+Math.abs(j-b);
    }
}
