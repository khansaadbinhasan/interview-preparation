package codingBlocks.arrays;

import java.util.*;

public class MaxSumSubArray {

    public static void main(String[] args) {
        run();
    }

    public static void run(){
        Scanner sc = new Scanner(System.in);


        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            List<Integer> array = new ArrayList<>();

            for (int j = 0; j < N; j++) {
                array.add(sc.nextInt());
            }

//            System.out.println(maxSumSubArrSum(array));
            System.out.println(maxSumSubArrSumUsingKadandesAlgo(array));
        }

    }

    public static int maxSumSubArrSumUsingKadandesAlgo(List<Integer> array){

        if( array.size() == 0 ){
            return -1;
        }

        int maxSum = 0;

        for (int i = 0; i < array.size(); i++) {
            maxSum = max(array.get(i), array.get(i) + maxSum);
            array.set(i, maxSum);
//            System.out.println(maxSum + " " + array);
        }

        return maxOfArray(array);

    }

    public static int maxSumSubArrSum(List<Integer> array){
        int leftInit = firstPosNumInd(array);
        int rightInit = firstPosNumFromBackInd(array);

        int left = leftInit;
        int right = rightInit;

        if( left == -1 && right == -1 ){
            return maxOfArray(array);
        }

        if( left == right ){
            return array.get(left);
        }


        int sum = getSum(left,right,array);

        while( left != right ){
            sum = max(getSum(left+1, right, array), sum);
            left++;
        }

        left = leftInit;
        right = rightInit;

        while( left != right ){
            sum = max(getSum(left, right-1, array), sum);
            right--;
        }

        return sum;
    }

    public static int firstPosNumInd(List<Integer> array){
        for (int i = 0; i < array.size(); i++) {
            if( array.get(i) > 0 )
                return i;
        }

        return -1;
    }

    public static int firstPosNumFromBackInd(List<Integer> array){
        for (int i = array.size()-1; i > 0; i--) {
            if( array.get(i) > 0 )
                return i;
        }

        return -1;
    }

    public static int maxOfArray(List<Integer> array){
        int maxNum = array.get(0);

        for (int i = 0; i < array.size(); i++) {
            if( array.get(i) > maxNum ){
                maxNum = array.get(i);
            }
        }

        return maxNum;
    }

    public static int max(int num1, int num2){
        if( num1 > num2 ){
            return num1;
        }

        return num2;
    }

    public static int getSum(int left, int right, List<Integer> array){
        int sum = 0;

        for (int i = left; i <= right; i++) {
            sum += array.get(i);
        }

        return sum;
    }

}

