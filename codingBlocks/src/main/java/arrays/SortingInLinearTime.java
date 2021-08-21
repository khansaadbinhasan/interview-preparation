package arrays;

import java.util.Scanner;

//2 0 2 1 1 0
//2 2 2 2 2
//0 0 0 1 2 0
//1 2 2 1 1 0
//1 1 1 2
//1
//2
//0

public class SortingInLinearTime {

    public static void main(String[] args) {
        new SortingInLinearTime().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

//        sortColors(nums);
//
//        for(int i = 0; i < nums.length; i++){
//            System.out.print(nums[i] + " ");
//        }
//
//        System.out.println();

        sortColorsThreePointers(nums);

        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }

        System.out.println();
    }

    public void sortColors(int[] nums) {
        int[] colorArr = new int[3];

        for (int i = 0; i < nums.length; i++) colorArr[nums[i]]++;

        int n = 0;

        for (int i = 0; i < colorArr.length; i++) {
            if( colorArr[i] == 0 ) continue;

            for (int j = 1; j <= colorArr[i]; j++) {
                nums[n] = i;
                n++;
            }
        }
    }

    public void sortColorsThreePointers(int[] nums){

        int left = 0;
        int right = nums.length - 1;
        int center = 0;

        while( center <= right ){

            if( nums[center] == 0 ){
                swap(nums, left, center);
                left++; center++;
            }

            else if( nums[center] == 2 ){
                swap(nums, center, right);
                right--;
            }

            else if( nums[center] == 1 ){
                center++;
            }
        }
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
