package leetcode.easy;

//"aaabc"
//"cbbd"
//"dddaaa"
public class L2716MinimizeStringLength {

    public int minimizedStringLength(String s) {

        int[] freqArr = new int[26];

        int count = 0;

        for( int i = 0; i < s.length(); i++ ){
            if( freqArr[s.charAt(i)-'a'] == 0 ) count++;
            freqArr[s.charAt(i)-'a']++;
        }

        return count;

    }
}
