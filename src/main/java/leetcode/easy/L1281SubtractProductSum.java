package leetcode.easy;

//234
//4421
public class L1281SubtractProductSum {

    public int subtractProductAndSum(int n) {

        String[] numArr = String.valueOf(n).split("");

        int prod = 1;
        int sum = 0;

        for( String num: numArr ){
            prod *= Integer.valueOf(num);
            sum += Integer.valueOf(num);
        }

        return prod - sum;
    }


}
