package leetcode.medium;


import java.util.Arrays;
import java.util.Stack;

//"abacaba"
//"ssssss"
//"adshfjkadshjfhsadjkfhdsjfhjdskhfkjsdahfjkdashfjkdshfkjdsahflkdjasf"
//"iouiihihjdfhkjsadfjdsafkjadshfjklhdsafhjklsadhfkldjhsakfhdjksafhs"
//"a"
//"ab"
//"aa"
public class L2405OptimalPartitionOfString {

    public int partitionString(String s) {

        int[] freqArr = new int[26];
        int count = 1;

        for( int i = 0; i < s.length(); i++ ){
            if( freqArr[s.charAt(i)-'a'] > 0 ){
                Arrays.fill(freqArr, 0);
                count++;
            }

            freqArr[s.charAt(i)-'a']++;
        }

        return count;
    }


}
