package leetcode.easy;

//10
//6
//1
//1
//2
//1
//100
//1
//2147483647
//132
//9897878
//32
//4566788
//4566788
//2126753390
//1702766719
public class L374GuessNumber {

    public int guessNumber(int n) {

        int low = 0;
        int high = n;
        int mid = (low + high) / 2;

        while( low <= high ){
            mid = low + (high - low) / 2;

            if( guess(mid) == 0 ) return mid;

            else if( guess(mid) == 1 ) {
                low = mid+1;
            }

            else{
                high = mid-1;
            }
        }

        return -1;
    }

    public int guess(int num){
        return 1;
    }
}
