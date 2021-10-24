package codingBlocks.heap;

import java.util.*;

//6 2
//i love leetcode i love coding


public class TopKFrequentWords {

    class WordFreq implements Comparable{
        String word;
        int freq;

        public WordFreq(String word, int freq){
            this.word = word;
            this.freq = freq;
        }

        @Override
        public int compareTo(Object o) {
            WordFreq that = (WordFreq) o;

            if( that.freq == this.freq ) return that.word.compareTo(this.word);

            return this.freq - that.freq;
        }
    }

    public static void main(String[] args) {
        new TopKFrequentWords().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        String[] words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = sc.next();
        }

        topKFrequent(words, K).forEach(word -> System.out.print(word + " "));
    }

    public List<String> topKFrequent(String[] words, int k) {

        List<String> freqLst = new LinkedList<>();

        Map<String, Integer> freqMap = new HashMap<>();

        for(String word: words){
            if( !freqMap.containsKey(word) ) freqMap.put(word, 0);

            freqMap.put(word, freqMap.get(word) + 1);
        }

        PriorityQueue<WordFreq> freqPQ = new PriorityQueue<>();

        for( String key: freqMap.keySet() ){
            WordFreq wf = new WordFreq(key, freqMap.get(key));

            if( freqPQ.size() >= k ){
                if( wf.compareTo(freqPQ.peek()) > 0 ) freqPQ.poll();
                else continue;
            }

            freqPQ.offer(wf);
        }

        while( !freqPQ.isEmpty() ){
            freqLst.add(freqPQ.poll().word);
        }

        Collections.reverse(freqLst);

        return freqLst;
    }

}
