package leetcode.medium;

import java.util.*;

//[[1,2],[2,3],[3,4],[1,3]]
//[[1,2],[1,2],[1,2]]
//[[1,2],[2,3]]
//[[1,2]]
//[[1,2],[2,3],[3,4],[5,6],[1,10],[2,5],[3,7]] → 3
public class L435NonOverlappingIntervals {

    //[[1,2],[2,3],[3,4],[1,3]]
//[[1,2],[1,3],[2,3],[3,4]] → First two intervals and check which has higher end, remove that one
//[[1,2],[2,3],[3,4]]
//
//[[1,2],[1,2],[1,2]]
//[[1,2]]
//
//
//[[1,2],[2,3]]
//
//[[a1, a2], [b1,b2]]
//
//sort intervals by initial value
//
//if( overlap(a,b) ){
//	if( a2 > b2 ) remove a
//	else remove b
//}
//
//
//[[1,2],[2,3],[3,4],[5,6],[1,10],[2,5],[3,7]] → 3
//
//[[1,2],[1,10],[2,3],[2,5],[3,4],[3,7],[5,6]]
//[[1,2],[2,3],[2,5],[3,4],[3,7],[5,6]] → 1
//[[1,2],[2,3],[3,4],[3,7],[5,6]] → 2
//[[1,2],[2,3],[3,4],[5,6]] → 3
//
//[[1,2]]
//
//
////handle case with 1 interval
//
////[[1,2],[2,3]] → pass
////[_,_,p1]
////[[1,2],[1,2],[1,2]] → pass
////[[1,2],[2,3],[3,4],[1,3]] →
    public int eraseOverlapIntervals(int[][] intervals) {
        //No overlap possible
        if( intervals.length == 1 ) return 0;

        //Sort the array basis the starting of interval
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] i1, int[] i2){
                return i1[0]-i2[0];
            }
        });

        int p1 = 0;//2
        int p2 = 1;//3
        int numIntervals = 0;//2


        //[-1, p1, -1, -1, p2, 1, 1]
        while( p1 < p2 && p2 < intervals.length ){
            if( overlap(intervals[p1], intervals[p2]) ){
                if( intervals[p1][1] > intervals[p2][1] ){
                    p1=p2;
                }

                p2++;
                numIntervals++;
                continue;
            }

            p1=p2;
            p2++;
        }

        return numIntervals;
    }

    //i1 = [1,5] and i2 = [2,4]
    //[1,2], [2,3]
    //[[1,2],[1,2],[1,2]]
    //[[1,2],[1,3],[2,3],[3,4]]
    //Returns true if interval i1 overlaps with interval i2
    //i1 starting is lesser or equal than i2 starting
    public boolean overlap(int[] i1, int[] i2){
        return i1[1] > i2[0];
    }

}
