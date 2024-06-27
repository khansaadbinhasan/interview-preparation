package codingBlocks.graphs;

import java.util.*;

//hit
//cog
//6
//hot dot dog lot log cog

//hit
//cog
//5
//hot dot dog lot log

//hit
//hot
//1
//hot
public class WordLadder {

    public static void main(String[] args) {
        new WordLadder().run();
    }

    class Pair{
        String word;
        int dist;

        public Pair(String word, int dist){
            this.word = word;
            this.dist = dist;
        }
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        String beginWord = sc.next();
        String endWord = sc.next();
        int N = sc.nextInt();

        List<String> wordList = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            wordList.add(sc.next());
        }

        System.out.println(ladderLength(beginWord, endWord, wordList));
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

//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        Queue<Pair> queue = new LinkedList<>();
//
//        queue.add(new Pair(beginWord, 1));
//
//        HashSet<String> sets = new HashSet<>(wordList);
//
//        while( !queue.isEmpty() ){
//            Pair x = queue.poll();
//
//
//        }
//    }
}