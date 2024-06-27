package CTCI.ch17hard;

import java.util.Arrays;
import java.util.Random;

public class Q2Shuffle {

    public static void main(String[] args) {
        new Q2Shuffle().run();
    }

    public void run(){
        shuffleArrayItr(new int[]{1,2,3,4,5,6,7});
    }

    public void shuffleArray(int[] nums){
        int[] orig = new int[nums.length];
        Random random = new Random();

        Arrays.fill(orig, -1);

        for (int i = 0; i < nums.length; i++) {
            int ind = random.nextInt(nums.length);
            while( orig[ind] != -1 ){
                ind = random.nextInt(nums.length);
            }

            orig[ind] = nums[i];
        }

        System.out.println(Arrays.toString(orig));
        System.out.println(Arrays.toString(nums));
    }

    public void shuffleArrayItr(int[] nums){
        Random random = new Random();

        System.out.println(Arrays.toString(nums));

        for (int i = 0; i < nums.length; i++) {
            int ind = random.nextInt(i+1);

            int temp = nums[ind];
            nums[ind] = nums[i];
            nums[i] = temp;
        }

        System.out.println(Arrays.toString(nums));
    }


}
