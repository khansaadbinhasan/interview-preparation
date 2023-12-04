package leetcode.easy;


//[4,7,9,3,9]
//[5,2,3]
//[20,14,21,10]
//[5,7,5]
//[12]
//[10,16]
//[12]
//[10,16,12,3,4,2,1]
//[12,6,24,48,90,11,10,111,100,3434,23232]
//[10,16,12,3,4,2,1]
//[56,22,79,41,8,39,81,59,74,14,45,49,15,10,28,16,77,22,65,8,36,79,94,44,80,72,8,96,78]
//[39,92,69,55,9,44,26,76,40,77,16,69,40,64,12,48,66,7,59,10,33,72,97,60,79,68,25,63]
public class L2644FindMaxDivisibilityScore {

    public static void main(String[] args) {
        new L2644FindMaxDivisibilityScore().run();
    }

    public void run(){

        int[] nums = {56,22,79,41,8,39,81,59,74,14,45,49,15,10,28,16,77,22,65,8,36,79,94,44,80,72,8,96,78};
        int[] divisors = {39,92,69,55,9,44,26,76,40,77,16,69,40,64,12,48,66,7,59,10,33,72,97,60,79,68,25,63};

        System.out.println(maxDivScore(nums, divisors));
    }

    public int maxDivScore(int[] nums, int[] divisors) {

        int maxScore = 0;
        int maxVal = divisors[0];

        for( int i = 0; i < divisors.length; i++ ){
            int score = 0;
            for( int j = 0; j < nums.length; j++ ){
                if( nums[j] % divisors[i] == 0 ) {
                    score++;
                }
            }

            if( score == maxScore ){
                maxVal = Math.min(maxVal, divisors[i]);
            }

            if( score > maxScore ){
                maxScore = score;
                maxVal = divisors[i];
            }
        }

        return maxVal;

    }
}
