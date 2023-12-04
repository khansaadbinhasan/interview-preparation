package leetcode.easy;

//[2,6,4,1]
//[1,2,34,3,4,5,7,23,12]
public class L1550ThreeConsecutiveOdds {

    public boolean threeConsecutiveOdds(int[] arr) {

        for( int i = 0; i < arr.length-2; i++ ){
            if( !isEven(arr[i]) && !isEven(arr[i+1]) && !isEven(arr[i+2]) ) return true;
        }

        return false;
    }

    public boolean isEven(int n){
        return n % 2 == 0;
    }
}
