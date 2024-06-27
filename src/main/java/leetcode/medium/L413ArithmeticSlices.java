package leetcode.medium;

//[1,2,3,4]
//[1]
//[1,3,5,7,9]
//[7,7,7,7,7]
//[3,-1,-5,-9]
//[1,2,3,4,5,6]
//[1,2,3,4,5,9,7,8,10,12,14]
public class L413ArithmeticSlices {

    //Take Two pointers first one at the start of artihmetic subarray and another at the end. Calculate number of elements and number of all possible subbarrays in between. Update pointers
    public int numberOfArithmeticSlices(int[] nums) {
        //[1],2,3,4,5,[9],7,8,10,12,14
        int p1 = 0;
        int p2 = 1;
        int diff = Integer.MIN_VALUE;

        int numSqs = 0;

        while( p1 < nums.length && p2+1 < nums.length ){
            diff = nums[p2]-nums[p1];
            while( p2+1 < nums.length && nums[p2+1]-nums[p2] == diff ){
                p2++;
            }

            numSqs += getNumSqs(p2-p1+1);
            p1=p2;
            p2++;
        }

        return numSqs;
    }

    //[1,2,3] --> 1
    //[1,2,3,4] --> 3
    //[1,2,3,4,5] --> 6
    //
    //general case - (n-2)*(n-1)/2
    public int getNumSqs(int n){
        return ((n-2)*(n-1))/2;
    }
}
