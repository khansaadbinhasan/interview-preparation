package leetcode.blind75;

//"anagram"
//"nagaram"
//"rat"
//"car"
//"racecar"
//"carracer"
//"thisisnotananagram"
//"isthisananagram"
//"a"
//"b"
//"a"
//"a"
//"isthisandhfhklashgsahjhjkgfhrjaklagkjhadsjkfhjkads"
//"isthisflksdkgfhasohgfoiashfjashdfkdsaklfadsklfhdaslfh"

public class L242ValidAnagram {

    public boolean isAnagram(String a, String b) {
        // Complete the function
        if( a.length() != b.length() ) return false;

        int[] freqArr1 = new int[26];

        java.util.Arrays.fill(freqArr1, 0);

        a = a.toLowerCase();

        for( int i = 0; i < a.length(); i++ ){
            freqArr1[a.charAt(i)-'a']++;
        }

        int[] freqArr2 = new int[26];

        java.util.Arrays.fill(freqArr2, 0);

        b = b.toLowerCase();

        for( int i = 0; i < b.length(); i++ ){
            freqArr2[b.charAt(i)-'a']++;
        }

        return java.util.Arrays.equals(freqArr1, freqArr2);
    }

//    public boolean isAnagram(String a, String b) {
//        if( a.length() != b.length() ) return false;
//
//        int[] freqArr1 = new int[26];
//        int[] freqArr2 = new int[26];
//
//        for( int i = 0; i < a.length(); i++ ){
//            freqArr1[a.charAt(i)-'a']++;
//            freqArr2[b.charAt(i)-'a']++;
//        }
//
//        return Arrays.equals(freqArr1, freqArr2);
//    }
}
