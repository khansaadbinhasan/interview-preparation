package leetcode.easy;

import java.util.Collections;
import java.util.LinkedList;

//["7868190130M7522","5303914400F9211","9273338290F4010"]
//["1313579440F2036","2921522980M5644"]
public class L2678NumberOfSeniorCitizens {

    public int countSeniors(String[] details) {

        int seniors = 0;

        for(String detail: details){
            if( getAge(detail) > 60 ) seniors++;
        }

        return seniors;
    }

    public int getAge(String detail){
        return (detail.charAt(detail.length()-4) - '0') * 10 + (detail.charAt(detail.length()-3) - '0');

    }
}
