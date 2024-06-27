package leetcode.easy;


//20
//3
//16
//2
//1
//2
//100
//3
//100
//30
//200
//2
//200
//29
//192
//24
//192
//23
//192
//25
//17
//2
public class L2591DistributeMoneyToMaximumChildren {

    public int distMoney(int money, int children) {
        if( children == 1 ) return money == 8 ? 1:0;
        if( money < children ) return -1;
        money -= children;
        int maxChilds = money/7;

        if( 1.0*money/7 > children ) return children-1;
        if( maxChilds == children ) return children;
        if( money % 7 == 3 && maxChilds == children-1) return maxChilds-1;

        return maxChilds;
    }

}
