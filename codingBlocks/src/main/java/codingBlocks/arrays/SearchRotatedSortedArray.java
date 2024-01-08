package codingBlocks.arrays;

import java.util.Scanner;

//1 --> 1
//1 2 3 4 5 6 7 --> 1,7,6,2
//4 5 6 1 2 3 --> 3,4,5,6
//5 7 8 9 1 --> 1,5,7
//4 5 6 7 8 1 --> 1,4,7,8
//9 10 11 12 13 14 1 2 3 4 5 6 7 8 --> 14,13,12,7,8,9

public class SearchRotatedSortedArray {

    public static void main(String[] args) {
        new SearchRotatedSortedArray().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        System.out.println(search(nums, target));
    }

    private int search(int[] nums, int target) {

        if( nums.length == 0 ) return -1;

        int start = 0;
        int end = nums.length - 1;
        int mid;
        int N = nums.length;

        while( start <= end ){
            mid = (start + end)/2;

            if( nums[mid] == target ) return mid;

            if( nums[mid] > nums[N-1] ){

                if( nums[mid] < target ){
                    start = mid + 1;
                }

                else if( target > nums[N-1] ){
                    end = mid - 1;
                }

                else if( target < nums[0] ){
                    start = mid + 1;
                }

            }

            else if( nums[mid] < nums[0] ){
                if( nums[mid] > target ){
                    end = mid - 1;
                }

                else if( target > nums[N-1] ){
                    end = mid - 1;
                }

                else if( target < nums[0] ){
                    start = mid + 1;
                }
            }

            else if( nums[mid] < target ){
                start = mid + 1;
            }

            else if( nums[mid] > target ){
                end = mid - 1;
            }

        }

        return -1;
    }

}
