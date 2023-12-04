package leetcode.medium;

import java.util.LinkedList;
import java.util.List;

//[1,3,4,1,2,3,1]
//[2,1,1]
//[1,2,3,4]
//[1]
//[1,2,1,1,1,1,1,1,1]
public class L2610ConvertInto2DArr {

    public static void main(String[] args) {
        new L2610ConvertInto2DArr().run();
    }

    public void run(){
        System.out.println(findMatrix(new int[]{1,3,4,1,2,3,1}));
    }

    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> matrix = new LinkedList<>();

        int[] freqArr = new int[201];

        for( int i = 0; i < nums.length; i++ ){
            freqArr[nums[i]]++;
        }

        int count = 0;
        int k = 0;

        while( count < nums.length ){
            matrix.add(new LinkedList<>());

            for( int i = 1; i < freqArr.length; i++ ){
                if( freqArr[i] > 0 ){
                    matrix.get(k).add(i);
                    count++;
                    freqArr[i]--;
                }
            }

            k++;
        }

        return matrix;
    }


}
