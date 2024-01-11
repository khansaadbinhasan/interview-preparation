package leetcode.easy;

import java.util.Arrays;

//[5,7,1,4]
//3
//[1,2,3,4]
//0
//[2,4,9,3]
//-2
public class L1652DefuseTheBomb {

//    public int[] decrypt(int[] code, int k) {
//
//        for( int i = 0; i < code.length; i++ ){
//            int sum = 0;
//
//            if( k > 0 ){
//                int j = i+1;
//                while( j-i-1 < k ){
//                    sum += code[j++];
//                }
//            }
//
//            else if( k < 0 ){
//                int j = i+1;
//                while( j-i-1 < k ){
//                    sum += code[j++];
//                }
//            }
//        }
//
//        return code;
//    }
//
//    public int getSum( int[] code, int k ){
//
//
//
//    }


    public static void main(String[] args) {
        new L1652DefuseTheBomb().run();
    }

    public void run(){
        System.out.println(Arrays.toString(decrypt(new int[]{2,4,9,3}, -2)));
    }

    public int[] decrypt(int[] code, int k) {
        int[] ans = new int[code.length];

        for( int i = 0; i < code.length; i++ ){
            ans[i] = getSum(code, i, k);
        }

        return ans;
    }

    public int getSum( int[] code, int ind, int k ){
        int sum = 0;

        if( k < 0 ){
            for( int i = ind-1; i >= ind+k; i-- ){
                sum += code[(code.length+i)%code.length];
            }

            return sum;
        }

        for( int i = ind+1; i <= ind+k; i++ ){
            sum += code[i%code.length];
        }

        return sum;

    }

}
