package leetcode.easy;

import java.util.*;

//"alice is a good girl she is a good student"
//"a"
//"good"
//"we will we will rock you"
//"we"
//"will"
public class L1078OccurencesAfterBigram {

    public String[] findOcurrences(String text, String first, String second) {

        String[] textWords = text.split(" ");

        String[] words = new String[textWords.length];

        int pointer = 0;

        for( int i = 0; i < textWords.length-2; i++ ){
            if( textWords[i].equals(first) && textWords[i+1].equals(second) )
                words[pointer++] = textWords[i+2];
        }

        return Arrays.copyOf(words, pointer);
    }

}
