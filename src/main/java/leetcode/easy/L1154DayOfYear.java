package leetcode.easy;


//"2019-01-09"
//"2019-02-10"
//"2000-03-10"
//"2000-02-29"
//"1900-03-28"
public class L1154DayOfYear {

    public static void main(String[] args){
        new L1154DayOfYear().run();
    }

    public void run(){
    }

    public int dayOfYear(String date) {
        int year = Integer.valueOf(date.split("-")[0]);
        int month = Integer.valueOf(date.split("-")[1]);
        int day = Integer.valueOf(date.split("-")[2]);

        int dayCount = day;

        if( month > 2 ){
            dayCount += isLeapYear(year) ? 1: 0;
        }

        int[] months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for( int i = 0; i < month-1; i++ ){
            dayCount += months[i];
        }

        return dayCount;

    }

    public boolean isLeapYear(int year){
        if( year % 4 == 0 ) {
            if( year % 100 == 0 && year % 400 != 0 ) return false;

            return true;
        }


        return false;
    }
}
