package leetcode.medium;

//["011001","000000","010100","001000"]
//["000","111","000"]
//["1"]
//["111111","111111","111111","111111"]
//["111111","000000","000000","111111"]
//["111111","000000","111111","000000","111111"]
public class L2125NumberOfLasersInABank {

    public int numberOfBeams(String[] bank) {

        int numBeans = 0;

        int num1s1 = 0;
        int num1s2 = 0;

        int j = 0;
        while( j < bank.length && num1s1 == 0 ){
            num1s1 = getNum1s(bank[j]);
            j++;
        }

        for( int i = j; i < bank.length; i++ ){
            num1s2 = 0;
            if( i < bank.length ) num1s2 = getNum1s(bank[i]);
            i++;

            while( i < bank.length && num1s2 == 0 ){
                num1s2 = getNum1s(bank[i]);
                i++;
            }

            numBeans += num1s1*num1s2;
            if( num1s2 > 0 ){
                num1s1 = num1s2;
            }

            i--;
        }

        return numBeans;

    }

    public int getNum1s(String bin){
        int count = 0;

        for( int i = 0; i < bin.length(); i++ ){
            if( bin.charAt(i) == '1' ) count++;
        }

        return count;
    }


}
