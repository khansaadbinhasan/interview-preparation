package leetcode.easy;


import java.util.LinkedList;

//15
//5
//13
//11
//4
//5
//1
//1
//10
//13
//14
//23
//4
//23
//11
//10
public class L2651CalcDelayedArrivalTime {

    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }
}
