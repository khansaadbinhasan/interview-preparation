package leetcode.easy;

import org.junit.Assert;

//4325
//687
//98500
//20
//90000
//909090
//10
public class L2578SplitWithMinimumSum {

    public static void main(String[] args) {
        new L2578SplitWithMinimumSum().run();
    }

    public void run(){
        Assert.assertEquals(splitNum(4325), 59);
        Assert.assertEquals(splitNum(687), 75);
        Assert.assertEquals(splitNum(98500), 67);
        Assert.assertEquals(splitNum(20), 2);
        Assert.assertEquals(splitNum(9000), 9);
        Assert.assertEquals(splitNum(909090), 108);

        System.out.println("All tests passed");
    }

    public int splitNum(int num) {
        int[] numArr = new int[10];
        int newNum = num;

        while( newNum != 0 ){
            int digit = newNum % 10;
            numArr[digit]++;
            newNum = newNum / 10;
        }

        int num1 = 0;
        int num2 = 0;

        boolean fillFirst = true;

        for( int i = 0; i < numArr.length; i++ ){
            while( numArr[i] != 0 ){
                if( fillFirst ){
                    num1 = num1*10 + i;
                } else{
                    num2 = num2*10 + i;
                }

                numArr[i]--;
                fillFirst = !fillFirst;
            }
        }

        return num1 + num2;
    }
}
