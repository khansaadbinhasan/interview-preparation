package leetcode.medium;

// 2736
// 9973
// 1100
// 1199
// 123456
// 878687
// 9999999
// 1010101
// 7823743
//10909091

public class L670MaxSwap {
    public int maximumSwap(int num) {
        int nLen = String.valueOf(num).length();
        int[] numArr = new int[nLen];
        int[] minArr = new int[nLen];
        int[] maxArr = new int[nLen];

        int numclone = num;

        for( int i = numArr.length-1; i >= 0; i-- ){
            numArr[i] = numclone%10;
            numclone = numclone/10;
        }

        minArr[0] = numArr[0];

        for( int i = 1; i < numArr.length; i++ ){
            minArr[i] = Math.min(numArr[i], minArr[i-1]);
        }

        maxArr[numArr.length-1] = numArr[numArr.length-1];

        for( int i = numArr.length-2; i >= 0; i-- ){
            maxArr[i] = Math.max(numArr[i], maxArr[i+1]);
        }

        int minI = -1;

        for( int i = 0; i < minArr.length; i++ ){
            if( minArr[i] != maxArr[i] ) {
                minI = i;
                break;
            }
        }

        if( minI == -1 ) return num;

        int maxI = minI;

        for( int j = minI+1; j < maxArr.length; j++ ){
            if( maxArr[j] != maxArr[j-1] ){
                maxI = j-1;
                break;
            }
            else{
                maxI = j;
            }
        }

        int temp = numArr[maxI];
        numArr[maxI] = numArr[minI];
        numArr[minI] = temp;

        num = 0;

        for(int i = numArr.length-1; i >= 0; i-- ){
            num += numArr[i]*Math.pow(10,numArr.length-1-i);
        }

        return num;

    }

}
