package leetcode.easy;


//[[1,2],[3,4],[5,6]]
//2
//5
//[[1,10],[10,20]]
//21
//21
//[[1,1]]
//1
//50
//[[15,20], [1,10]]
//21
//30
public class L1893RangesCovered {

    public static void main(String[] args){
        new L1893RangesCovered().run();
    }

    public void run(){
    }

    public boolean isCovered(int[][] ranges, int left, int right) {

        int s = ranges[0][0];
        int e = ranges[0][1];

        for( int i = 1; i < ranges.length; i++ ){
            if( ranges[i][1] >= s-1 && ranges[i][0] < s ) s = ranges[i][0];
            if( ranges[i][0] <= e+1 && ranges[i][1] > e) e = ranges[i][1];
        }
        return s <= left && e >= right;
    }
}
