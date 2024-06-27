package leetcode.easy;

//"010"
//"0101"
//"00001"
//"10000"
//"010010010101111110"
public class L2864MaxOddBinNumber {
    public String maximumOddBinaryNumber(String s) {
        int num1s = 0;
        for( char c: s.toCharArray() ){
            if( c == '1' ) num1s++;
        }

        StringBuilder sb = new StringBuilder();

        for( int i = 0; i < num1s-1; i++ ){
            sb.append(1);
        }

        for( int i = 0; i < s.length()-num1s; i++ ){
            sb.append(0);
        }

        sb.append(1);

        return sb.toString();
    }
}
