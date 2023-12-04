package leetcode.easy;

//"dfa12321afd"
//"abc1111"
//"12345679"
//"99"
//"ajdkfhjkdshfjkldshjkfhsdjkfhsdkf099877665dssdf6666fdasf666d6d6d6d66d6d55d44d4d0000"
//"1"
//"12"
//"abc"
public class L1796SecondLargestDigitInString {

    public int secondHighest(String s) {

        int[] freqArr = new int[10];

        for( int i = 0; i < s.length(); i++ ){
            if( s.charAt(i) >= '0' && s.charAt(i) <= '9' ){
                freqArr[s.charAt(i)-'0'] = 1;
            }
        }

        boolean isSecondMax = false;

        for( int i = freqArr.length-1; i >= 0; i-- ){
            if( freqArr[i] == 1 ){
                if( isSecondMax ) return i;
                isSecondMax = true;
            }
        }

        return -1;
    }
}
