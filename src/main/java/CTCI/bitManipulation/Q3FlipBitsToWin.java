package CTCI.bitManipulation;

import java.util.*;

public class Q3FlipBitsToWin {

    public static void main(String[] args) {
        new Q3FlipBitsToWin().run();
    }

    public void run(){
        System.out.println(longestSequence(71));
    }

    public int longestSequence(int num){

        List<Integer> lst = new ArrayList<>();

        int countZeros = 0;
        int countOnes = 0;


        while( num > 0 ){

            if( (num & 1) == 1 ) {

                if( countZeros > 0 ){
                    lst.add(-countZeros);
                    countZeros = 0;
                }

                countOnes++;
            }

            else {

                if( countOnes > 0 ){
                    lst.add(countOnes);
                    countOnes = 0;
                }

                countZeros++;
            }

            num = num >> 1;
        }

        if( countZeros > 0 ) lst.add(countZeros);
        if( countOnes > 0 ) lst.add(countOnes);

//        System.out.println(lst);

        int max = 0;

        for( int i = 0; i < lst.size(); i++ ){
            if( lst.get(i) > 0 ) {
                max = Math.max(max, lst.get(i)+1);
            }

            else if( lst.get(i) < 0 ) {
                if( Math.abs(lst.get(i)) == 1 ){
                    if( i > 0 && i < lst.size()-1 )
                        max = Math.max(max, lst.get(i-1) + 1 + lst.get(i+1));
                }
            }
        }

        return max;
    }

}
