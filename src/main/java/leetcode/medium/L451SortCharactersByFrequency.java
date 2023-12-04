package leetcode.medium;

import java.util.*;

//"tree"
//"cccaaa"
//"Aabb"
//"AbbAbbbnnmdnfmndfmnNNMNMNMNMNMNHHHHFHHF"
//"a"
//"pdsfnkldsfkdskfjsdlfjklsdjfdslkjfklsdjJJJJJJJJJJJJJKKKKKKKSSSSSSSSLLLLLLL"
//"2a554442f544asfasssffffasss"
public class L451SortCharactersByFrequency {

    public static void main(String[] args) {
        new L451SortCharactersByFrequency().run();
    }

    public void run(){
        System.out.println(frequencySort("tree"));
    }

    class CharFreq implements Comparable<CharFreq>{
        char c;
        int freq;

        public CharFreq(char c, int freq){
            this.c = c;
            this.freq = freq;
        }

        public boolean equals(Object o){
            if (this == o) return true;
            if (!(o instanceof CharFreq)) return false;
            CharFreq charFreq = (CharFreq) o;
            return this.c == charFreq.c && this.freq == charFreq.freq;
        }

        @Override
        public int compareTo(CharFreq charFreq) {
            return Integer.compare(this.freq, charFreq.freq);
        }
    }

    public String frequencySort(String s) {

        int[] freqArr = new int[300];

        for( int i = 0; i < s.length(); i++ ){
            freqArr[s.charAt(i)]++;
        }

        StringBuilder sb = new StringBuilder();

        PriorityQueue<CharFreq> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for( int i = 0; i < freqArr.length; i++ ){
            pq.add(
                    new CharFreq(
                            (char) i,
                            freqArr[i]
                    )
            );
        }

        while( !pq.isEmpty() ){
            CharFreq charFreq = pq.poll();

            while(charFreq.freq > 0){
                sb.append(charFreq.c);
                charFreq.freq--;
            }
        }

        return sb.toString();
    }
}
