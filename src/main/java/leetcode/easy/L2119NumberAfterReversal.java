package leetcode.easy;

import org.junit.Assert;

//526
//1800
//0
public class L2119NumberAfterReversal {

    public static void main(String[] args) {
        new L2119NumberAfterReversal().run();
    }

    public void run(){
        Assert.assertFalse(isSameAfterReversals(526));
        Assert.assertFalse(isSameAfterReversals(1800));
        Assert.assertFalse(isSameAfterReversals(0));
        Assert.assertFalse(isSameAfterReversals(10));
    }

    public boolean isSameAfterReversals(int num) {

        int rev = reverse(num);
        int revRev = reverse(rev);


        return num == revRev;

    }

    public int reverse(int num){
        int reverse = 0;

        while( num != 0 ){
            int digit = num % 10;
            num = num / 10;

            reverse = reverse*10 + digit;
        }


        return reverse;

    }
}
