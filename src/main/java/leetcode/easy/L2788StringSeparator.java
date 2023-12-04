package leetcode.easy;

import java.util.*;

public class L2788StringSeparator {

    public static void main(String[] args) {
        new L2788StringSeparator().run();
    }

    public void run(){
        LinkedList<String> words = new LinkedList<>();

        words.add("one.two.three");
        words.add("four.five");
        words.add("six");

        System.out.println(splitWordsBySeparator(words, '.'));
    }

    public List<String> splitWordsBySeparator(List<String> words, char separator) {

        List<String> splittedWords = new LinkedList<>();

        for( String word: words ){
            splittedWords.addAll(separate(word, separator));
        }

        return splittedWords;
    }

    public List<String> separate(String word, char separator){
        List<String> split = new LinkedList<>();
        String[] wordSplit = word.split("");

        for( int i = 0; i < wordSplit.length; i++ ){
            StringBuilder sb = new StringBuilder();
            while( i < wordSplit.length ){
                if( word.charAt(i) == separator ){
                    break;
                }
                sb.append(word.charAt(i));
                i++;
            }

            if( !sb.toString().isEmpty() ) {
                split.add(sb.toString());
            }
        }

        return split;
    }

}
