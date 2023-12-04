package leetcode.medium;

//"bab"
//"aba"
//"leetcode"
//"practice"
//"anagram"
//"mangaar"
//"anagram"
//"poiuytr"
//"a"
//"a"
//"a"
//"b"
public class L1347MinNumStepsToMakeAnagram {

    public int minSteps(String s, String t) {

        int[] freqArr1 = new int[26];
        int[] freqArr2 = new int[26];

        for( int i = 0; i < s.length(); i++ ){
            freqArr1[s.charAt(i)-'a']++;
        }

        for( int i = 0; i < t.length(); i++ ){
            freqArr2[t.charAt(i)-'a']++;
        }

        int steps = 0;

        for(int i = 0; i < 26; i++ ){
            steps += Math.abs(freqArr1[i]-freqArr2[i]);
        }

        return steps/2;
    }

}
