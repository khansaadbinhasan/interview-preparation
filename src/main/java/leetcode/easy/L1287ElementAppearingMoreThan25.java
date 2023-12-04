package leetcode.easy;

//[1,2,2,6,6,6,6,7,10]
//[1,1]
//[1]
//[1,1,1,1,1,1,1]
//[1,1,1,2,2,2,2,2,2,2,2,2,2,2,3,3,3,3]
public class L1287ElementAppearingMoreThan25 {

    public int findSpecialInteger(int[] arr) {
        int maxFreq = 1;
        int num = arr[0];

        for( int i = 1; i < arr.length; i++ ){
            int freq = 1;
            while( (i < arr.length) && (arr[i] == arr[i-1]) ) {
                freq++;
                i++;
            }

            if( freq > 1 ) i--;

            if( freq > maxFreq ){
                maxFreq = freq;
                num = arr[i];
            }
        }

        return num;
    }

}
