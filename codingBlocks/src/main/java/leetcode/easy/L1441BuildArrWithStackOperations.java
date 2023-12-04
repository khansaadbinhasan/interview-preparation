package leetcode.easy;

import java.util.*;

//[1,3]
//3
//[1,2,3]
//3
//[1,2]
//4
//[2,3,4]
//4

public class L1441BuildArrWithStackOperations {
    public List<String> buildArray(int[] target, int n) {

        int[] list = new int[n];

        List<String> operations = new LinkedList<>();

        int targetI = 0;

        for( int i = 0; i < list.length; i++ ){
            list[i] = i+1;

            if( list[i] > target[target.length-1] ) return operations;

            if( targetI < target.length && list[i] == target[targetI] ) {
                operations.add("Push");
                targetI++;
            }

            else {
                operations.add("Push");
                operations.add("Pop");
            }
        }

        return operations;

    }

}
