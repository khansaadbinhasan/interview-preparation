package leetcode.easy;

import java.util.*;

//"III"
//"IV"
//"IX"
//"LVIII"
//"MCMXCIV"
//"I"
//"V"
//"IV"
//"XXX"
//"CM"

public class L13RomanToInteger {
    public int romanToInt(String s) {

        s = s.replaceAll("IV", "_4_");
        s = s.replaceAll("IX", "_9_");
        s = s.replaceAll("XL", "_40_");
        s = s.replaceAll("XC", "_90_");
        s = s.replaceAll("CD", "_400_");
        s = s.replaceAll("CM", "_900_");
        s = s.replaceAll("I", "_1_");
        s = s.replaceAll("V", "_5_");
        s = s.replaceAll("X", "_10_");
        s = s.replaceAll("C", "_100_");
        s = s.replaceAll("L", "_50_");
        s = s.replaceAll("D", "_500_");
        s = s.replaceAll("M", "_1000_");

        String[] numsStrArr = s.split("_");

        int ans = 0;

        for( String numStr: numsStrArr ){
            if( !numStr.isEmpty() ) ans += Integer.valueOf(numStr);
        }

        return ans;

    }

}
