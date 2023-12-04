package leetcode.easy;

//["ab", "c"]
//["a", "bc"]
//["a", "cb"]
//["ab", "c"]
//["abc", "d", "defg"]
//["abcddefg"]

public class L1662StringArraysEquivalent {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        String s1 = "";
        String s2 = "";

        for( String word: word1 ){
            s1 += word;
        }

        for( String word: word2 ){
            s2 += word;
        }

        return s1.equals(s2);
    }

}
