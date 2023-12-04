package leetcode.easy;

//"capiTalIze tHe titLe"
//"First leTTeR of EACH Word"
//"i lOve leetcode"
//"This is sparttttaaAAAA"
public class L2129CapitalizeTital {

    public String capitalizeTitle(String title) {

        String capitalized = "";

        for( String word: title.split(" ") ){
            capitalized += capitalize(word) + " ";
        }

        return capitalized.trim();

    }

    public String capitalize(String word){
        word = word.toLowerCase();

        if( word.length() >= 3 ) {
            word = word.substring(0,1).toUpperCase() + word.substring(1);
        }

        return word;
    }
}
