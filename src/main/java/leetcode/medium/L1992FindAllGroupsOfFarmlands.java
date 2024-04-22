package leetcode.medium;

import java.util.*;

//[[1,0,0],[0,1,1],[0,1,1]]
//[[1,1],[1,1]]
//[[0]]
//[[1]]
public class L1992FindAllGroupsOfFarmlands {
    public int[][] findFarmland(int[][] land) {

        List<int[]> lst = new LinkedList<>();

        for( int i = 0; i < land.length; i++ ){
            for( int j = 0; j < land[i].length; j++ ){
                if( land[i][j] == 1 ){
                    int[] coords = new int[]{i,j,i,j};

                    int currI = i;
                    int currJ = j;
                    while( currJ < land[currI].length && land[currI][currJ] == 1 ) currJ++;
                    if( currJ > j ) currJ--;
                    while( currI < land.length && land[currI][currJ] == 1 ) currI++;
                    if( currI > i ) currI--;

                    coords[2] = currI;
                    coords[3] = currJ;

                    lst.add(coords);
                    setToZero(land, coords);
                }
            }
        }

        int[][] coordArr = new int[lst.size()][4];

        int i = 0;

        for( int[] coord: lst ){
            coordArr[i++] = coord;
        }

        return coordArr;
    }

    public void setToZero(int[][] land, int[] coords){
        for( int i = coords[0]; i <= coords[2]; i++ ){
            for( int j = coords[1]; j <= coords[3]; j++ ){
                land[i][j] = 0;
            }
        }
    }

}
