package leetcode.easy;

//3
//7
//8
//10
//0
//1000000000
//1
//10
//100
//999
//8787
//777787
//212122
//2334444
//34343434
//34441111
public class L1523CountOdds {

    public int countOdds(int low, int high) {

        if( low % 2 != 0 ) low--;
        if( high % 2 != 0 ) high++;

        return (high - low) / 2;
    }
}
