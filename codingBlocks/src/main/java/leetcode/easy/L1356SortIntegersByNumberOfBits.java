package leetcode.easy;

import java.util.*;

//[0,1,2,3,4,5,6,7,8]
//[1024,512,256,128,64,32,16,8,4,2,1]
//[10000,10000]
//[2,3,5,7,11,13,17,19]
//[10,100,1000,10000]
//[0]
//[1]
//[10000]
public class L1356SortIntegersByNumberOfBits {

    public int[] sortByBits(int[] arr) {

        List<Integer>[] lst = new ArrayList[32];

        for( int i = 0; i < lst.length; i++ ){
            lst[i] = new ArrayList<>();
        }

        for( int i = 0; i < arr.length; i++ ){
            lst[getBits(arr[i])].add(arr[i]);
        }

        List<Integer> res = new ArrayList<>();

        for( int i = 0; i < lst.length; i++ ){

            lst[i].sort(Comparator.naturalOrder());

            res.addAll(lst[i]);
        }

        int[] result = new int[res.size()];

        for( int i = 0; i < res.size(); i++ ){
            result[i] = res.get(i);
        }

        return result;
    }

    public int getBits(int n){
        int count = 0;

        while( n > 0 ){
            count += (n&1);
            n = n >> 1;
        }

        return count;
    }


}
