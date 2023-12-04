package leetcode.easy;

import java.util.*;

//[5,4,3,2,1]
//[10,3,8,9,4]
//[10,3,8,9,4,6767,2322,32]
//[0,10,18,17,16,1171]
//[0]
//[1,2]
//[1,2,3]
//[5,4,1,2]
public class L506RelativeRanks {

    public String[] findRelativeRanks(int[] score) {

        if( score.length == 1 ) return new String[]{"Gold Medal"};
        if( score.length == 2 ) {
            if( score[0] > score[1] ) return new String[]{"Gold Medal", "Silver Medal"};
            if( score[1] > score[0] ) return new String[]{"Silver Medal", "Gold Medal"};
        }

        Map<Integer, String> rankMap = new HashMap<>();

        Integer[] scoreSort = new Integer[score.length];

        for(int i = 0; i < score.length; i++ ){
            scoreSort[i] = score[i];
        }

        Arrays.sort(scoreSort, Comparator.reverseOrder());

        rankMap.put(scoreSort[0], "Gold Medal");
        rankMap.put(scoreSort[1], "Silver Medal");
        rankMap.put(scoreSort[2], "Bronze Medal");

        for( int i = 3; i < scoreSort.length; i++ ){
            rankMap.put(scoreSort[i], String.valueOf(i+1));
        }

        String[] relativeRanks = new String[score.length];

        for( int i = 0; i < score.length; i++ ){
            relativeRanks[i] = rankMap.get(score[i]);
        }

        return relativeRanks;

    }


}
