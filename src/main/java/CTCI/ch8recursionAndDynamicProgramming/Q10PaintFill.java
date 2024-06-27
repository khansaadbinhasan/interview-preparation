package CTCI.ch8recursionAndDynamicProgramming;

import java.util.Arrays;

public class Q10PaintFill {

    public static void main(String[] args) {
        new Q10PaintFill().run();
    }

    public void run(){
//        int[][] colors = new int[][]{
//                {1,1,1},
//                {1,1,0},
//                {1,0,1},
//        };
//        fill(colors, 0, 0, 2, 1);

        int[][] colors = new int[][]{
                {0,0,0},
                {0,0,0},
                {0,0,0}
        };
        fill(colors, 0, 0, 0, 0);

        for( int i = 0; i < colors.length; i++ ){
            System.out.println(Arrays.toString(colors[i]));
        }
    }

    public void fill(int[][] colors, int x, int y, int color, int startColor){
        if( x < 0 || y < 0 || x == colors.length || y == colors[0].length ) return;

        if( colors[x][y] != startColor || colors[x][y] == color ) return;

        colors[x][y] = color;

        fill(colors, x+1, y, color, startColor);
        fill(colors, x-1, y, color, startColor);
        fill(colors, x, y+1, color, startColor);
        fill(colors, x, y-1, color, startColor);
    }

}
