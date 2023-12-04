package leetcode.easy;

//[[5,8],[3,9],[5,12],[16,5]]
//[[2,3],[3,7],[4,3],[3,7]]
public class L1729NumberOfSquaresRectangles {

    public int countGoodRectangles(int[][] rectangles) {

        int[] sqrLens = new int[rectangles.length];
        int maxLen = 0;

        for(int i = 0; i < rectangles.length; i++){
            sqrLens[i] = Math.min(rectangles[i][0], rectangles[i][1]);
            maxLen = Math.max(maxLen, sqrLens[i]);
        }


        int count = 0;

        for( int i = 0; i < sqrLens.length; i++ ){
            if( sqrLens[i] == maxLen ) count++;
        }

        return count;
    }
}
