package leetcode.easy;


//"6777133339"
//"2300019"
//"42352338"
public class L2264LargestGoodInteger {

    public String largestGoodInteger(String num) {

        String[] goodIntegers = new String[]{"999", "888", "777", "666", "555", "444", "333", "222", "111", "000"};


        for( int i = 0; i < goodIntegers.length; i++ ){
            if( num.contains(goodIntegers[i]) ) return goodIntegers[i];
        }

        return "";

    }

}
