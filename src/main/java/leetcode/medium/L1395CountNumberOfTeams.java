package leetcode.medium;

//[2,5,3,4,1]
//[2,1,3]
//[1,2,3,4]
//[5,4,3,2]
//[10,9,8,11,12,13]
public class L1395CountNumberOfTeams {

    public static void main(String[] args) {
        new L1395CountNumberOfTeams().run();
    }

    public void run(){
        System.out.println(numTeams(new int[]{2,5,3,4,1}));
    }

    public int numTeams(int[] rating) {

        int count = 0;

        for( int i = 0; i < rating.length; i++ ){
            int lessTillEnd = 0;
            int moreTillEnd = 0;
            int lessTillStart = 0;
            int moreTillStart = 0;

            for( int j = i+1; j < rating.length; j++ ){
                if( rating[i] < rating[j] ) moreTillEnd++;
                if( rating[i] > rating[j] ) lessTillEnd++;
            }

            for( int j = i-1; j >= 0; j-- ){
                if( rating[i] < rating[j] ) moreTillStart++;
                if( rating[i] > rating[j] ) lessTillStart++;
            }

            count += moreTillStart*lessTillEnd + lessTillStart*moreTillEnd;
        }

        return count;
    }

}
