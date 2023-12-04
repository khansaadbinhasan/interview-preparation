package leetcode.easy;

import java.util.*;

//[[1,2],[2,1],[3,4],[5,6]]
//[[1,2],[1,2],[1,1],[1,2],[2,2]]
//[[1,2],[1,2],[1,1],[1,1],[2,1],[3,1],[1,3],[1,2],[2,2]]
//[[1,1]]
//[[1,2],[3,4]]
//[[1,8],[1,2],[1,1],[1,1],[2,1],[3,1],[5,3],[4,2],[2,2],[3,2],[1,2],[1,1],[1,1],[2,1],[3,1],[1,8],[1,6],[2,2],[1,2],[4,2],[1,1],[1,1],[2,1],[3,1],[1,3],[1,2],[6,2],[1,2],[1,2],[1,1],[1,1],[2,1],[7,1],[9,3],[1,9],[2,9],[1,2],[1,2],[1,1],[1,1],[2,1],[3,1],[1,3],[1,2],[2,2]]
//[[1,8],[1,2],[1,1],[1,1],[2,1],[3,1],[5,3],[4,2],[2,2],[3,2],[1,2],[1,1],[1,1],[2,1],[3,1],[1,8],[1,6],[2,2],[1,2],[4,2],[1,1],[1,1],[2,1],[3,1],[1,3],[1,2],[6,2],[1,2],[1,2],[1,1],[1,1],[2,1],[7,1],[9,3],[1,9],[2,9],[1,2],[1,2],[1,1],[1,1],[2,1],[3,1],[1,3],[1,2],[2,2],[1,6],[2,2],[1,2],[4,2],[1,1],[1,1],[2,1],[3,1],[1,3],[1,2],[6,2],[1,2]]
public class L1128NumberOfEquivalentDominos {

    public static void main(String[] args) {
        new L1128NumberOfEquivalentDominos().run();
    }

    public void run(){
        System.out.println(numEquivDominoPairs(new int[][]{{1,8},{1,2},{1,1},{1,1},{2,1},{3,1},{5,3},{4,2},{2,2},{3,2},{1,2},{1,1},{1,1},{2,1},{3,1},{1,8},{1,6},{2,2},{1,2},{4,2},{1,1},{1,1},{2,1},{3,1},{1,3},{1,2},{6,2},{1,2},{1,2},{1,1},{1,1},{2,1},{7,1},{9,3},{1,9},{2,9},{1,2},{1,2},{1,1},{1,1},{2,1},{3,1},{1,3},{1,2},{2,2}}));
    }

    public int numEquivDominoPairs(int[][] dominoes) {

        Map<String, Integer> arrayVsCountMap = new HashMap<>();

        for( int i = 0; i < dominoes.length; i++ ){
            Arrays.sort(dominoes[i]);
            String currArr = Arrays.toString(dominoes[i]);
            arrayVsCountMap.putIfAbsent(currArr,0);
            arrayVsCountMap.put(currArr,arrayVsCountMap.get(currArr)+1);
        }

        int numDoms = 0;

        for( String key: arrayVsCountMap.keySet() ){
            numDoms += C(arrayVsCountMap.get(key),2);
        }

        return numDoms;

    }

    public int C(int a, int b){
        if( a < b ) return 0;

        int c = a;

        for( int i = a-1; i > (c-b); i-- ){
            c = c*i;
        }

        return c / fact(b);
    }

    public int fact(int n){
        if( n == 1 || n == 0 ) return 1;

        return n * fact(n-1);
    }
}

// [1,2],[1,2],[1,2],[2,1] --> 6
// [1,1],[1,1], --> 1
// [3,1],[1,3], --> 1

// // [[1,2],[1,2],[1,1],[1,1],[2,1],[3,1],[1,3],[1,2],[2,2]]