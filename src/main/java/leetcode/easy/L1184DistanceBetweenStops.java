package leetcode.easy;


//[1,2,3,4]
//0
//1
//[1,2,3,4]
//0
//2
//[1,2,3,4]
//0
//3
//[1]
//0
//0
//[7,10,1,12,11,14,5,0]
//7
//2
//[6,47,48,31,10,27,46,33,52,33,38,25,32,45,36,3,0,33,22,53,8,13,18,1,44,41,14,5,38,25,48]
//22
//0
public class L1184DistanceBetweenStops {

    public static void main(String[] args) {
        new L1184DistanceBetweenStops().run();
    }

    public void run(){
        System.out.println(
                distanceBetweenBusStops(
                    new int[]{6,47,48,31,10,27,46,33,52,33,38,25,32,45,36,3,0,33,22,53,8,13,18,1,44,41,14,5,38,25,48},
                    22, 0
                )
        );
    }

            public int distanceBetweenBusStops(int[] distance, int start, int destination) {

                int totalDist = 0;
                int i = start;

                while( i != destination ){

                    totalDist += distance[ i % distance.length ];
                    i = (i+1) % distance.length;
                }

                i = start;

                int newTotalDist = 0;

                while( i != destination ){
                    if( i > 0 ){
                        newTotalDist += distance[i-1];
                    }

                    else{
                        i = distance.length-1-i;
                        newTotalDist += distance[i];
                        i++;
                    }

                    i--;
                }

                return Math.min(totalDist, newTotalDist);
            }

}
