package leetcode.easy;

import java.util.*;

//4
//[1,3,1,2]
//2
//[2,1,2,1,2,1,2,1,2]
//7
//[1,3,5,7]
//2
//[1,2]
//100
//[3,2,1,100,21,35,50,77,23,11,55,89]
public class L1560MostVisitedInCircularTrack {

    public static void main(String[] args) {
        new L1560MostVisitedInCircularTrack().run();
    }

    public void run(){
        System.out.println(mostVisited2(2, new int[]{2,1,2,1,2,1,2,1,2}));
        System.out.println(mostVisited2(7, new int[]{1,3,5,7}));
    }


    public List<Integer> mostVisited(int n, int[] rounds) {

        int[] visited = new int[n+1];
        int max = 0;

        for( int i = 1; i < rounds.length; i++ ){
            int k = rounds[i-1];
            while( k != rounds[i] ){
                visited[k]++;
                max = Math.max(max, visited[k]);
                k = k % n + 1;
            }
        }

        visited[rounds[rounds.length-1]]++;
        max = Math.max(max, visited[rounds[rounds.length-1]]);

        List<Integer> most = new LinkedList<>();

        for( int i = 1; i <= n; i++ ){
            if( visited[i] == max )
                most.add(i);
        }

        most.sort(Comparator.naturalOrder());

        return most;
    }

    public List<Integer> mostVisited2(int n, int[] rounds) {
        var start = rounds[0];
        var end = rounds[rounds.length - 1];
        var res = new ArrayList<Integer>();
        if (start <= end) {
            for (int i = start; i <= end; i++) res.add(i);
        } else {
            for (int i = 1; i <= end; i++) res.add(i);
            for (int i = start; i <= n; i++) res.add(i);
        }
        return res;
    }

}
