package codingBlocks.graphs;

import java.util.*;

//4 4
//4 2 2 3

//6 6
//4 5 1 1

//100 100
//1 1
//19 80

//6 6
//1 1
//3 2

public class MinimumKnightsMoves {

    public static void main(String[] args) {
        new MinimumKnightsMoves().run();
    }

    public void run(){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int s1 = sc.nextInt();
        int s2 = sc.nextInt();

        int e1 = sc.nextInt();
        int e2 = sc.nextInt();

        System.out.println(minStepToReachTarget(new int[]{s1, s2}, new int[]{e1, e2}, n));
    }

    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N) {

        if(Arrays.equals(KnightPos, TargetPos)) return 0;

        int[][] traversalMatrix = new int[N+1][N+1];

        for( int[] traversalRow: traversalMatrix ){
            Arrays.fill(traversalRow, 0);
        }

        int[][] movesForKnight = getMovesForKnight(KnightPos[0], KnightPos[1], 1, N);

        Queue<int[]> bfsQ = new LinkedList<>();

        for(int[] move: movesForKnight){
            if( move[0] != 0 ) {
                bfsQ.offer(move);
                traversalMatrix[move[0]][move[1]] = -1;
            }
        }

        int minSteps = Integer.MAX_VALUE;

        while( !bfsQ.isEmpty() ){

            int[] moves = bfsQ.poll();

            int i = moves[0];
            int j = moves[1];

            if( i == TargetPos[0] && j == TargetPos[1] )
                minSteps = Math.min(minSteps, moves[2]);

            movesForKnight = getMovesForKnight(i, j, moves[2]+1, N);

            for(int[] move: movesForKnight){
                if( move[0] != 0 && traversalMatrix[move[0]][move[1]] != -1 ){
                    traversalMatrix[move[0]][move[1]] = -1;
                    bfsQ.offer(move);
                }
            }
        }

        return minSteps == Integer.MAX_VALUE ? -1: minSteps;
    }

    public int[][] getMovesForKnight(int i, int j, int numMoves, int N){
        int[][] movesForKnight = new int[8][3];

        for (int k = 0; k < 8; k++) {
            movesForKnight[k][2] = numMoves;
        }

        if( i + 2 <= N && j + 1 <= N ){
            movesForKnight[0][0] = i + 2;
            movesForKnight[0][1] = j + 1;
        }

        if( i + 2 <= N && j - 1 >= 1 ){
            movesForKnight[1][0] = i + 2;
            movesForKnight[1][1] = j - 1;
        }

        if( i - 2 >= 1 && j + 1 <= N ){
            movesForKnight[2][0] = i - 2;
            movesForKnight[2][1] = j + 1;
        }

        if( i - 2 >= 1 && j - 1 >= 1 ){
            movesForKnight[3][0] = i - 2;
            movesForKnight[3][1] = j - 1;
        }

        if( i + 1 <= N && j + 2 <= N ){
            movesForKnight[4][0] = i + 1;
            movesForKnight[4][1] = j + 2;
        }

        if( i + 1 <= N && j - 2 >= 1 ){
            movesForKnight[5][0] = i + 1;
            movesForKnight[5][1] = j - 2;
        }

        if( i - 1 >= 1 && j + 2 <= N ){
            movesForKnight[6][0] = i - 1;
            movesForKnight[6][1] = j + 2;
        }

        if( i - 1 >= 1 && j - 2 >= 1 ){
            movesForKnight[7][0] = i - 1;
            movesForKnight[7][1] = j - 2;
        }

        return movesForKnight;
    }

}
