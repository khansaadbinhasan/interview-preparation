import java.util.*;


public class Experimenting {

    public static void main(String[] args) {
        new Experimenting().run();
    }

    public void run() {
        int[][] a = new int[][]{{5,6},{1,2},{3,4}};
        int[][] b = clone(a);

        update(a);

        System.out.println(b[0][0]);
    }

    public void update(int[][] a){
        a[0][0] = -1;
        a[0][1] = -1;
    }

    public int[][] clone(int[][] marked){
        int[][] a = new int[marked.length][marked[0].length];

        for (int i = 0; i < marked.length; i++) {
            for (int j = 0; j < marked[0].length; j++) {
                a[i][j] = marked[i][j];
            }
        }

        return a;
    }
}



