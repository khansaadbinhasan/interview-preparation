package leetcode.easy;

//"1s3 PSt"
//["step","steps","stripe","stepple"]
//"1s3 456"
//["looks","pest","stew","show"]
//"123 456"
//["this"]
//"rand OO"
//["randoo", "randomspartano"]
public class L748ShortestCompletingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {

        int[] freqArr = getFreqArr(licensePlate);
        String shortestStr = "";

        for( int i = 0; i < words.length; i++ ){
            if( isContainsFreqArr(getFreqArr(words[i]), freqArr) ){
                if( shortestStr.isEmpty() || words[i].length() < shortestStr.length() ){
                    shortestStr = words[i];
                }
            }
        }

        return shortestStr;
    }

    //checks if freq arr2 is contained in freq arr1
    public boolean isContainsFreqArr(int[] freqArr1, int[] freqArr2){

        for( int i = 0; i < freqArr1.length; i++ ){
            if( freqArr2[i] > freqArr1[i] ) return false;
        }

        return true;
    }

    public int[] getFreqArr(String s){
        int[] freqArr = new int[26];

        s = s.toLowerCase();

        for( int i = 0; i < s.length(); i++ ){
            if( s.charAt(i) >= 'a' && s.charAt(i) <= 'z' )
                freqArr[s.charAt(i)-'a']++;
        }

        return freqArr;
    }
}
