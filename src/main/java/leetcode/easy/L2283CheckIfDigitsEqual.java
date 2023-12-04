package leetcode.easy;

//"1210"
//"030"
//"123"
//"000"
//"012"
//"0"
//"1"
//"121000"
public class L2283CheckIfDigitsEqual {

    public boolean digitCount(String num) {
        int[] freqArr = new int[10];

        for( int i = 0; i < num.length(); i++ ){
            freqArr[num.charAt(i)-'0']++;
        }

        for( int i = 0; i < num.length(); i++ ){
            if( freqArr[i] != (num.charAt(i)-'0') ) return false;
        }

        return true;
    }

}
