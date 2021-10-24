package codingBlocks.graphs;

import java.util.*;

//-1 --> obstacle
//0 --> gate
//inf(Integer.MAX_VALUE) --> empty room

//2 2
//2147483647 0
//2147483647 0

public class WallsAndGates {

    public static void main(String[] args) {
        new WallsAndGates().run();
    }

    class Pair{
        int x;
        int y;
        int dist;

        public Pair(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] map = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        wallsAndGates(map);
    }

    public void wallsAndGates(int[][] map){

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if( map[i][j] == 0 ) map[i][j] = Integer.MAX_VALUE;
                else if( map[i][j] == Integer.MAX_VALUE ) map[i][j] = 0;
            }
        }

        Queue<Pair> bfsQ = new LinkedList<>();

        for(int i = 0; i < map.length; i++){
            for (int j = 0; j < map[i].length; j++) {
                if( map[i][j] == Integer.MAX_VALUE ) bfsQ.add(new Pair(i,j,0));
            }
        }

        while( !bfsQ.isEmpty() ){
            Pair room = bfsQ.poll();

            int i = room.x;
            int j = room.y;

            if( i > 0 && map[i-1][j] == 0 ) {
                map[i-1][j] = room.dist+1;
                bfsQ.add( new Pair(i-1, j, room.dist+1));
            }

            if( i < map.length-1 && map[i+1][j] == 0 ) {
                map[i+1][j] = room.dist+1;
                bfsQ.add( new Pair(i+1, j, room.dist+1));
            }

            if( j > 0 && map[i][j-1] == 0 ) {
                map[i][j-1] = room.dist+1;
                bfsQ.add( new Pair(i, j-1, room.dist+1));
            }

            if( j < map[0].length-1 && map[i][j+1] == 0 ) {
                map[i][j+1] = room.dist+1;
                bfsQ.add( new Pair(i, j+1, room.dist+1));
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if( map[i][j] == Integer.MAX_VALUE ) map[i][j] = 0;
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

}
