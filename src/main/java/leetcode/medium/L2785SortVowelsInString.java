package leetcode.medium;

import java.util.*;


public class L2785SortVowelsInString {

    public static void main(String[] args) {
        new L2785SortVowelsInString().run();
    }

    public void run(){
    }

    Set<Character> vowels = new HashSet<>();

    public String sortVowels(String s) {

         vowels.add('a'); vowels.add('e'); vowels.add('i'); vowels.add('o'); vowels.add('u');
    vowels.add('A'); vowels.add('E'); vowels.add('I'); vowels.add('O'); vowels.add('U');

        int[] freqArr = new int[200];

        for( int i = 0; i < s.length(); i++ ){
            if( isVowel(s.charAt(i)) )
                freqArr[s.charAt(i)]++;
        }

        int vowelI = 0;

        while( vowelI < s.length() ){
            if( isVowel(s.charAt(vowelI)) ){
                break;
            }
            vowelI++;
        }

        StringBuilder sortedString = new StringBuilder(s);        

        for( int i = 'A'; i <= 'z'; i++ ){
            if( freqArr[i] > 0 ){
                freqArr[i]--;
                sortedString.setCharAt(vowelI, (char) i);
                vowelI++;
                i--;
            }

            while( vowelI < s.length() ){
                if( isVowel(s.charAt(vowelI)) ){
                    break;
                }
                vowelI++;
            }
        }

        return sortedString.toString();
    }

    public boolean isVowel(char c){
        return vowels.contains(c);
    }


}
