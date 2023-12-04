package leetcode.easy;


//"A"
//"AB"
//"ZY"
//"FXSHRXW"
//"FH"
//"JHYUU"
//"HJGG"
//"A"
//"Z"
//"JIHV"

public class L171ExcelSheetColumnNumber {

    public int titleToNumber(String columnTitle) {
        int n = 0;

        int lenMin1 = columnTitle.length()-1;

        for( int i = lenMin1; i >= 0; i-- ){
            n += (columnTitle.charAt(i) - 'A' + 1)*Math.pow(26, lenMin1 - i);
        }

        return n;
    }
}
