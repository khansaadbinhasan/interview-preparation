package leetcode.easy;

//5
//4
//1
//1
//7
//3
//9
//1
//9009
//78
//2147483647
//93
//2147483647
//999999999
//1918989889
//7666666
public class L278FirstBadVersion {

    public int firstBadVersion(int n) {

        if( isBadVersion(1) ) return 1;

        int start = 2;
        int end = n;

        while( start <= end ){
            int mid = start + (end-start) / 2;

            if( isBadVersion(mid) && !isBadVersion(mid-1) ) return mid;

            if( !isBadVersion(mid) ) start = mid+1;
            else end = mid-1;
        }

        return -1;
    }

    public boolean isBadVersion(int i){
        return true;
    }
}
