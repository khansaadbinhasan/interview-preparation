package leetcode.medium;

//3
//0
//1
//10
//100
//1000000000
public class L319BulbSwitcher {
    public int bulbSwitch(int n) {

        int k = 0;

        for( int i = 1; i*i <= n; i++ ){
            k++;
        }

        return k;
    }
}
