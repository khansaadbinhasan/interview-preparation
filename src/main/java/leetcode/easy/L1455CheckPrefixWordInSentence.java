package leetcode.easy;

//"i love eating burger"
//"burg"
//"this problem is an easy problem"
//"pro"
//"i am tired"
//"you"
//"i use triple pillow"
//"pill"
//"hello from the other side"
//"they"
//"hello from the other side"
//"the"
public class L1455CheckPrefixWordInSentence {

    public int isPrefixOfWord(String sentence, String searchWord) {

        String[] sentenceWords = sentence.split(" ");

        for( int i = 0; i < sentenceWords.length; i++ ){

            int len = searchWord.length();
            String word = sentenceWords[i];


            if( word.length() >= len && word.substring(0, len).equals(searchWord) ) return i+1;
        }

        return -1;
    }

}
