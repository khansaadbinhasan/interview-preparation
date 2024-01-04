package CTCI.ch10SortingAndSearching;

import java.util.Arrays;

public class Q11PeaksAndValleys {

    public static void main(String[] args) {
        new Q11PeaksAndValleys().run();
    }

    public void run(){
        System.out.println(Arrays.toString(peaksAndValleys(new int[]{1,2,3,4,5,6,7})));
        System.out.println(Arrays.toString(peaksAndValleys(new int[]{7,6,5,4,3,2,1})));
        System.out.println(Arrays.toString(peaksAndValleys(new int[]{7,6,5,4,5,5,5,5,6,6,6,6,3,2,1})));

        System.out.println(Arrays.toString(peaksAndValleysOn(new int[]{1,2,3,4,5,6,7})));
        System.out.println(Arrays.toString(peaksAndValleysOn(new int[]{7,6,5,4,3,2,1})));
        System.out.println(Arrays.toString(peaksAndValleysOn(new int[]{7,6,5,4,5,5,5,5,6,6,6,6,3,2,1})));
    }

    public int[] peaksAndValleysOn(int[] nums){

        for (int i = 1; i < nums.length; i+=2) {
            int maxInd = getMaxInd(nums, i-1, i, i+1);
            if( i != maxInd ){
                int temp = nums[i];
                nums[i] = nums[maxInd];
                nums[maxInd] = temp;
            }
        }

        return nums;
    }

    public int getMaxInd(int[] nums, int a, int b, int c){
        if( nums[a] > nums[b] && nums[a] > nums[c] ) return a;
        if( nums[b] > nums[a] && nums[b] > nums[c] ) return b;
        if( nums[c] > nums[a] && nums[c] > nums[b] ) return c;

        return b;
    }

    public int[] peaksAndValleys(int[] arr){
        int[] nums = new int[arr.length];

        Arrays.sort(arr);

        int p1 = 0;
        int p2 = arr.length-1;
        int p = 0;

        while( p1 <= p2 ){
            nums[p++] = arr[p2--];
            if( p == nums.length ) break;
            nums[p++] = arr[p1++];
        }

        return nums;
    }

}
