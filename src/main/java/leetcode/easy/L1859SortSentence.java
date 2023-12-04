package leetcode.easy;

//"is2 sentence4 This1 a3"
//"Myself2 Me1 I4 and3"

public class L1859SortSentence {

    public String sortSentence(String s) {

        String[] words = s.split(" ");

        String[] sentence = new String[words.length];

        for( String word: words ){
            sentence[word.charAt(word.length()-1) - '1'] = word.substring(0,word.length()-1);
        }

        String str = "";

        for( String word: sentence ){
            str += word + " ";
        }

        return str.trim();
    }


}
