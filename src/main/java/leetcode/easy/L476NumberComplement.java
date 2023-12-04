package leetcode.easy;

//5
//1
//2147483647
public class L476NumberComplement {

    public int findComplement(int num) {

        String maxBin = "";

        int n = numBins(num);

        for( int i = 0; i < n; i++ ){
            maxBin += "1";
        }

        return Integer.valueOf(maxBin, 2) & ~num;
    }

    public int numBins(int num){

        int count = 0;

        while( num > 0 ){
            num = num >> 1;
            count++;
        }

        return count;
    }

}
