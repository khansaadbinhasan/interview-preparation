package leetcode.easy;

import java.util.*;

//[3,6],[1,5],[4,7]]
//[[1,3],[5,8]]
//[[1,4]]
//[[1,3],[3,4]]
//[[28,88],[9,88],[52,100],[4,86],[26,70],[43,81],[66,94],[15,74],[10,15],[17,54],[65,73],[70,100],[4,61],[78,93],[78,95],[42,59],[99,100],[78,97],[39,72],[2,83],[23,54],[14,94],[50,59],[43,56],[50,80],[57,75],[59,75],[50,59],[83,85],[82,99],[38,75],[49,51],[17,27],[69,96],[1,13],[1,84],[14,68],[23,36],[7,41],[72,80],[2,4],[17,53],[54,82],[10,83]]
public class L2848PointsIntersectWithCars {

    public int numberOfPoints(List<List<Integer>> nums) {

        int[] freqArr = new int[101];

        for( List<Integer> car: nums ){
            for( int i = car.get(0); i <= car.get(1); i++ ){
                freqArr[i] = 1;
            }
        }

        int sum = 0;

        for( int i = 0; i < freqArr.length; i++ ){
            sum += freqArr[i];
        }

        return sum;

    }
}
