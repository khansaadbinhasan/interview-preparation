package leetcode.easy;


//"a", "b"
//"aa", "ab"
//"aa", "aab"
public class L383RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {

        //create freq arr for both ransomNote and magazine
        //rNFreqArr, magFreqArr
        //isSubsetOf(int[] freqArr1, int[] freqArr2)//Returns true if freqArr1 is subset of freqArr2 else false

        int[] rNFreqArr = getFreqArr(ransomNote);
        int[] magFreqArr = getFreqArr(magazine);

        return isSubsetOf(rNFreqArr, magFreqArr);
    }

    private int[] getFreqArr(String s){

        int[] freqArr = new int[26];

        for( int i = 0; i < s.length(); i++ ){
            freqArr[s.charAt(i)-'a']++;
        }

        return freqArr;
    }

    //Returns true if freqArr1 is subset of freqArr2 else false
    private boolean isSubsetOf(int[] freqArr1, int[] freqArr2){

        for( int i = 0; i < freqArr1.length; i++ ){
            if( freqArr2[i] - freqArr1[i] < 0 ) return false;
        }

        return true;
    }

}
