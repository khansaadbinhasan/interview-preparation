package leetcode.easy;


//"11"
//"123"
//"456"
//"77"
//"0"
//"0"
//"9"
//"9"
//"9898787686786786"
//"1"
//"99999999999999999999999999999999999"
//"99999999999999999999999999999999999"
//"999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999"
//"1"
//"198987876867867869898787686786786989878768678678698987876867867869898787686786786"
//"98987876867867869898787686786786989878768678678698987876867867869898787686786786"
public class L415AddStrings {

    public String addStrings(String num1, String num2) {

        int i = num1.length()-1;
        int j = num2.length()-1;
        int carry = 0;
        StringBuilder num = new StringBuilder();

        while( (i >= 0) && (j >= 0) ){
            int sum = num1.charAt(i)-'0' + num2.charAt(j)-'0' + carry;

            carry = 0;
            if( sum > 9 ) carry = 1;

            num.append(sum%10);

            i--;
            j--;
        }

        while( i >= 0 ){
            int sum = num1.charAt(i)-'0' + carry;

            carry = 0;
            if( sum > 9 ) carry = 1;

            num.append(sum%10);

            i--;
        }

        while( j >= 0 ){
            int sum = num2.charAt(j)-'0' + carry;

            carry = 0;
            if( sum > 9 ) carry = 1;

            num.append(sum%10);

            j--;
        }

        if( carry == 1 ) num.append(1);

        return num.reverse().toString();
    }
}
