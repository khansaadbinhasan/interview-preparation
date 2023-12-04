package leetcode.easy;


//[1,0,0,0,1,0,0,1]
//2
//[1,0,0,1,0,1]
//2
//[0]
//0
//[0]
//1
//[1]
//1
//[1]
//0
//[1]
//1
//[1,1,1,1,1,1,1]
//0
public class L1437CheckAll1s {

    public static void main(String[] args) {
        new L1437CheckAll1s().run();
    }

    public void run(){
        System.out.println(kLengthApart(new int[]{1,0,0,1,0,1}, 2));
    }

    public boolean kLengthApart(int[] nums, int k) {
        int last1 = -1;

        for( int i = 0; i < nums.length; i++ ){
            if( nums[i] == 1 ){
                if( last1 == -1 ) {
                    last1 = i;
                    continue;
                }

                if( i - last1-1 < k ) return false;
                last1 = i;
            }
        }

        return true;
    }
}
