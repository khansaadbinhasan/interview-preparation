package leetcode.easy;

import java.util.*;

//3
//0
//1
//33
//22
//11
//5
//8
public class L119PascalTriangleII {

    public List<Integer> getRow(int rowIndex) {

        List<List<Integer>> pascalTriangleList = new LinkedList<>();

        List<Integer> pascalTriangle = new LinkedList<>();
        pascalTriangle.add(1);

        for(int i = 1; i <= rowIndex; i++ ){
            pascalTriangle = getPascalTriangle(pascalTriangle);
        }

        return pascalTriangle;
    }

    public List<Integer> getPascalTriangle(List<Integer> triangle){

        List<Integer> pascalTriangle = new LinkedList<>();

        pascalTriangle.add(1);

        for( int i = 1; i < triangle.size(); i++ ){
            pascalTriangle.add(triangle.get(i)+triangle.get(i-1));
        }

        pascalTriangle.add(1);

        return pascalTriangle;
    }
}
