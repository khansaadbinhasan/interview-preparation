package leetcode.easy;

//["alice and bob love leetcode","i think so too","this is great thanks very much"]
//["please wait","continue to fight","continue to win"]
public class L2114MaxWordsInSentence {

    public int mostWordsFound(String[] sentences) {

        int mostWords = 0;

        for( int i = 0; i < sentences.length; i++ ){
            mostWords = Math.max(mostWords, sentences[i].split(" ").length);
        }

        return mostWords;

    }
}
