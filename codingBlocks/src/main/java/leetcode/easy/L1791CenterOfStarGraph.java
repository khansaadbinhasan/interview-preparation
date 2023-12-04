package leetcode.easy;

//[[1,2],[2,3],[4,2]]
//[[1,2],[5,1],[1,3],[1,4]]
public class L1791CenterOfStarGraph {

    public int findCenter(int[][] edges) {

        int center = -1;

        if( edges[0][0] == edges[1][0] ) center = edges[0][0];
        else if( edges[0][1] == edges[1][1] ) center = edges[0][1];
        else if( edges[0][1] == edges[1][0] ) center = edges[0][1];
        else if( edges[0][0] == edges[1][1] ) center = edges[0][0];

        return center;

    }

}
