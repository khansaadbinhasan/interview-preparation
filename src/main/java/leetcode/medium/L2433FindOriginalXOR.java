package leetcode.medium;

//[5,2,0,3,1]
//[13]
public class L2433FindOriginalXOR {

    public int[] findArray(int[] a) {

        int[] b = a.clone();

        for( int i = 1; i < a.length; i++ ){
            b[i] = a[i-1] ^ a[i];
        }

        return b;
    }
}
