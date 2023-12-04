package leetcode.easy;

//"abccccdd"
//"a"
//"abcdsfhkadjsfhkjdasfhjadsklhfkadsfhjdshfkjadshfjkslahfjkdsahfkjldshfljAAAAAAAAAAAAAAAAAAABBBBBBBBBBBBBBBBBJKHJKKJHJKHKHKHK"
//"sghkjsDDDDDDDDDDDDDDDDDDDDDSSSSSSSSSSSSsfghkfjshjkhfkljsdhfjkdhfjdksahfjkshfjkdshfJJJJJJJJJJJJJJJJDDDDDDDDDDDDDDDDDDDDDDDDDDDDD"
public class L409LongestPalindrome {

    public int longestPalindrome(String s) {

        int[] freqArr = new int[52];

        for( int i = 0; i < s.length(); i++ ){
            if( s.charAt(i) >= 'a' && s.charAt(i) <= 'z' )
                freqArr[s.charAt(i)-'a']++;

            else if( s.charAt(i) >= 'A' && s.charAt(i) <= 'Z' )
                freqArr[s.charAt(i)-'A' + 26]++;
        }

        int palLen = 0;
        boolean isOddDone = false;

        for( int i = 0; i < freqArr.length; i++ ){
            palLen += (freqArr[i] / 2)*2;

            if( freqArr[i] % 2 != 0 && !isOddDone ){
                palLen++;
                isOddDone = !isOddDone;
            }
        }

        return palLen;

    }
}
