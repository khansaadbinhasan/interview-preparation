package leetcode.easy;

//[[1993,1999],[2000,2010]]
//[[1950,1961],[1960,1971],[1970,1981]]
public class L1854MaxPopulationYear {

    public int maximumPopulation(int[][] logs) {

        int[] freqArr = new int[100];
        int count = 0;

        for( int i = 0; i < logs.length; i++ ){
            for( int year = logs[i][0]; year < logs[i][1]; year++ ){
                freqArr[year-1950]++;
            }
        }

        int maxI = 0;
        int max = freqArr[maxI];


        for( int i = 0; i < freqArr.length; i++ ){
            if( freqArr[i] > max ){
                max = freqArr[i];
                maxI = i;
            }
        }

        return 1950 + maxI;

    }
}
