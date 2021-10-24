package leetcode.easy;

//[2,3,1,3,2,4,6,7,9,2,19]
//[2,1,4,3,9,6]
//[28,6,22,8,44,17]
//[22,28,8,6]
//[0,0,0,0]
//[0]
//[0,0,1,1]
//[0,1]
//[0]
//[0]
public class L1122RelativeSortArr {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        int[] freqArr = new int[1001];

        for( int num: arr1 ){
            freqArr[num]++;
        }

        int i = 0;

        for( int num: arr2 ){
            while(freqArr[num] > 0){
                arr1[i] = num;
                i++;
                freqArr[num]--;
            }
        }

        for( int j = 0; j < freqArr.length; j++ ){

            while( freqArr[j] > 0 ){
                arr1[i] = j;
                i++;
                freqArr[j]--;
            }
        }

        return arr1;
    }


}
