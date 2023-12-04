package leetcode.easy;


//[1,2,3]
//[2,2,2,3,3]
//[1,1000000000]
public class L1217MinCostToMoveChips {

    public int minCostToMoveChips(int[] position) {

        int numEven = 0;

        for( int pos: position ){
            if( pos % 2 == 0 ) numEven++;
        }

        return Math.min(numEven, position.length - numEven);
    }

}
