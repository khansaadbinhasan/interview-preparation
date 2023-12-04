package leetcode.easy;

//2
//3
//10
//10
//0
//1
//0
//0
//100000
//1
public class L2169CountOperationToZero {

    public int countOperations(int num1, int num2) {

        int count = 0;

        while( num1 != 0 && num2 != 0 ){
            if( num1 > num2 ) {
                num1 = num1 - num2;
            }

            else{
                num2 = num2 - num1;
            }

            count++;
        }

        return count;
    }
}
