package leetcode.easy;

//"abccbaacz"
//"abcdd"
public class L2351FirstLetterToAppearTwice {

    public char repeatedCharacter(String s) {
        int[] freqArr = new int[26];


        for( int i = 0; i < s.length(); i++ ){
            if( freqArr[s.charAt(i)-'a'] == 1 ) return s.charAt(i);

            freqArr[s.charAt(i)-'a']++;
        }

        return 'a';
    }
}
