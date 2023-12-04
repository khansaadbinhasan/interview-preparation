package leetcode.easy;

import java.util.*;

public class L2194CellsInSheet {

    public static void main(String[] args) {
        new L2194CellsInSheet().run();
    }

    public void run(){
        System.out.println(cellsInRange("K1:L2"));
        System.out.println(cellsInRange("A1:F1"));
        System.out.println(cellsInRange("A1:Z9"));
    }

    public List<String> cellsInRange(String s) {

        String start = s.substring(0,2);
        String end = s.substring(3);

        List<String> cellList = new LinkedList<>();

        while( start.charAt(0) <= end.charAt(0) ){
            cellList.add(start);
            char number = start.charAt(1);
            while( number < end.charAt(1) ){
                number = (char) (number + 1);
                cellList.add(start.substring(0,1) + number);
            }
            start = (char) (start.charAt(0) + 1) + start.substring(1);
        }

        return cellList;
    }
}
