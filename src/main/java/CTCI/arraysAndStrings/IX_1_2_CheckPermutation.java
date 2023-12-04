package CTCI.arraysAndStrings;

import java.util.Arrays;

public class IX_1_2_CheckPermutation {


    public static void main(String[] args) {
        new IX_1_2_CheckPermutation().run();
    }

    public void run(){

        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};

        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean anagram = checkPermutation(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + anagram);
        }

//        String s1 = "this";
//        String s2 = "that";
//
//        System.out.println(s1 + " is" + (checkPermutation(s1, s2) ? "" : " not") + " a permutation of " + s2);
    }

    //checks if s1 is permutation of s2
    public boolean checkPermutation(String s1, String s2){

        if( s1.length() != s2.length() ) return false;

        int[] freqArrS1 = getFreqArr(s1);
        int[] freqArrS2 = getFreqArr(s2);

        return Arrays.equals(freqArrS1, freqArrS2);
    }

    public int[] getFreqArr(String s){
        int[] freqArr = new int[128];

        for (int i = 0; i < s.length(); i++) {
            freqArr[s.charAt(i)]++;
        }

        return freqArr;
    }

}
