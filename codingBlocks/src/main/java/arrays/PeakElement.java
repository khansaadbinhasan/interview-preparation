package arrays;

import java.util.Scanner;

//1
//1
//2
//-1 1
//3
//1 3 1
//7
//1 2 1 3 5 6 4
//7
//1 2 1 3 5 4 4
//7
//1 2 1 3 5 6 7
//4
//1 2 3 1
//5
//1 2 3 4 5
//5
//5 4 3 2 1
//2
//100 1
//2
//1 100
//3
//100 10 1000


public class PeakElement {

    public static void main(String[] args) {
        new PeakElement().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) arr[i] = sc.nextInt();

        System.out.println(findPeakElement(arr));
    }

    public int findPeakElement(int[] nums) {

        int start = 0;
        int end = nums.length - 1;

        while( start <= end ){
            int mid = (start + end) / 2;

            if( nums.length == 1 ) return 0;

            if( mid == 0 ){
                if( nums[mid] > nums[mid+1] )
                    return mid;

                start = mid + 1;
                continue;
            }

            if( mid == nums.length - 1 ){
                if( nums[mid] > nums[mid-1] )
                    return mid;

                end = mid - 1;
                continue;
            }

            if( nums[mid] < nums[mid+1] ) start = mid + 1;
            else if( nums[mid] > nums[mid-1] ) return mid;
            else if( nums[mid] < nums[mid-1] ) end = mid - 1;
        }

        return -1;

    }

//    public int findPeakElement(int[] nums){
//        int n = nums.length;
//
//        int l = 0;
//        int r = n-1;
//
//        return findPeak(nums, l, r);
//    }
//
//    public int findPeak(int[] nums, int si, int ei){
//        if( si == ei ) return si;
//
//        int mid = (si + ei) / 2;
//
//        if( nums[mid] < nums[mid+1] ){
//            return findPeak(nums, mid+1, ei);
//        }
//
//        return findPeak(nums, si, mid);
//    }

}
