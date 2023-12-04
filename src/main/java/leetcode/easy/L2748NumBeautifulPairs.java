package leetcode.easy;

//[2,5,1,4]
//[11,21,12]
//[1,2]
//[1,9999]
//[1,2,3,4,5,6,7,8,9]
//[6,5,7,4,8,3]
//[101,205,303,1,199,98,999]
//[102,209,304,1,199,1,2,3,4,5,6,7,8,9,98,999]
public class L2748NumBeautifulPairs {

    public int countBeautifulPairs(int[] nums) {

        int count = 0;

        for( int i = 0; i < nums.length; i++ ){
            for( int j = i+1; j < nums.length; j++ ){
                if( gcd(firstDig(nums[i]), lastDig(nums[j])) == 1 ) count++;
            }
        }

        return count;
    }

    public int firstDig(int num){

        int firstDig = num%10;

        while( num != 0 ){
            firstDig = num%10;
            num = num / 10;
        }

        return firstDig;
    }

    public int lastDig(int num){
        return num % 10;
    }

    public int gcd(int a, int b){
        return (b == 0) ? a: gcd(b, a%b);
    }

}
