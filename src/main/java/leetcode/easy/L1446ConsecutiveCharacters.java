package leetcode.easy;

//"leetcode"
//"abbcccddddeeeeedcba"
//"a"
//"aksdhflkadshkfladshksflazhjfhskjfhasdjkfhdsjkfhsjkdfghkdshgfkjdfshfdjkl"
//"amammaamamammmmmmamammmmmmmmmmmmmaaaaaaaaaa"
//"zzzzzzzzzzzzzzzzzzzzzzzzzzzllllllllllllllll"
public class L1446ConsecutiveCharacters {

    public int maxPower(String s) {

        int[] freqArr = new int[26];

        for( int i = 0; i < s.length(); i++ ){
            char c = s.charAt(i);
            int count = 0;

            while( i < s.length() && s.charAt(i) == c ){
                i++;
                count++;
            }

            i--;

            freqArr[s.charAt(i)-'a'] = Math.max(count, freqArr[s.charAt(i)-'a']);
        }

        int power = 1;

        for( int i = 0; i < freqArr.length; i++ ){
            power = Math.max(power, freqArr[i]);
        }

        return power;
    }
}
