package leetcode.easy;

import java.util.*;

//5
//1
//2
//3
//29
//26
//14
//12
//30

public class L118PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {

        if( numRows < 1 ) return new LinkedList<>();

        List<List<Integer>> pascalsTriangle = new LinkedList<>();

        List<Integer> currRow = new LinkedList<>();

        currRow.add(1);

        pascalsTriangle.add(currRow);

        for( int i = 2; i <= numRows; i++ ){

            List<Integer> lastRow = pascalsTriangle.get(pascalsTriangle.size()-1);
            currRow = new LinkedList<>();

            currRow.add(1);

            for( int j = 1; j < i-1; j++ ){
                currRow.add(lastRow.get(j-1)+lastRow.get(j));
            }

            currRow.add(1);

            pascalsTriangle.add(currRow);
        }

        return pascalsTriangle;

    }

}
