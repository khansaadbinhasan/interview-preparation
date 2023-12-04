package leetcode.easy;

//[[3,50],[7,10],[12,25]]
//10
//[[1,0],[4,25],[5,50]]
//2
//[[2,50]]
//0
public class L2303CalculateTaxesPaid {

    public double calculateTax(int[][] brackets, int income) {

        double tax = 0;
        int starting = 0;

        for( int i = 0; i < brackets.length; i++ ){
            int incomeBracket = Math.min(brackets[i][0], income) - starting;
            int percentTax = brackets[i][1];

            starting = brackets[i][0];

            tax += incomeBracket * ((double)percentTax)/100.0;

            if( brackets[i][0] >= income ) break;
        }


        return tax;
    }

}
