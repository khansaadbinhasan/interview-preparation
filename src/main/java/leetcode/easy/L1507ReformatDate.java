package leetcode.easy;

import java.util.*;

//"20th Oct 2052"
//"6th Jun 1933"
//"26th May 1960"
//"31st Dec 2100"
public class L1507ReformatDate {

    public String reformatDate(String date) {
        String[] dateArr = date.split(" ");

        String day = dateArr[0];
        String month = dateArr[1];
        String year = dateArr[2];

        return year + "-" + getMonth(month) + "-" + getDay(day);
    }

    public String getDay(String day){
        day = day.substring(0, day.length()-2);
        return (day.length() == 1 ? "0":"") + day;
    }

    public String getMonth(String month){

        Map<String, String> monthVsMonthStr = new HashMap<>();

        monthVsMonthStr.put("Jan", "01");
        monthVsMonthStr.put("Feb", "02");
        monthVsMonthStr.put("Mar", "03");
        monthVsMonthStr.put("Apr", "04");
        monthVsMonthStr.put("May", "05");
        monthVsMonthStr.put("Jun", "06");
        monthVsMonthStr.put("Jul", "07");
        monthVsMonthStr.put("Aug", "08");
        monthVsMonthStr.put("Sep", "09");
        monthVsMonthStr.put("Oct", "10");
        monthVsMonthStr.put("Nov", "11");
        monthVsMonthStr.put("Dec", "12");


        return monthVsMonthStr.get(month);
    }


}
