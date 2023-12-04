package leetcode.easy;


import java.util.Arrays;

//"aa"
//"abca"
//"cbzxy"
//"abcabca"
//"a"
//"maaaaaaaaaaaaaaaaaaaaaam"
//"aaaaaaaaaaaaaaaaaaaaaaa"
//"lkajfkldasjfkjallllljdfkajfmndasmnfbdbcnmdsmncbgdjhsbfkjnfhukekj"
public class L1624LargestSubstring {

    public static void main(String[] args) {
        new L1624LargestSubstring().run();
    }

    public void run(){
        System.out.println(maxLengthBetweenEqualCharacters("cbzxy"));
    }

    public int maxLengthBetweenEqualCharacters(String s) {

        int[] freqArrStart = new int[26];
        int[] freqArrEnd = new int[26];

        Arrays.fill(freqArrStart, -1);
        Arrays.fill(freqArrEnd, -1);

        for( int i = 0; i < s.length(); i++ ){
            if( freqArrStart[s.charAt(i)-'a'] == -1 )
                freqArrStart[s.charAt(i)-'a'] = i;
        }

        for( int i = 0; i < s.length(); i++ ){
            freqArrEnd[s.charAt(i)-'a'] = i;
        }

        int max = 0;

        for( int i = 0; i < freqArrStart.length; i++ ){
            max = Math.max(max, freqArrEnd[i] - freqArrStart[i]);
        }

        return max-1;
    }
}
