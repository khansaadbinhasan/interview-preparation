package leetcode.easy;


import java.util.*;

public class L401BinaryWatch {

    public List<String> readBinaryWatch(int turnedOn) {

        LinkedList<String> times = new LinkedList<>();

        for( int i = 0; i < 12; i++ ){
            for( int j = 0; j < 60; j++ ){
                if( get1Count(i) + get1Count(j) == turnedOn ){
                    times.add(i + ":" + pad(String.valueOf(j)));
                }
            }
        }

        return times;
    }

    public int get1Count(Integer bin){
        String binaryString = Integer.toBinaryString(bin);
        int originalCount = binaryString.length();
        int removedCount = binaryString.replace("1", "").length();

        return originalCount-removedCount;
    }

    public String pad(String s){
        while( s.length() != 2 ) s = "0" + s;

        return s;
    }
}
