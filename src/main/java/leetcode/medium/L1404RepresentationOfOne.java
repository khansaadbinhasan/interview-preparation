package leetcode.medium;

//"1101"
//"10"
//"1"
//"1010100101010"
//"1101001111111111111111111111111111111111111111111111111111111"
//"1010100100100000000000000001111111111110101010100111111111111111100000000000"
//"1111001100010000100110001100110000011101011110010001001100010000000111011110110110111101001110111100000101100001001000101010100001101111100110011110111110111010100011101101101101001110111110101100010101001100010101000111000011000000000100110001111101111001000000010010000110100101111001010101111100110111110101101111101111011010011111100011111001000110110011110111010101011110001101001110100001100111011000110000110001110111101110101111111001100101101010011111110100000010100"
public class L1404RepresentationOfOne {


    public int numSteps(String s) {
        int numSteps = 0;

        while( !isOne(s) ){
            if( isOdd(s) ) s = addOne(s);
            else s = rightShift(s);
            numSteps++;

        }

        return numSteps;
    }

    public String addOne(String s){
        int carry = 1;

        StringBuilder sb = new StringBuilder();

        for( int i = s.length()-1; i >= 0; i-- ){
            int sum = s.charAt(i)-'0' + carry;
            int dig = sum % 2;
            carry = (sum-dig)/2;
            sb.append(dig);
        }

        if( carry > 0 ) sb.append(carry);

        return sb.reverse().toString();
    }

    public String rightShift(String s){
        return new StringBuilder(s).deleteCharAt(s.length()-1).toString();
    }

    public boolean isOne(String s){
        for( int i = 0; i < s.length()-1; i++ ){
            if( s.charAt(i) == '1' ) return false;
        }
        return isOdd(s);
    }

    public boolean isOdd(String s){
        return s.charAt(s.length()-1) == '1';
    }

}
