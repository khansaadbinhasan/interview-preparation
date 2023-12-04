package leetcode.easy;

//[1,2,3]
//[2,4]
//[1,2,3,6]
//[2,3,4,5]
//[1]
//[1]
//[1,2]
//[2,3]
//[1,2,3,4,5]
//[5]
//[1,2,3,4,5,5,7,9,100]
//[5]
//[1,2,3,4,5,5,7,9,100]
//[10,20,50,100]
public class L2540MinCommonValue {

    public int getCommon(int[] nums1, int[] nums2) {

        int i = 0;
        int j = 0;

        while( i < nums1.length && j < nums2.length ){
            if( nums1[i] == nums2[j] ) return nums1[i];

            if( nums1[i] < nums2[j] ) i++;
            else j++;
        }

        return -1;
    }
}
