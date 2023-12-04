package leetcode.easy;

//[5,5,5,10,20]
//[5,5,10,10,20]
//[10,10,20]
//[5]
//[10]
//[20]
//[5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,20,20,20,20,20,20,20,10,10,10,10,5]
//[5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,20,20,10,10,10,5]
public class L860Lemondaecahnge {

    public boolean lemonadeChange(int[] bills) {
        //number of 5, 10, 20
        int[] numChange = new int[3];

        for( int i = 0; i < bills.length; i++ ){
            if( bills[i] == 5 ) {
                numChange[0]++;
                continue;
            }

            numChange[bills[i]/10]++;

            if( !canFormNumber(numChange, bills[i]-5) ){
                return false;
            }
        }

        return true;
    }

    public boolean canFormNumber(int[] numChange, int num){
        int sum = 0;

        if( num >= 10 && numChange[1] >= 1){
            int num10s = num / 10;

            num -= 10;
            numChange[1]--;
        }

        if( num >= 5 ){
            int num5s = num / 5;

            if( numChange[0] >= num5s ){
                num -= 5 * num5s;
                numChange[0] -= num5s;
            }
        }

        return num == 0;
    }


}
