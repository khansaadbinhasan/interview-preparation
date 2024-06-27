package leetcode.medium;

//[3,1,4,2]
//6
//[6,3,5,2]
//9
//[1,2,3]
//3
//[1,2,3,4,5,6,7,8]
//7
//[1,2,3]
//10
//[7,6,1,7,8,9,3,2,1,12,1,12,121,12,19]
//19
//[61763, 93823, 44956, 34765, 3037, 24502, 62927, 66459, 83942, 19429, 15300, 35222, 99374, 44914, 68389, 19034, 77898, 20516, 54610, 21552, 24692, 58398, 69258, 10771, 85616, 59257, 20579, 66558, 25993, 74172, 45465, 51415, 88473, 7930, 49795, 98291, 42983, 70121, 79489, 48581, 34315, 50426, 48721, 52998, 79021, 96346, 74562, 3874, 7820, 78372, 22239, 21629, 51322, 5280, 45933, 68160, 83844, 44668, 30352, 68132, 91280, 39974, 33479, 83578, 64159, 27235, 35256, 18196, 15346, 9967, 83334, 46899, 58312, 23442, 30527, 24303, 57797, 19034, 86258, 84668, 12911, 99515, 64318, 52479, 16818, 6848, 19077, 44077, 41156, 30252, 30847, 15996, 25314, 40434, 60587, 46473, 32729, 7757, 56160, 63781]
//9888
//[1000000000,1000000000,1000000000]
//3
public class L1590MakeSumDivisibleByP {

    public static void main(String[] args) {
        new L1590MakeSumDivisibleByP().run();
    }

    public void run(){
        System.out.println(minSubarray(new int[]{1000000000,1000000000,1000000000}, 3));
    }

    public int minSubarray(int[] nums, int p) {
        long sum = 0;

        for( int i = 0; i < nums.length; i++ ){
            sum += nums[i];
        }

        if( sum % p == 0 ) return 0;

        for( int subArrayLength = 1; subArrayLength < nums.length; subArrayLength++ ){
            long removeSum = 0;
            for( int j = 0; j < subArrayLength; j++ ){
                removeSum += nums[j];
            }

            if( (sum - removeSum) % p == 0 ) return subArrayLength;

            for( int i = subArrayLength, pointer = 0; i < nums.length; i++, pointer++ ){
                removeSum -= nums[pointer];
                removeSum += nums[i];
                if( (sum - removeSum) % p == 0 ) return subArrayLength;
            }
        }

        return -1;
    }

}
