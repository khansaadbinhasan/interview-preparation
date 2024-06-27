package leetcode.medium;

//[2,3,1,6,7]
//[1,1,1,1,1]
//[1,2,3,4,5,98,7,8,9,5,77,3,76,2,2,3,5,6,7,8,1,2,3,4,5,1,2,3,4,5,98,7,8,9,5,77,3,76,2,2,3,5,6,7,8,98,7,8,9,5,77,3,76,2,2,3,5,6,7,8,1,2,3,4,5,98,7,8,9,5,77,3,76,2,2,3,5,6,7,8,1,2,3,4,5,98,7,8,9,5,77,3,76,2,2,3,5,6,7,8]
//[1]
//[1,1,1,1,1,1]
//[1,2,3,4,5,6]
//[1,1]
//[1,2]
public class L1422CountTripletXors {
    public int countTriplets(int[] arr) {
        int[][] xor = new int[arr.length][arr.length];

        for( int i = 0; i < arr.length; i++ ){
            xor[i][i] = arr[i];
            for( int j = i+1; j < arr.length; j++ ){
                xor[i][j] = xor[i][j-1]^arr[j];
            }
        }

        int triplets = 0;

        for( int i = 0; i < arr.length; i++ ){
            for( int j = i; j < arr.length; j++ ){
                for( int k = j+1; k < arr.length; k++ ){
                    if( xor[i][j] == xor[j+1][k] ) triplets++;
                }
            }
        }

        return triplets;
    }
}
