package leetcode.easy;

//"abc"
//"pqr"
//"ab"
//"pqrs"
//"abcd"
//"a"
//"b"
//"pq"
public class L1768MergeString {

    public String mergeAlternately(String word1, String word2) {

        int i = 0;
        int j = 0;

        StringBuilder mergedString = new StringBuilder();

        while( i < word1.length() && j < word2.length() ){
            mergedString.append(word1.charAt(i));
            mergedString.append(word2.charAt(j));

            i++;
            j++;
        }

        while( i < word1.length() ){
            mergedString.append(word1.charAt(i));
            i++;
        }

        while( j < word2.length() ){
            mergedString.append(word2.charAt(j));
            j++;
        }

        return mergedString.toString();

    }


}
