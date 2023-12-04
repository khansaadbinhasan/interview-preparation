package leetcode.easy;

import java.util.*;

//192
//100
//231
//555
//777
//543
//321
//987
public class L2729CheckIfNumberIsFascinating {

    public boolean isFascinating(int n) {

        int n2 = 2*n;
        int n3 = 3*n;

        String num = n + "" + n2 + "" + n3;

        if( num.length() != 9 ) return false;

        Set<Integer> digs = new HashSet<>();

        for( int i = 0; i < num.length(); i++ ){
            int dig = num.charAt(i)-'0';
            if( dig != 0 ){
                digs.add(dig);
            }
        }

        return digs.size() == 9;
    }
}
