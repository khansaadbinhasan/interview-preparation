package leetcode.easy;

//38
//0
//2147483647
//1
//2
//10
//112132223
//34444
public class L258AddDigits {

    public static void main(String[] args) {
        new L258AddDigits().run();
    }

    public void run(){
        System.out.println(addDigits(38));
        System.out.println(addDigits(0));
        System.out.println(addDigits(2147483647));
        System.out.println(addDigits(1));
        System.out.println(addDigits(2));
        System.out.println(addDigits(10));
        System.out.println(addDigits(112132223));
        System.out.println(addDigits(34444));
    }

    public int addDigits(int num) {

        int sum = 0;

        while( digitLen(sum) != 1 || sum == 0 ){
            sum = 0;
            while( num != 0 ){
                int dig = num % 10;

                sum += dig;
                num = num / 10;
            }

            num = sum;

            if( sum == 0 ) break;
        }


        return sum;

    }

    public int digitLen(int num){
        if( num == 0 ) return 1;

        int len = 0;

        while( num != 0 ){
            len++;
            num = num / 10;
        }

        return len;
    }

}
