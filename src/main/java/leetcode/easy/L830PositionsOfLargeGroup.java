package leetcode.easy;

import java.util.*;

//"abbxxxxzzy"
//"abc"
//"abcdddeeeeaabbbcd"
//"aaaaaaaaaaaaaaaaaaaaa"
//"addddddddddddbcccccccccbbbbbbbbbbbbcccccccbcbcbbcbcbcbcbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbccccccccccc"
//"a"
//"abcccdcddcdcdfafdsafdasfasdfasdsjkfhadsjfghjkaedsghfjksadgfjeqwghfgdashjfgasjkdfghdasjkh"
//"dsjkfajdskfhkjshfjkdshfjkshadfjkjfhdjshfdhhdhdhhdhdhhdhdgdshgfdhgsfahsgdfhgsdhafasgdhggdggsgsggsgsggggggggsgsfdftttyybbbgvgvgvgfd"
public class L830PositionsOfLargeGroup {

    public List<List<Integer>> largeGroupPositions(String s) {

        List<List<Integer>> pos = new LinkedList<>();

        for( int i = 0; i < s.length(); i++ ){
            for( int j = i+1; j < s.length(); j++ ){
                int oldJ = j;
                while( (j < s.length()) && (s.charAt(i) == s.charAt(j)) ) j++;

                if( j != oldJ ) {
                    j--;
                }

                if( isLargeGroup(s.substring(i,j+1)) ){
                    pos.add(Arrays.asList(i,j));
                    i = j;
                }
            }
        }


        return pos;
    }

    public boolean isLargeGroup(String s){
        for( int i = 1; i < s.length(); i++ ){
            if( s.charAt(i) != s.charAt(i-1) ) return false;
        }

        return s.length() >= 3;
    }

}
