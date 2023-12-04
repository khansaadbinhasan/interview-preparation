package leetcode.medium;

//"leetcode"
//"coats"
//"night"
//"thing"
//"kdhasfhfjjkdshfjsdhjfdshjkfhdkghjkdshfgjgkhdkjghdjghjkdshgjkfhgjhfdsjkghkjdfshgkf"
//"popoisoiofjdjshgjkfhdjkghdjksghjksfdhgjkdhgkfjdhjkghsdkjfghjkfdhgjkfd"
//"a"
//"n"
//"a"
//"dksjafajjkdsjfkdsjfkljdsklfjkdsfjkdsghfjkdsghkfjdhgjkdfhgjkhjskghfjkdghfjkdhgjkshgjkfdhgjkdfhgjkhdfskghjkfg"
public class L2186MinNumberOfStepsToMakeAnagram {
    public int minSteps(String s, String t) {

        int[] freqArrS = getFreqArr(s);
        int[] freqArrT = getFreqArr(t);

        int minSteps = 0;


        for( int i = 0; i < freqArrS.length; i++ ){
            minSteps += Math.abs(freqArrS[i] - freqArrT[i]);
        }

        return minSteps;

    }

    public int[] getFreqArr(String s){

        int[] freqArr = new int[26];

        for( int i = 0; i < s.length(); i++ ){
            freqArr[s.charAt(i)-'a']++;
        }

        return freqArr;

    }


}
