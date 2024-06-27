package leetcode.medium;

import java.util.*;

//["3","6","7","10"]
//4
//["2","21","12","1"]
//3
//["0","0"]
//2
//["623986800","3","887298","695","794","6888794705","269409","59930972","723091307","726368","8028385786","378585"]
//11
public class L1985KthLargestNumber {

    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, new Comparator<>(){
            @Override
            public int compare(String s1, String s2){
                if( s1.length() != s2.length() ) return Integer.compare(s2.length(), s1.length());
                return s2.compareTo(s1);
            }
        });

        return nums[k-1];
    }

}
