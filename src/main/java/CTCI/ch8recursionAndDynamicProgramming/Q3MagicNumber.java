package CTCI.ch8recursionAndDynamicProgramming;

public class Q3MagicNumber {

    public static void main(String[] args) {
        new Q3MagicNumber().run();
    }

    public void run(){
        System.out.println(magicNumber(new int[]{-1,-2,-3,-4,-5,-6,6,7}));
        System.out.println(magicNumber(new int[]{-2,1,3,4,5,6}));
    }

    public int magicNumber(int[] nums){
        int start = 0;
        int end = nums.length-1;

        while( start <= end ){
            int mid = (start+end) / 2;

            if( nums[mid] == mid ) return mid;

            if( nums[mid] > mid ) end = mid-1;
            else start = mid+1;
        }

        return -1;
    }

    public int magicFast(int[] array){
        return magicFast(array, 0, array.length-1);
    }

    private int magicFast(int[] array, int start, int end) {
        if( end < start ) return -1;

        int mid = (start+end) / 2;
        int midVal = array[mid];

        if( midVal == mid ) return mid;

        int leftInd = Math.min(mid -1, midVal);
        int left = magicFast(array, start, leftInd);

        if( left >= 0 ) return left;

        int rightInd = Math.max(mid+1, midVal);
        int right = magicFast(array, rightInd, end);


        return right;
    }

}
