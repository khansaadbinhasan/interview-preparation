package arrays;

import java.util.Scanner;

public class SearchForLonelyElement {
    public static void main(String[] args) {
        new SearchForLonelyElement().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] inpArr = new int[N];

        for (int i = 0; i < N; i++) {
            inpArr[i] = sc.nextInt();
        }

        System.out.println(getLonelyElement(inpArr));
    }

    public int getLonelyElement(int[] array){

        int N = array.length;
        int originalN = N;
        int midIndex = N / 2;
        int init = 0;
        int end = N;

        while( midIndex != 0 && midIndex != originalN-1 ){

            if( midIndex == 1 || midIndex == originalN - 2 ){
                if( array[midIndex] == array[midIndex-1] ){
                    return array[midIndex+1];
                }

                else if (array[midIndex] == array[midIndex+1]){
                    return array[midIndex-1];
                }

                else {
                    return array[midIndex];
                }
            }

            if( midIndex % 2 == 0 ){
                if( array[midIndex] == array[midIndex-1] ){
//                    midIndex = (midIndex-2) / 2;
                    end = midIndex;
                    midIndex = (midIndex + init) / 2;
                }

                else if( array[midIndex] == array[midIndex+1] ){
                    init = midIndex;
                    midIndex = (midIndex+end) / 2 + 1;
                }

                else{
                    break;
                }
            }

            else{
                if( array[midIndex] == array[midIndex-1] ){
                    init = midIndex;
                    midIndex = (midIndex + end + 1) / 2;
                }

                else if( array[midIndex] == array[midIndex+1] ){
                    end = midIndex;
                    midIndex = (midIndex + init) / 2;
                }

                else{
                    break;
                }
            }

            N = N / 2;

        }

        return array[midIndex];
    }
}

// 11
// 1 1 2 2 4 4 5 7 7 8 8
// 1 1 2 2 3 5 5 6 6 9 9

//9
//1 1 2 2 4 4 5 5 6

//7
//7 7 10 11 11 12 12
//3 3 7 7 10 11 11