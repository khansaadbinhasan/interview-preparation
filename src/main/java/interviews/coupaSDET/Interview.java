package interviews.coupaSDET;

public class Interview {

    public static void main(String[] args) {
        new Interview().run();
    }

    public void run(){
        //All small characters and no special characters, can be numbers
        //abcdefcabge
        //can have nested strings
        //aacc
        //ac V
        //ca X
    }

    public int getMinDist(String s, char first, char second){

        //Iterate
        //Keep track of last first character that is there and the first second character
        //abcdefcabge
        int minDist = Integer.MAX_VALUE;
        int firstI = -1;
//        int secondI = -1;

        for (int i = 0; i < s.length(); i++) {
            if( s.charAt(i) == first ) firstI = i;
            if( s.charAt(i) == second ){
                if( firstI == -1 ) continue;
                minDist = Math.min(minDist, i-firstI-1);
            }
        }

        return minDist;
    }

}
