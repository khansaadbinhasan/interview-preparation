package leetcode.easy;

//"I speak Goat Latin"
//"The quick brown fox jumped over the lazy dog"
public class L824GoatLatin {

    public String toGoatLatin(String sentence) {

        String as = "a";

        String goatSentence = "";

        for( String word: sentence.split(" ") ){

            if( !isVowel(word.charAt(0)) ) word = word.substring(1, word.length()) + word.charAt(0);

            goatSentence += word + "ma" + as + " ";

            as += "a";
        }

        return goatSentence.trim();
    }

    public boolean isVowel( char c ){

        char[] vowels = new char[]{'a','e','i','o','u', 'A', 'E', 'I', 'O', 'U'};

        for( char vowel: vowels ){
            if( c == vowel ) return true;
        }

        return false;
    }

}
