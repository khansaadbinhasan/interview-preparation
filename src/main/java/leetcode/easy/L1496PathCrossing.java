package leetcode.easy;

import java.util.*;

//"NES"
//"NESWW"
//"NESW"
//"N"
//"E"
//"NSEWNWNWNWNWN"
//"NNNNNNNNNEEEEEEEESSSSSSSSSWW"
//"NNNNSSSS"
public class L1496PathCrossing {

    public boolean isPathCrossing(String path) {

        Set<String> pointSet = new HashSet<>();


        int i = 0;
        int j = 0;

        pointSet.add(i + "," + j);

        for( char dirn: path.toCharArray() ){
            if( dirn == 'N' ) j++;
            else if( dirn == 'S' ) j--;
            else if( dirn == 'E' ) i++;
            else if( dirn == 'W' ) i--;

            String point = i + "," + j;

            if( pointSet.contains(point) ) return true;

            pointSet.add(point);
        }

        return false;
    }

}
