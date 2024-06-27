package leetcode.medium;

import java.util.*;

//10
//11
//20
//300
//20
//170
//20
//199
//20
//188
//20
//43
//20
//87
//10
//0
public class L464CanIWin {
    public boolean canIWin(int n, int k) {

        for( int i = 1; i <= n; i++ ){
            if( canIWin(n, k, new HashSet<>(), true, 0) ) return true;
        }

        return false;
    }

    public boolean canIWin(int n, int k, Set<Integer> taken, boolean turn, int sum){
        if( sum >= k ) return !turn;

        for( int i = 1; i <= n; i++ ){
            if( taken.contains(i) ) continue;
            sum += i;
            taken.add(i);
            if( sum >= k ) return turn;
            if( canIWin(n, k, taken, !turn, sum) ) return !turn;
        }

        return turn;
    }

    public static void main(String[] args) {
        new L464CanIWin().run();
    }

    public void run(){
        System.out.println(canIWin(20, 43));
    }
}
