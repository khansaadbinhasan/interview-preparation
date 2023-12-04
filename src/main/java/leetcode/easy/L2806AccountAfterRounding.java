package leetcode.easy;

//9
//15
//0
//100
//99
//1
//80
//51
public class L2806AccountAfterRounding {

    public int accountBalanceAfterPurchase(int purchaseAmount) {

        if( (purchaseAmount%10) < 5 ) purchaseAmount -= (purchaseAmount%10);
        else purchaseAmount += (10-purchaseAmount%10);


        return 100-purchaseAmount;
    }
}
