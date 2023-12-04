package leetcode.easy;

//"aaaaabbbbbppp"
//"aaaaabbbbbpppp"
//"aaaaabbbbbppppp"
//"aaaaabbbbb"
//"an"
//"bac"
//"aabbccd"
//"aca"
//"zz"
//"cccd"
public class L2423RemoveLetterEqualizeFrequency {

    public static void main(String[] args){
        boolean abcc = new L2423RemoveLetterEqualizeFrequency().equalFrequency("cccd");

        System.out.println(abcc);
    }

    public boolean equalFrequency(String word) {

        int[] freqArr = new int[26];

        for( int i = 0; i < word.length(); i++ ){
            char wordChar = word.charAt(i);
            freqArr[wordChar-'a']++;
        }

        int commonFreq = getCommonFreq(freqArr);
        int numberDifferentElements = getNumberDifferentElements(freqArr, commonFreq);
        int differentElement = getDifferentElement(freqArr, commonFreq);
        int totalElems = getTotalElems(freqArr);

        if(commonFreq == -1) return false;
        if(commonFreq == -2) return true;

        if( numberDifferentElements == 1 ){
            if( differentElement - commonFreq == 1 ) return true;
            if( differentElement == 1 || (commonFreq == 1 && totalElems == 2) ) return true;
        }

        if( numberDifferentElements == 0 ){
            if( commonFreq == 1 ) return true;
        }

        return false;
    }

    private int getTotalElems(int[] freqArr) {

        int totalElem = 0;

        for( int i = 0; i < freqArr.length; i++ ) {
            if (freqArr[i] != 0) {
                totalElem++;
            }
        }

        return totalElem;
    }

    public int getCommonFreq(int[] freqArr){
        int freq1 = 0;
        int freq2 = 0;
        int freq3 = 0;


        int commonFreq = 0;

        for( int i = 0; i < freqArr.length; i++ ){
            if( freqArr[i] != 0 ){
                if( freq1 == 0 ) {
                    freq1 = freqArr[i];
                }

                else if( freq2 == 0 ) {
                    freq2 = freqArr[i];
                }

                else if( freq3 == 0 ) {
                    freq3 = freqArr[i];
                }
            }
        }

        if( freq2 == 0 ) return -2;
        if( freq3 == 0 ) return Math.min(freq1, freq2);

        if( freq1 == freq2 ) return freq1;
        if( freq2 == freq3 ) return freq2;
        if( freq1 == freq3 ) return freq3;

        return -1;
    }

    public int getNumberDifferentElements(int[] freqArr, int commonFreq){

        int numDiffElements = 0;

        for( int i = 0; i < freqArr.length; i++ ){
            if( freqArr[i] != 0 && freqArr[i] != commonFreq) numDiffElements++;
        }

        return numDiffElements;
    }

    public int getDifferentElement(int[] freqArr, int commonFreq){

        int numDiffElements = 0;

        for( int i = 0; i < freqArr.length; i++ ){
            if( freqArr[i] != 0 && freqArr[i] != commonFreq ) return freqArr[i];
        }

        return -1;
    }
}
