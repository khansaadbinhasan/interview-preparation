package leetcode.blind75;

public class L375GuessNumberII {

    public static void main(String[] args) {
        new L375GuessNumberII().run();
    }

    public void run(){
        System.out.println(getMoneyAmount(10));
    }

    int[][] money;

    public int getMoneyAmount(int n) {
        money = new int[n][n];
        return calculate(1, n);
    }

    public int calculate(int l, int r){
        if( money[l][r] != 0 ) return money[l][r];
        if( l >= r ) return 0;

        int minres = Integer.MAX_VALUE;

        for( int i = l; i <= r; i++ ){
            int res = i + Math.max(calculate(i+1, r), calculate(l,i-1));
            minres = Math.min(res, minres);
        }

        return money[l][r] = minres;
    }

}
