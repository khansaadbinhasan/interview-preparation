package leetcode.easy;

import java.util.*;

//"nlaebolko"
//"loonbalxballpoon"
//"leetcode"
//"balon"
//"bbbbnfmsnndnknlnlallllallalaojoajdhsodnonono"
public class L1189MaxBalloons {

    //     public int maxNumberOfBalloons(String text) {

//         int minCount = Integer.MAX_VALUE;

//         for(String c: "balon".split("")){

//             int count = 0;

//             while( text.contains(c) ) {

//                 text = text.replaceFirst(c,"");

//                 if( c.equals("l") && !c.contains("l") ) continue;
//                 if( c.equals("o") && !c.contains("o") ) continue;

//                 if( c.equals("l") || c.equals("o") ) {
//                     text = text.replaceFirst(c,"");
//                 }

//                 count++;
//             }

//             minCount = Math.min(minCount, count);
//         }

//         return minCount;
//     }


    public int maxNumberOfBalloons(String text) {

        Map<Character, Integer> hm = new HashMap<>();

        for( char c: text.toCharArray() ){

            int count = 1;

            if( hm.containsKey(c) ) count = hm.get(c) + 1;

            hm.put( c, count );
        }

        int min = Integer.MAX_VALUE;

        for( char c: "balon".toCharArray() ){

            if( !hm.containsKey(c) ) return 0;

            if( c == 'l' || c == 'o' ) hm.put(c, hm.get(c)/2);

            min = Math.min(min, hm.get(c));
        }

        return min;
    }


}
