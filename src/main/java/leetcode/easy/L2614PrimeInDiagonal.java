package leetcode.easy;

//[[1,2,3],[5,6,7],[9,10,11]]
//[[1,2,3],[5,17,7],[9,11,10]]
//[[1]]
//[[1,2],[3,4]]
public class L2614PrimeInDiagonal {

    public int diagonalPrime(int[][] nums) {

        int maxPrime = 0;

        for( int i = 0; i < nums.length; i++ ){
            for( int j = 0; j < nums[i].length; j++ ){
                if( (i == j) || (i+j==nums.length-1) ){
                    if( isPrime(nums[i][j]) )
                        maxPrime = Math.max(maxPrime, nums[i][j]);
                }
            }
        }

        return maxPrime;
    }

    public boolean isPrime(int num){
        if( num < 2 ) return false;

        for( int i = 2; i <= Math.sqrt(num); i++ ){
            if( num % i == 0 ) return false;
        }

        return true;
    }
}
