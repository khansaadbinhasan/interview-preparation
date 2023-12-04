package leetcode.medium;

import java.util.*;

//[[10,20],[30,200],[400,50],[30,20]]
//[[259,770],[448,54],[926,667],[184,139],[840,118],[577,469]]
//[[515,563],[451,713],[537,709],[343,819],[855,779],[457,60],[650,359],[631,42]]
public class L1029TwoCitySched {

    public static void main(String[] args) {
        new L1029TwoCitySched().run();
    }

    public void run(){
        System.out.println(twoCitySchedCost(new int[][]{{10,20},{30,200}, {400,50}, {30,20}}));
    }

    public int twoCitySchedCost(int[][] costs) {

        int[] diff = new int[costs.length];
        int totalCost = 0;

        for( int i = 0; i < costs.length; i++ ){
            diff[i] = costs[i][1] - costs[i][0];
            totalCost += costs[i][0];
        }

        Arrays.sort(diff);

        for( int i = 0; i < diff.length/2; i++ ){
            totalCost += diff[i];
        }

        return totalCost;

    }

}
