package codingBlocks.arrays;

import java.util.*;

public class MajorityElements {
    public static void main (String args[]) {
        int N = 0;

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        int count1 = 0;
        int elem1 = 0;

        int count2 = 0;
        int elem2 = 0;

        int[] array = new int[N];

        for(int i = 0; i < N; i++){
            int inpElem = sc.nextInt();

            array[i] = inpElem;

            if( count1 == 0 ){
                elem1 = inpElem;
                count1++;
            }

            else if( elem1 == inpElem ){
                count1++;
            }

            else if( count2 == 0 ){
                elem2 = inpElem;
                count2++;
            }

            else if( elem2 == inpElem ){
                count2++;
            }

            else{
                count1--;
                count2--;
            }
        }


        int c1 = 0;
        int c2 = 0;

        for(int i = 0; i < N; i++){

            if( array[i] == elem1 ){
                c1++;
            }

            if( array[i] == elem2 ){
                c2++;
            }

        }

        int floorNBy3 = N / 3;

        if( c1 > floorNBy3 ){
            System.out.print(elem1);
        }

        if( c1 > floorNBy3 && c2 > floorNBy3 ){
            System.out.print(" ");
        }

        if( c2 > floorNBy3 ){
            System.out.print(elem2);
        }

        if( c1 < floorNBy3 && c2 < floorNBy3 ){
            System.out.print("No Majority Elements");
        }

    }
}