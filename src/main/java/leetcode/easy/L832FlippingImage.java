package leetcode.easy;

//[[1,1,0],[1,0,1],[0,0,0]]
//[[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]

public class L832FlippingImage {

    public int[][] flipAndInvertImage(int[][] image) {
        return invert(flip(image));
    }

    public int[][] flip(int[][] image){

        for( int[] row: image ){
            reverse(row);
        }

        return image;
    }

    public int[][] invert(int[][] image){

        for( int[] row: image ){
            not(row);
        }

        return image;

    }

    public int[] reverse(int[] nums){

        for( int i = 0; i < nums.length / 2; i++ ){
            int temp = nums[i];
            nums[i] = nums[nums.length-i-1];
            nums[nums.length-i-1] = temp;
        }

        return nums;
    }

    public int[] not(int[] nums){

        for( int i = 0; i < nums.length; i++ ){
            if( nums[i] == 1 ) nums[i] = 0;
            else if( nums[i] == 0 ) nums[i] = 1;
        }

        return nums;
    }


}
