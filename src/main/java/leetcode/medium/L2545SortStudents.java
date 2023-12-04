package leetcode.medium;

import java.util.*;

//[[10,6,9,1],[7,5,11,2],[4,8,3,15]]
//2
//[[3,4],[5,6]]
//0
public class L2545SortStudents {

    public int[][] sortTheStudents(int[][] score, int k) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        Map<Integer, int[]> map = new HashMap<>();

        for( int i = 0; i < score.length; i++ ){
            maxHeap.add(score[i][k]);
            map.put(score[i][k], score[i]);
        }

        for( int i = 0; i < score.length; i++ ){
            score[i] = map.get(maxHeap.poll());
        }

        return score;
    }


}
