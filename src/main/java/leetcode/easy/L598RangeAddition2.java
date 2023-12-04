package leetcode.easy;

import java.math.BigInteger;

//3
//3
//[[2,2],[3,3]]
//3
//3
//[[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3]]
//3
//3
//[]
//4
//4
//[[1,1]]
//1
//1
//[[1,1]]
//20
//20
//[[1,10],[10,1],[11,19]]
//20
//20
//[[10,10],[10,11],[11,19],[8,17]]
public class L598RangeAddition2 {

    public int maxCount(int m, int n, int[][] ops) {

        int minX = m;
        int minY = n;


        for( int i = 0; i < ops.length; i++ ){
            minX = Math.min(minX, ops[i][0]);
            minY = Math.min(minY, ops[i][1]);
        }


        return minX*minY;

    }
}
