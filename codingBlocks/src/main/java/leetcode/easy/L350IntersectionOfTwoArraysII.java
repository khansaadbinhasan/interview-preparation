package leetcode.easy;

//[1,2,2,1]
//[2,2]
//[4,9,5]
//[9,4,9,8,4]
//[1]
//[2]
//[1,2,3,4]
//[5,6,7,8]
//[1,1,1,1,1]
//[2,2,2,2,2,1]
//[3]
//[1,1,1,1]
//[0,0,0,111]
//[111]

public class L350IntersectionOfTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {

        int maxNum = 1000;

        int[] freqArr1 = new int[maxNum+1];
        int[] freqArr2 = new int[maxNum+1];

        for( int i = 0; i < nums1.length; i++ ){
            freqArr1[nums1[i]]++;
        }

        for( int i = 0; i < nums2.length; i++ ){
            freqArr2[nums2[i]]++;
        }

        int[] intersectedFreqArr = new int[maxNum+1];

        int numElems = 0;

        for( int i = 0; i <= maxNum; i++ ){
            intersectedFreqArr[i] = Math.min(freqArr1[i], freqArr2[i]);
            numElems += intersectedFreqArr[i];
        }

        int[] intersectedArr = new int[numElems];

        int index = 0;

        // System.out.println(Arrays.toString(intersectedFreqArr));

        for( int i = 0; i <= maxNum; i++ ){

            while( intersectedFreqArr[i] != 0 ){
                intersectedArr[index] = i;
                index++;
                intersectedFreqArr[i]--;
            }
        }

        return intersectedArr;
    }

}
