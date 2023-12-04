package leetcode.easy;


//[[1,1,1],[1,1,0],[1,0,1]]
//1
//1
//2
//[[0,0,0],[0,0,0]]
//0
//0
//0
//[[1,2,1],[3,1,3],[1,1,1]]
//1
//1
//2
//[[1,2,3],[3,2,3],[1,2,1]]
//1
//1
//5
public class L733FloodFill {

    public static void main(String[] args) {
        new L733FloodFill().run();
    }

    public void run(){
        int[][] ans = floodFill(new int[][]{{1,1,1},{1,1,0},{1,0,1}}, 1, 1, 2);

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }

            System.out.println();
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color){
        int[][] copiedImage = new int[image.length][image[0].length];

        for (int i = 0; i < image.length; i++) {
            copiedImage[i] = image[i].clone();
        }

        return floodFill(image, copiedImage, sr, sc, color);
    }

    public int[][] floodFill(int[][] image, int[][] copiedImage, int sr, int sc, int color) {

        if( sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length ) return copiedImage;

        if( sr + 1 < image.length && image[sr+1][sc] == image[sr][sc] && copiedImage[sr+1][sc] != color ) {
            copiedImage[sr+1][sc] = color;
            floodFill(image, copiedImage, sr+1, sc, color);
        }

        if( sr - 1 >= 0 && image[sr-1][sc] == image[sr][sc] && copiedImage[sr-1][sc] != color ) {
            copiedImage[sr-1][sc] = color;
            floodFill(image, copiedImage, sr-1, sc, color);
        }

        if( sc + 1 < image[0].length && image[sr][sc+1] == image[sr][sc] && copiedImage[sr][sc+1] != color ) {
            copiedImage[sr][sc+1] = color;
            floodFill(image, copiedImage, sr, sc+1, color);
        }

        if( sc - 1 >= 0 && image[sr][sc-1] == image[sr][sc] && copiedImage[sr][sc-1] != color ) {
            copiedImage[sr][sc-1] = color;
            floodFill(image, copiedImage, sr, sc-1, color);
        }

        copiedImage[sr][sc] = color;

        return copiedImage;

    }
}
