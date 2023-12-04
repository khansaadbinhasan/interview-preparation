package leetcode.easy;

import java.util.*;

//"aA"
//"aAAbbbb"
//"z"
//"ZZ"
//"a"
//"a"
//"a"
//"A"
public class L771JewelsAndStones {

    public int numJewelsInStones(String jewels, String stones) {

        Set<String> jewelSet = new HashSet<>(Arrays.asList(jewels.split("")));

        int count = 0;

        for( String stone: stones.split("") ){
            if( jewelSet.contains(stone) ) count++;
        }

        return count;
    }

}
