package CTCI.arraysAndStrings;

//"Rats live on no evil star"
//"Tact Coa"
public class IX_1_4_PalindromePermutation {

    public static void main(String[] args) {
        new IX_1_4_PalindromePermutation().run();
    }

    public void run(){
        System.out.println(isPalindromePermutation("Tact Coa"));
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

}
