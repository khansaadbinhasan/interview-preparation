package codingBlocks.arrays;

import java.util.Scanner;

//teacher
//cher

public class EditDistanceOne {

    public static void main(String[] args) {
        new EditDistanceOne().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        String word1 = sc.next();
        String word2 = sc.next();

        System.out.println(minDistance(word1, word2));
    }

    public boolean minDistance(String word1, String word2) {

        if( Math.abs(word1.length() - word2.length()) >= 2 ) return false;

        if( word1.length() - word2.length() == 1 ) {
            for (int i = 0; i < word2.length(); i++) {

                if( word1.charAt(i) != word2.charAt(i) ){
                    return word1.substring(i + 1, word1.length() - 1).equals(word2.substring(i, word2.length() - 1));
                }
            }
        }

        else if( word2.length() - word1.length() == 1 ) {
            for (int i = 0; i < word1.length(); i++) {

                if( word1.charAt(i) != word2.charAt(i) ){
                    return word2.substring(i + 1, word2.length() - 1).equals(word1.substring(i, word1.length() - 1));
                }
            }
        }

        else if( word2.length() == word1.length() ) {
            for (int i = 0; i < word1.length(); i++) {
                if( word1.charAt(i) != word2.charAt(i) ){
                    return word2.substring(i + 1, word2.length() - 1).equals(word1.substring(i + 1, word1.length() - 1));
                }
            }
        }

        return false;
    }

}
