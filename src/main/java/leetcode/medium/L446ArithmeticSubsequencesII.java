package leetcode.medium;

import java.util.*;

//[2,4,6,8,10]
//[1]
//[1,2,3,4,5]
//[1,3,5,7,9]
//[3,-1,-5,-9]
//[1,2,3,4,5,6]
//[1,2,3,4,5,9,7,8,10,12,14]
//[1,2,3,4,5,9,7,8,10,12,14,100,200,300,1000,900,800,909,98,88776,21211,2121,2121]
//[7,7,7,7,7]
//[1,2,3,4,5,9,7,8,10,12,14,100,200,300,1000,900,800,909,98,88776,21211,2121,2121,2121,2121,2121,2121]
//[2,2,3,4]
public class L446ArithmeticSubsequencesII {

    public static void main(String[] args) {
        new L446ArithmeticSubsequencesII().run();
    }

    public void run(){
        System.out.println(numberOfArithmeticSlices(new int[]{2,2,3,4}));
    }

    public int numberOfArithmeticSlices(int[] nums) {

        Map<Integer, Integer>[] mapNums = new HashMap[nums.length];

        //[1i,2,3,4,5j] --> nums
        //[{1->4,2->2,3->1,4->1},{3->1},{2->1},{},{}] --> mapNums
        //[7,7,7,7i,7j,7]
        //[null,null,{0->3},{},{},{}]
        mapNums[nums.length-1] = new HashMap<>();
        for( int i = nums.length-2; i >= 0; i-- ){//3
            mapNums[i] = new HashMap<>();
            for( int j = i+1; j < nums.length; j++ ){//4
                int diff = nums[j] - nums[i];//0
                int numDiffs = mapNums[j].getOrDefault(diff, 0);//0

                if( diff == 0 ){
                    mapNums[i].putAll(mapNums[j]);
                }

                mapNums[i].put(diff, Math.max(mapNums[i].getOrDefault(diff,0),numDiffs+1));
                mapNums[j].remove(diff);
            }
        }

        int res = 0;

        //[{1->4,2->2,3->1,4->1},{3->1},{2->1},{},{}] --> mapNums
        for( int i = 0; i < mapNums.length; i++ ){
            for( int key: mapNums[i].keySet() ){//
                res += getNumSqs(mapNums[i].get(key)+1, key);//(10+1+0+0=11)+(0)+(0)
            }
        }

        return res;//11
    }

    //[1,2,3] --> 1
    //[1,2,3,4] --> 3
    //[1,2,3,4,5] --> 6
    //
    //general case - (n-2)*(n-1)/2
    public int getNumSqs(int n, int diff){
        if( diff == 0 ){
            int numSqs = 0;
            for( int k = n-2; k >= 1; k-- ){
                numSqs += k*(Math.pow(2, n-k-1)-1);
            }
            return numSqs;
        }

        return ((n-2)*(n-1))/2;
    }

}
