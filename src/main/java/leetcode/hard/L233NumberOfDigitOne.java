package leetcode.hard;

//999
//99
//23
//33
//133
//5533
//13
//333

//99999
//99
//33
//44
//22
//9898989
//8734736
//1111111

//1212121
//1000000
//10000
//100
//0
//1010101
//1000011
public class L233NumberOfDigitOne {

    public static void main(String[] args) {
        new L233NumberOfDigitOne().run();
    }

    public void run(){
        System.out.println(countDigitOne(100));
    }

    public int countDigitOne(int n) {

        String num = String.valueOf(n);
        int res = 0;

        int k = num.length();
        for( int i = 0; i < num.length(); i++ ){
            if( num.charAt(i) >= '1'){
                res += dp(k-1-i) * (num.charAt(i)-'0') + Math.pow(10, k-1-i);
            }

            if( num.charAt(i) == '1' && i < num.length()-1 ){
                res += Integer.parseInt(num.substring(i+1)) + 1 - Math.pow(10, k-1-i);
            }
        }

        return res;
    }

    private double dp(int k){
        return k * Math.pow(10, k-1);
    }

}
