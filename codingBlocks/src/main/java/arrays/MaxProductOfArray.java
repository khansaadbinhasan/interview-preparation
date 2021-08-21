package arrays;

import java.util.Scanner;

//9
//-2 4 -5 6 0 5 -5 -2000 -1000
//7
//-2 4 -5 6 0 5 -5
//1
//1
//1
//-1
//5
//-1 -2 -3 -4 -5
//2
//100 -1
//2
//0 0
//3
//0 10 0
//3
//-2 0 -1
//4
//2 3 -2 4
//3
//7 -2 -4
//3
//0 -2 0


public class MaxProductOfArray {

    public static void main(String[] args) {
        new MaxProductOfArray().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(getMaxProduct(arr));
    }

    public int getMaxProduct(int[] arr){

        //special cases
        if( arr[0] <= 0 && arr.length > 3)
        {
            int len0 = 0;

            for( int i = 1; i < arr.length-1; i++ ){
                if( arr[i-1] == 0 && arr[i] <= 0 && arr[i+1] == 0 ) len0++;
                else if( arr[i-1] <= 0 && arr[i] == 0 && arr[i+1] <= 0 ) len0++;
            }

            if( len0 == arr.length - 2 ) return 0;
        }


        if( arr.length <= 3 ){

            if( arr.length == 3 )
                if( arr[0] <= 0 && arr[1] <= 0 && arr[2] <= 0)
                    if( arr[1] == 0 || (arr[0] == 0 && arr[2] == 0)) return 0;

            if( arr.length == 2 )
                if( arr[0] <= 0 && arr[1] <= 0 )
                    if( arr[0] == 0 || arr[1] == 0 ) return 0;

            if( arr.length == 1 ) return arr[0];

        }



        int N = arr.length;

        int[] positiveProduct = new int[N];
        int[] negativeProduct = new int[N];

        if( arr[0] < 0 ){
            positiveProduct[0] = 1;
            negativeProduct[0] = arr[0];
        }

        else if( arr[0] > 0 ){
            positiveProduct[0] = arr[0];
            negativeProduct[0] = 1;
        }

        else if( arr[0] == 0 ){
            positiveProduct[0] = 1;
            negativeProduct[0] = 1;
        }

        int max = positiveProduct[0];

        for (int i = 1; i < N; i++) {
            if( arr[i] < 0 ){

                if(positiveProduct[i - 1] > 0 && negativeProduct[i - 1] < 0){
                    positiveProduct[i] = negativeProduct[i-1] * arr[i];
                    negativeProduct[i] = positiveProduct[i-1] * arr[i];
                }

                else if( positiveProduct[i-1] > 0 && negativeProduct[i-1] > 0 ){
                    positiveProduct[i] = 1;
                    negativeProduct[i] = positiveProduct[i-1] * arr[i];
                }
            }

            else if( arr[i] > 0 ){
                if(positiveProduct[i - 1] > 0 && negativeProduct[i - 1] < 0){
                    positiveProduct[i] = positiveProduct[i-1] * arr[i];
                    negativeProduct[i] = negativeProduct[i-1] * arr[i];
                }

                else if( positiveProduct[i-1] > 0 && negativeProduct[i-1] > 0 ){
                    positiveProduct[i] = positiveProduct[i-1] * arr[i];
                    negativeProduct[i] = 1;
                }
            }

            else if( arr[i] == 0 ){
                positiveProduct[i] = 1;
                negativeProduct[i] = 1;
            }

            if( positiveProduct[i] > max ) max = positiveProduct[i];
        }

        return max;
    }

}
