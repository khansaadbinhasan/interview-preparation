package arrays;

import java.util.Scanner;

//5
//practice  makes  perfect  coding makes
//coding practice
//5
//this that them thy their
//this thy
//5
//practice  makes perfect coding makes
//makes makes

public class ShortestDistanceBetweenWords2 {

    public static void main(String[] args) {
        new ShortestDistanceBetweenWords2().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String[] wordArr = new String[N];

        for (int i = 0; i < N; i++) {
            wordArr[i] = sc.next();
        }

        String word1 = sc.next();
        String word2 = sc.next();

        System.out.println(getDistanceBtwWords(wordArr, word1, word2));
    }

    public int getDistanceBtwWords(String[] wordArr, String word1, String word2){

        int min = wordArr.length;

        if( word1.equals(word2) ){
            int pointer = wordArr.length+1;

            for (int i = 0; i < wordArr.length; i++) {

                if( word1.equals(wordArr[i])){
                    min = Math.min(min, Math.abs(pointer-i));
                    pointer = i;
                }
            }
        }

        else{
            int pointer1 = wordArr.length+1;
            int pointer2 = wordArr.length+1;

            for (int i = 0; i < wordArr.length; i++) {
                if( wordArr[i].equals(word1) ){
                    pointer1 = i;
                    min = Math.min(min, Math.abs(pointer2-i));
                }

                else if( wordArr[i].equals(word2) ){
                    pointer2 = i;
                    min = Math.min(min, Math.abs(i - pointer1));
                }
            }
        }

        return min;
    }
}
