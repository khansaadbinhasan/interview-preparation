package leetcode.easy;

//[1,2,3]
//1
//[6,2,7,3]
//4
//[3]
//1
//[0]
//0

public class L1720DecodeXORedArr {

    public int[] decode(int[] encoded, int first) {

        int[] arr = new int[encoded.length+1];

        arr[0] = first;

        for( int i = 1; i < arr.length; i++ ){
            arr[i] = -(~(arr[i-1] ^ encoded[i-1]) + 1) ;
        }

        return arr;
    }

}
