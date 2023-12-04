package leetcode.easy;

import java.util.Arrays;

//[3,1,5]
//[2,7,4]
//[4,1,5,9]
//[1,3,2,6]
//[2,2,6,6]
//[1,3,2,6]
public class L2370MinMovesToSeat {

    public int minMovesToSeat(int[] seats, int[] students) {

        Arrays.sort(seats);
        Arrays.sort(students);

        int minMoves = 0;

        for(int i = 0; i < seats.length; i++){
            minMoves += Math.abs(seats[i]-students[i]);
        }

        return minMoves;

    }

}
