package leetcode.easy;

//7
//14
//1
//200
//2
//8
//9
//18

public class L1688CountOfMatchesInTournament {

    public int numberOfMatches(int n) {

        int numMatches = 0;

        while( n != 1 ){
            if( isEven(n) ) {
                numMatches += n / 2;
                n = n / 2;
            }

            else{
                numMatches += (n-1) / 2;
                n = (n-1) / 2 + 1;
            }
        }


        return numMatches;
    }

    public boolean isEven(int n){
        return n % 2 == 0;
    }

}
