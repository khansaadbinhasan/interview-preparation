package leetcode.blind75;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class L15ThreeSum {

    public static void main(String[] args) {
        new L15ThreeSum().run();
    }

    public void run(){
        System.out.println(threeSum(new int[]{1,0,-1,-10,-9,-9,0,9,6,3}));
    }

    public List<List<Integer>> threeSum(int[] nums) {

        //sort the list and given one element as target, do two sum on the forward elements

        List<List<Integer>> ans = new LinkedList<>();//{{-1,2,-1},{}}

        Arrays.sort(nums);

        for( int i = 0; i < nums.length; i++ ){
            if( i > 0 && (nums[i] == nums[i-1]) ){
                continue;
            }

            int target = -nums[i];
            int p1 = i+1;
            int p2 = nums.length-1;

            while( p1 < p2 ){
                if( nums[p1] + nums[p2] > target ){
                    p2--;
                }

                else if( nums[p1] + nums[p2] < target ){
                    p1++;
                }

                else{
                    List<Integer> lst = Arrays.asList(nums[i], nums[p1], nums[p2]);
                    ans.add(lst);

                    p1++;
                    while( nums[p1] == nums[p1-1] && p1 < p2 ){
                        p1++;
                    }
                }
            }
        }

        return ans;
    }

}
