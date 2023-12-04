package leetcode.easy;

//"USA"
//"FlaG"
//"leetcode"
//"NeetCode"
//"Reedcode"
//"S"
//"PLIEr"
//"a"
public class L520DetectCapitals {

    public boolean detectCapitalUse(String word) {
        return allCapitals(word) || allSmalls(word) || firstCapital(word);
    }

    public boolean allCapitals(String word){
        return word.toUpperCase().equals(word);
    }

    public boolean allSmalls(String word){
        return word.toLowerCase().equals(word);
    }

    public boolean firstCapital(String word){
        return word.substring(1).toLowerCase().equals(word.substring(1)) && word.substring(0,1).toUpperCase().equals(word.substring(0,1));
    }
}
