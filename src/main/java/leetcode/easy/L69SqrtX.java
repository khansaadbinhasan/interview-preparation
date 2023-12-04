package leetcode.easy;

public class L69SqrtX {
    public int mySqrt(int x) {

        if( x <= 1 ) return x;

        boolean rootFound = false;

        int start = 0;
        int end = x;

        while(!rootFound){

            int mid = (start + end) / 2;

            if( mid == x / mid ) return mid;

            else if( mid > x / mid ){
                end = mid;
            }

            else if( mid < x / mid ){
                start = mid;

                if( (mid+1) == x / (mid+1) ) return mid+1;
                if( (mid+1) > x / (mid+1) ) return mid;

            }

        }

        return -1;
    }
}
