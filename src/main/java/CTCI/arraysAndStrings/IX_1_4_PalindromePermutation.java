package CTCI.arraysAndStrings;

//"Rats live on no evil star"
//"Tact Coa"
public class IX_1_4_PalindromePermutation {

    public static void main(String[] args) {
        new IX_1_4_PalindromePermutation().run();
    }

    public void run(){
        System.out.println(isPalindromePermutation2("Tact Coa"));
        System.out.println(isPalindromePermutation2("Rats live on no evil star"));
        System.out.println(isPalindromePermutation2("Rats live on no evil stars"));
        System.out.println(isPalindromePermutation2("Rats live on no evil starsp"));
    }

    public boolean isPalindromePermutation(String s){

        s = makeAllSmall(s);

        System.out.println(s);

        int[] freqArr = getFreqArr(s);

        int numOdds = 0;

        for (int i = 0; i < freqArr.length; i++) {
            if( !isEven(freqArr[i]) ) {
                if( numOdds > 0 ) return false;

                numOdds++;
            }
        }

        return true;
    }

    public boolean isEven(int num){
        return num % 2 == 0;
    }

    public int[] getFreqArr(String s){
        int[] freqArr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freqArr[s.charAt(i)-'a']++;
        }

        return freqArr;
    }

    public String makeAllSmall(String s){
        return s.trim().replaceAll(" ", "").toLowerCase();
    }


    public boolean isPalindromePermutation2(String s){
        s = makeAllSmall(s);

        int bitVector = createBitVector(s);

        boolean isOdd = false;

        while( bitVector != 0 ){
            if( ( bitVector & 1 ) == 1 ) {
                if( isOdd ) return false;
                isOdd = true;
            }

            bitVector = bitVector >> 1;
        }

        return true;
    }

    public int createBitVector(String phrase){
        int bitVector = 0;

        for( char c: phrase.toCharArray() ){
            bitVector = toggle(bitVector, c-'a');
        }

        return bitVector;
    }

    public int toggle(int bitVector, int index){
        if( index < 0 ) return bitVector;

        int mask = 1 << index;
        if( (bitVector & mask) == 0 ){
            bitVector |= mask;
        }

        else {
            bitVector &= ~mask;
        }

        return bitVector;
    }

}
