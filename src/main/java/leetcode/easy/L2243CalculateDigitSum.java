package leetcode.easy;

//"11111222223"
//3
//"00000000"
//3
//"123456789"
//2
//"12345678"
//10
//"12345678"
//4
//"12345678"
//7
public class L2243CalculateDigitSum {


    public String digitSum(String s, int k) {
        while( s.length() > k ){
            String digitSum = "";
            for( int i = 0; i < s.length(); i += k ){
                if( i + k >= s.length() ){
                    digitSum += digitSum(s.substring(i));
                    break;
                }

                digitSum += digitSum(s.substring(i, i+k));
            }

            s = digitSum;
        }

        return s;
    }

    public String digitSum(String s){
        int sum = 0;

        for( String dig: s.split("") ){
            sum += Integer.valueOf(dig);
        }

        return String.valueOf(sum);

    }

}
