package leetcode.easy;

//["pay","attention","practice","attend"]
//"at"
//["leetcode","win","loops","success"]
//"code"
//["this","thiskldsjflk","thikdjfkjldskfl","a"]
//"this"
public class L2185CountWordsWithGivenPrefix {

    public int prefixCount(String[] words, String pref) {

        int prefixCount = 0;

        for( String word: words ){
            if( word.length() < pref.length() ) continue;

            if( word.substring(0, pref.length()).equals(pref) ){
                prefixCount++;
            }
        }

        return prefixCount;
    }
}