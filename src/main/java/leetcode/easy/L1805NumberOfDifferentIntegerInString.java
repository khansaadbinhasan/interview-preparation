package leetcode.easy;

import java.util.*;

//"a123bc34d8ef34"
//"leet1234code234"
//"a1b01c001"
//"adfhjkda00987jdashfjha00998dfhkjdhf77adf6"
//"djkfh9898786"
//"000000000000"
//"a"
//"167278959591294"
public class L1805NumberOfDifferentIntegerInString {

    public int numDifferentIntegers(String word) {

        Set<String> ans = new HashSet<>();
        word = word.replaceAll("[a-z]", " ");

        for( String integer: word.split(" ") ){
            integer = integer.trim();

            if( integer.isEmpty() ) continue;

            int i = 0;

            while( i < integer.length() && integer.charAt(i) == '0' ){
                i++;
            }

            ans.add(integer.substring(i));
        }

        return ans.size();

    }
}
