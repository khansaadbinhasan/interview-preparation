package leetcode.easy;


//7
//2
//3
//15
public class L1646MaxInArray {

    public static void main(String[] args){
        new L1646MaxInArray().run();
    }

    public void run(){
    }

    public int getMaximumGenerated(int n) {
        if( n == 0 ) return 0;
        if( n == 1 ) return 1;

        int[] numArr = new int[n+1];

        numArr[0] = 0;
        numArr[1] = 1;

        int max = 1;

        for( int i = 2; i < numArr.length; i++ ){
            if( i % 2 == 0 ) numArr[i] = numArr[i / 2];
            else numArr[i] = numArr[i / 2] + numArr[(i+1) / 2];

            max = Math.max(numArr[i], max);
        }

        return max;
    }
}
