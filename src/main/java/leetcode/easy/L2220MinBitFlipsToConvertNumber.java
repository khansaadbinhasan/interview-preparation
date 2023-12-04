package leetcode.easy;



public class L2220MinBitFlipsToConvertNumber {

    public static void main(String[] args){
        new L2220MinBitFlipsToConvertNumber().run();
    }

    public void run(){
        System.out.println(minBitFlips(10, 7));
    }

    public int minBitFlips(int start, int goal) {

        int minFlips = 0;

        while( !(start == 0 && goal == 0) ){
            int startBit = start & 1;
            int goalBit = goal & 1;

            if( startBit != goalBit ) minFlips++;

            start = start >>> 1;
            goal = goal >>> 1;
        }

        return minFlips;
    }
}
