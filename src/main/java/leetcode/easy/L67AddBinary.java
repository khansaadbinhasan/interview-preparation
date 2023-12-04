package leetcode.easy;


import org.junit.Assert;

//"11"
//"1"
//"1010"
//"1011"
//"1"
//"0"
//"1"
//"1"
//"11111111"
//"1111111"
//"111111111"
//"111111111"
//"10111101"
//"11111111100"
//"11111111111"
//"1"
public class L67AddBinary {

    public static void main(String[] args) {
        new L67AddBinary().run();
    }

    public void run(){
        Assert.assertEquals("100", addBinary("11", "1"));
        Assert.assertEquals(addBinary("0", "0"), "0");
        Assert.assertEquals(addBinary("1", "0"), "1");
        Assert.assertEquals(addBinary("1", "1"), "10");
        Assert.assertEquals("10101", addBinary("1010", "1011"));
        System.out.println("All tests passed");
    }

    public String addBinary(String a, String b) {

        String sum = a;

        if( b.length() > a.length() ) {
            sum = b;
            b = a;
        }

        return sumBits(sum, b, 0, 0);
    }

    public String sumBits(String sum, String b, int i, int carry){
        if( i >= b.length() ) {

            if( carry == 1 ){
                b = sum.replaceAll("1", "0");
                b = b.substring(0, b.length() - 1 - i) + "1" + b.substring(b.length() - i);

                return sumBits(sum, b, i, 0);
            }

            return sum;

        }

        int sumBit = sum.charAt(sum.length()-1-i) - '0';
        int bBit = b.charAt(b.length()-1-i) - '0';
        int sumBits = sumBit + bBit + carry;

        if( sumBits >= 2 ){
            carry = 1;

            if( sumBits == 2 ){
                sumBits = 0;
            }

            if( sumBits == 3 ){
                sumBits = 1;
            }
        }

        else{
            carry = 0;
        }

        sum = sum.substring(0, sum.length()-1-i) + sumBits + sum.substring(sum.length()-i);

        if( (i == (sum.length()-1)) && carry == 1 ){
            sum = "1" + sum;
            carry = 0;
        }

        return sumBits(sum, b, i+1, carry);
    }
}
