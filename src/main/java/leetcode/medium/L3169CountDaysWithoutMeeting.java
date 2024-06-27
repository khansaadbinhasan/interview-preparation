package leetcode.medium;


import java.util.*;

//10
//[[5,7],[1,3],[9,10]]
//5
//[[2,4],[1,3]]
//6
//[[1,6]]
//100
//[[1,1]]
//1000
//[[1,100],[2,100],[100,1000]]
//100
//[[1,50],[51,100]]
//100
//[[1,50],[52,100]]
public class L3169CountDaysWithoutMeeting {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, new Comparator<int[]>(){
            @Override
            public int compare(int[] m1, int[] m2){
                return Integer.compare(m1[0], m2[0]);
            }
        });

        int start = meetings[0][0];
        int end = meetings[0][1];
        int count = 0;

        if( start > 1 ) count += start-1;


        for( int i = 1; i < meetings.length; i++ ){
            if( meetings[i][0] <= end ) end = Math.max(end, meetings[i][1]);
            else {
                count += (meetings[i][0]-end)-1;
                start = meetings[i][0];
                end = meetings[i][1];
            }
        }

        if( end < days ) count += days-end;

        return count;
    }

}
