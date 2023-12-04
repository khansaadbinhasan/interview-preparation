package leetcode.easy;


//[13,2,3,1,9]
//["a","a","a","a","a"]
//[4,4,2,4,4]
//["d","a","a","b","c"]
//[10,10,2,12,9]
//["a","b","c","a","d"]
public class L2347BestPokerHand {

    public String bestHand(int[] ranks, char[] suits) {
        if( isFlush(suits) ) return "Flush";
        if( is3Ofkind(ranks) ) return "Three of a Kind";
        if( isPair(ranks) ) return "Pair";

        return "High Card";
    }

    public boolean isFlush(char[] suits){
        for( int i = 1; i < suits.length; i++ ){
            if( suits[i] != suits[i-1] ) return false;
        }

        return true;
    }

    public boolean isPair(int[] ranks){
        int[] freqArr = new int[14];

        for( int i = 0; i < ranks.length; i++ ){
            freqArr[ranks[i]]++;
        }

        for( int i = 0; i < freqArr.length; i++ ){
            if( freqArr[i] >= 2 ) return true;
        }

        return false;
    }

    public boolean is3Ofkind(int[] ranks){
        int[] freqArr = new int[14];

        for( int i = 0; i < ranks.length; i++ ){
            freqArr[ranks[i]]++;
        }

        for( int i = 0; i < freqArr.length; i++ ){
            if( freqArr[i] >= 3 ) return true;
        }

        return false;
    }
}
