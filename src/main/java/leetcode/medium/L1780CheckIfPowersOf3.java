package leetcode.medium;

//12
//91
//21
//1
//100
//10000000
//87
//99
public class L1780CheckIfPowersOf3 {

    public static void main(String[] args) {
        new L1780CheckIfPowersOf3().run();
    }

    public void run(){
        System.out.println(checkPowersOfThree(12));
    }

    public boolean checkPowersOfThree(int n) {

        int[] threePows = getThreePows();

        while( n > 0 ){
            int oldN = n;
            for( int i = threePows.length-1; i >= 0; i-- ){
                if( threePows[i] <= n ){
                    n -= threePows[i];
                    threePows[i] = n+1;
                }
            }

            if( oldN == n ) return false;
        }

        return true;

    }

    public int[] getThreePows(){
        int[] threePows = new int[16];

        for (int i = 0; i < threePows.length; i++) {
            threePows[i] = (int) Math.pow(3,i);
        }

        return threePows;
    }

}
