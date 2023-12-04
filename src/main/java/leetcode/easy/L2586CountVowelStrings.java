package leetcode.easy;

//["are","amy","u"]
//0
//2
//["hey","aeo","mu","ooo","artro"]
//1
//4
//["a"]
//0
//0
public class L2586CountVowelStrings {

    public int vowelStrings(String[] words, int left, int right) {

        int count = 0;

        for( int i = left; i <= right; i++ ){

            if( isVowelString(words[i]) ){
                count++;
            }

        }

        return count;
    }

    public boolean isVowelString(String word){
        return isStartWithVowel(word) && isEndWithVowel(word);
    }

    public boolean isStartWithVowel(String word){
        return word.startsWith("a") || word.startsWith("e") || word.startsWith("i") || word.startsWith("o") || word.startsWith("u");
    }

    public boolean isEndWithVowel(String word){
        return word.endsWith("a") || word.endsWith("e") || word.endsWith("i") || word.endsWith("o") || word.endsWith("u");
    }
}
