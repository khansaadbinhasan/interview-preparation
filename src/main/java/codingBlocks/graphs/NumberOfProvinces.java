package codingBlocks.graphs;

import java.util.*;

public class NumberOfProvinces {

    public static void main(String[] args) {
        new NumberOfProvinces().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] isConnected = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                isConnected[i][j] = sc.nextInt();
            }
        }

        System.out.println(findCircleNum(isConnected));
    }

    public int findCircleNum(int[][] isConnected) {

        int circleNum = 0;

        int[] provinces = new int[isConnected.length+1];

        Arrays.fill(provinces, 0);

        for(int i = 1; i < provinces.length; i++){

            if( provinces[i] == -1 ) continue;

            Queue<Integer> bfsQ = new LinkedList<>();

            bfsQ.offer(i);
            provinces[i] = -1;

            while( !bfsQ.isEmpty() ){
                int node = bfsQ.poll();

                for( int j = 0; j < isConnected[node-1].length; j++){
                    if( isConnected[node-1][j] == 1 && node != j+1 && provinces[j+1] != -1) {
                        bfsQ.offer(j+1);
                        provinces[j+1] = -1;
                    }
                }
            }

            circleNum++;
        }

        return circleNum;

    }

}
