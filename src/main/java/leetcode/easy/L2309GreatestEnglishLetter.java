package leetcode.easy;

//"lEeTcOdE"
//"arRAzFif"
//"AbCdEfGhIjK"
//"AbLKHKJHJKSFHJKLFHDJKLFHJKDFHJKDHKHFKJLDHKJEjK"
//"AbLKHKJHJKSFHJKLFHDJKLFHJKDFHJKDHKHFKJLDHKJljkhjggyuftyfsfjdbkfjhksfhjksdhfkjdszzzZEjK"
public class L2309GreatestEnglishLetter {

    public String greatestLetter(String s) {

        int[] smallFreqArr = new int[26];
        int[] capitalFreqArr = new int[26];

        for( int i = 0; i < s.length(); i++ ){
            if( s.charAt(i) >= 'A' && s.charAt(i) <= 'Z' )
                capitalFreqArr[s.charAt(i)-'A']++;
        }

        for( int i = 0; i < s.length(); i++ ){
            if( s.charAt(i) >= 'a' && s.charAt(i) <= 'z' )
                smallFreqArr[s.charAt(i)-'a']++;
        }

        int greatestInd = -1;

        for( int i = 0; i < 26; i++ ){
            if( capitalFreqArr[i] != 0 && smallFreqArr[i] != 0 ){
                greatestInd = i;
            }
        }

        if( greatestInd == -1 ) return "";

        return String.valueOf((char) (greatestInd + 'A'));

    }

}
