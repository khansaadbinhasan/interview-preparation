package leetcode.easy;


//"02:30"
//"04:35"
//"11:00"
//"11:01"
//"11:00"
//"11:00"
public class L2224MinNumberOfOperations {

    public int convertTime(String current, String correct) {

        int currentHr = Integer.valueOf(current.split(":")[0]);
        int currentMin = Integer.valueOf(current.split(":")[1]);

        int correctHr = Integer.valueOf(correct.split(":")[0]);
        int correctMin = Integer.valueOf(correct.split(":")[1]);

        int hrDiff = correctHr - currentHr;
        int numOps = hrDiff >= 0 ? hrDiff: 24 + hrDiff;

        int minDiff = correctMin - currentMin;

        if( minDiff < 0 ) {
            numOps--;
            minDiff = 60+minDiff;
        }

        if( minDiff != 0 ){
            numOps += minDiff / 15;
            minDiff = minDiff % 15;
        }

        if( minDiff != 0 ){
            numOps += minDiff / 5;
            minDiff = minDiff % 5;
        }

        if( minDiff != 0 ){
            numOps += minDiff;
        }

        return numOps;
    }
}
