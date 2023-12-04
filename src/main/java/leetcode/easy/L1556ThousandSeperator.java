package leetcode.easy;

//987
//1234
//2147483647
//978786
//0
//877675
//87878666
//1000000000
public class L1556ThousandSeperator {

    public static void main(String[] args) {
        new L1556ThousandSeperator().run();
    }

    public void run(){
        System.out.println(thousandSeparator(2147483647));
    }

    public String thousandSeparator(int n) {
        String num = String.valueOf(n);

        if( num.length() <= 3 ) return num;

        int size = num.length();
        for( int i = 3; i < size; i+=3 ){
            num = num.substring(0, size-i) + "." + num.substring(size-i);
        }

        return num;
    }
}
