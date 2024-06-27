package leetcode.medium;

import java.util.*;

//"aaba*"
//"abc"
//"d*yed"
public class L3170LexicographicallyMinAfterRemovingStars {
    public String clearStars(String s) {

        Map<Character, LinkedList<Integer>> map = new HashMap<>();
        PriorityQueue<Character> minHeap = new PriorityQueue<>();
        Set<Integer> remove = new HashSet<>();

        for( int i = 0; i < s.length(); i++ ){
            char c = s.charAt(i);

            map.putIfAbsent(c, new LinkedList<>());
            map.get(s.charAt(i)).addFirst(i);

            if( c != '*' ) minHeap.add(c);
            else {
                if( !minHeap.isEmpty() ){
                    char character = minHeap.poll();
                    remove.add(map.get(character).getFirst());
                    map.get(character).removeFirst();
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for( int i = 0; i < s.length(); i++ ){
            if(s.charAt(i) == '*') continue;
            if( !remove.contains(i) ) sb.append(String.valueOf(s.charAt(i)));
        }

        return sb.toString();

    }
}
