package heap;

import java.util.PriorityQueue;
import java.util.Scanner;


//S = "aab"

public class ReorganizeString {

    class CharFreq implements Comparable {
        char c;
        int freq;

        public CharFreq(char c, int freq){
            this.c = c;
            this.freq = freq;
        }

        @Override
        public int compareTo(Object o) {
            CharFreq that = (CharFreq) o;

            if( that.freq - this.freq == 0 ) return that.c - this.c;

            return that.freq - this.freq;
        }
    }

    public static void main(String[] args) {
        new ReorganizeString().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        System.out.println(reorganizeString(sc.next()));
    }

    public String reorganizeString(String s) {

        if( s.length() == 1 ) return s;

        PriorityQueue<CharFreq> priorityQueue = new PriorityQueue<>();

        int[] freqArr = new int[26];

        char[] charArr1 = s.toCharArray();

        for( char c: charArr1 ){
            freqArr[c-'a']++;
        }

        for( char c: charArr1 ){
            priorityQueue.offer(new CharFreq(c, freqArr[c-'a']));
        }

        int pointer1 = 0;
        int pointer2 = 1;

        char[] charArr = new char[s.length()];

        while( !priorityQueue.isEmpty() && pointer1 < charArr.length ){
            charArr[pointer1] = priorityQueue.poll().c;
            pointer1 += 2;
        }

        while( !priorityQueue.isEmpty() && pointer2 < charArr.length ){
            charArr[pointer2] = priorityQueue.poll().c;
            pointer2 += 2;
        }

        for (int i = 1; i < charArr.length; i++) {
            if( charArr[i] == charArr[i-1] ) return "";
        }

        return new String(charArr);
    }

}
