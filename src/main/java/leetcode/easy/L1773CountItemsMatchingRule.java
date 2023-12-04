package leetcode.easy;

import java.util.*;

//[["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]]
//"color"
//"silver"
//[["phone","blue","pixel"],["computer","silver","phone"],["phone","gold","iphone"]]
//"type"
//"phone"

public class L1773CountItemsMatchingRule {

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {

        int ruleInd = -1;

        if( ruleKey.equals("type") ) ruleInd = 0;
        else if( ruleKey.equals("color") ) ruleInd = 1;
        else if( ruleKey.equals("name") ) ruleInd = 2;


        int count = 0;

        for( List<String> item: items ){
            if( item.get(ruleInd).equals(ruleValue) ) count++;
        }

        return count;
    }

}
