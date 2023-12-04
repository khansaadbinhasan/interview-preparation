package leetcode.easy;

//[[1,2,3],[3,2,1]]
//[[1,5],[7,3],[3,5]]
//[[2,8,7],[7,1,3],[1,9,5]]
//[[1]]
public class L1672RichestCustomerWealth {

    public int maximumWealth(int[][] accounts) {

        int maxWealth = -1;

        for( int i = 0; i < accounts.length; i++ ){

            int wealth = 0;

            for( int j = 0; j < accounts[i].length; j++ ){
                wealth += accounts[i][j];
            }

            maxWealth = Math.max(maxWealth, wealth);
        }

        return maxWealth;
    }

}
