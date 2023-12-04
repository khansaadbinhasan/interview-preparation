package leetcode.easy;

import java.util.*;

public class L202HappyNumbers {

    public boolean isHappy(int n) {
        List<Integer> array = arrayFromNum(n);

        return isOverHappy(array);
    }

    public boolean isOverHappy(List<Integer> array){

        if( array.size() == 1 ){
            if( array.get(0) == 1 || array.get(0) == 7 ) return true;
            else return false;
        }

        int newNum = sumOfSquares(array);
        List<Integer> newArr = arrayFromNum(newNum);

        return isOverHappy(newArr);
    }

    public int sumOfSquares(List<Integer> array){

        int newNum = 0;

        for (int i = 0; i < array.size(); i++) {
            newNum += array.get(i)*array.get(i);
        }

        return newNum;
    }

    public List<Integer> arrayFromNum(int N){
        List<Integer> array = new ArrayList<>();

        while( N != 0 ){
            array.add(N % 10);
            N = N / 10;
        }

        return array;
    }


}
