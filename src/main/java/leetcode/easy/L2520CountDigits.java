package leetcode.easy;

//7
//121
//1248
//13
//27
//23
//1111
public class L2520CountDigits {

    public int countDigits(int num) {

        int newNum = num;
        int count = 0;

        while( newNum != 0 ){
            int digit = newNum % 10;
            newNum = newNum / 10;

            if( num % digit == 0 ){
                count++;
            }
        }

        return count;
    }
}
