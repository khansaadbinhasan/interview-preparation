package leetcode.hard;

import java.util.*;

public class L127WordLadder {

    class Pair{
        String word;
        int dist;

        public Pair(String word, int dist){
            this.word = word;
            this.dist = dist;
        }
    }


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> setWords = new HashSet<>(wordList);

        Map<String, List<String>> adjacencyList = new HashMap<>();

        wordList.add(beginWord);

        for( String word: wordList ){
            List<String> lst = adjacencyList.getOrDefault(word, new LinkedList<>());

            lst.addAll(getListWords(setWords, word));

            adjacencyList.put(word, lst);
        }

        Queue<Pair> bfs = new LinkedList<>();

        bfs.add(new Pair(beginWord,1));

        while( !bfs.isEmpty() ){
            Pair node = bfs.poll();

            List<String> adj = adjacencyList.get(node.word);

            if( adj == null ) continue;

            for( String word: adj ){
                if( word.equals(endWord) ) return node.dist+1;
                bfs.offer(new Pair(word, node.dist+1));
            }

            adjacencyList.remove(node.word);
        }

        return 0;
    }

    public List<String> getListWords(Set<String> wordSet, String word){
        List<String> listWords = new LinkedList<>();

        for( String w: wordSet ){
            if( isEditDistanceOne(word, w) ) listWords.add(w);
        }

        return listWords;
    }

    public boolean isEditDistanceOne( String word1, String word2 ){
        int dist = 0;

        for (int i = 0; i < word1.length(); i++) {
            if( word1.charAt(i) != word2.charAt(i) ) dist++;
        }

        return dist == 1;
    }


}
