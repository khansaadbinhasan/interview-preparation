package leetcode.easy;

//[[1,3],[2,2],[3,1]]
//4
//[[5,10],[2,5],[4,7],[3,9]]
//10
public class L1710MaxUnitsOnTruck {

    public int maximumUnits(int[][] boxTypes, int truckSize) {

        int[] freqArr = new int[1001];

        for( int[] boxType: boxTypes ){
            freqArr[boxType[1]] += boxType[0];
        }

        int maxUnits = 0;

        for( int i = freqArr.length-1; i >= 0; i-- ){
            if( freqArr[i] > 0 ) {
                if( truckSize >= freqArr[i] ){
                    truckSize -= freqArr[i];
                    maxUnits += i * freqArr[i];
                }

                else{
                    maxUnits += truckSize * i;
                    truckSize = 0;
                    break;
                }
            }
        }

        return maxUnits;
    }

}
