package leetcode.easy;

import java.util.*;

//"B0B6G0R6R0R6G9"
//"B0R0G0R9R0B0G0"
//"G4"
public class L2103RingsAndRods {

    public int countPoints(String rings) {
        int totalPoints = 0;
        List<Set<String>> colors = new LinkedList<>();

        for( int i = 0; i < 10; i++ ){
            colors.add(new HashSet<>());
        }

        String[] ringArr = rings.split("");

        for( int i = 0; i < ringArr.length; i+=2 ){
            colors.get( Integer.parseInt(ringArr[i+1]) ).add(ringArr[i]);
        }

        for( Set<String> colorSet: colors ){
            if( colorSet.size() == 3 ) totalPoints++;
        }

        return totalPoints;
    }
}
