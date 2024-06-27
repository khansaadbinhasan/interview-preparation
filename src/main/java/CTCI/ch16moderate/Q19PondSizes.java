package CTCI.ch16moderate;

import java.util.*;

public class Q19PondSizes {

    public static void main(String[] args) {
        new Q19PondSizes().run();
    }

    public void run(){
        int[][] plot = {
                {0, 2, 1, 0},
                {0, 1, 0, 1},
                {1, 1, 0, 1},
                {0, 1, 0, 1}
        };
        System.out.println(pondSizes(plot));
    }

    private List<Integer> pondSizes(int[][] plot) {
        List<Integer> ponds = new LinkedList<>();

        for (int i = 0; i < plot.length; i++) {
            for (int j = 0; j < plot[i].length; j++) {
                Integer pondLen = makePond(plot, i, j, 0);
                if( pondLen > 0 ) ponds.add(pondLen);
            }
        }

        return ponds;
    }


    private Integer makePond(int[][] plot, int i, int j, int pondLen){
        if( i >= plot.length || i < 0 || j >= plot[i].length || j < 0 ) return pondLen;
        if( plot[i][j] != 0 ) return pondLen;

        plot[i][j] = -1;
        pondLen = makePond(plot, i+1, j, pondLen);
        pondLen = makePond(plot, i-1, j, pondLen);
        pondLen = makePond(plot, i, j+1, pondLen);
        pondLen = makePond(plot, i, j-1, pondLen);
        pondLen = makePond(plot, i+1, j+1, pondLen);
        pondLen = makePond(plot, i-1, j-1, pondLen);
        pondLen = makePond(plot, i-1, j+1, pondLen);
        pondLen = makePond(plot, i+1, j-1, pondLen);

        return pondLen+1;
    }

}
