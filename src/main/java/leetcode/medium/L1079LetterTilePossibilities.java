package leetcode.medium;

import java.util.*;

//"AAB"
//"AAABBC"
//"V"
public class L1079LetterTilePossibilities {

    public static void main(String[] args) {
        new L1079LetterTilePossibilities().run();
    }

    public void run(){
//        new HashMap<>().c
    }

    public int numTilePossibilities(String tiles) {

        int ps = 0;

        Map<Character, Integer> freqMap = new HashMap<>();
        Set<Character> keySet = freqMap.keySet();
        Character[] keysArray = keySet.toArray(new Character[0]);

        int mult = 1;

        for( int i = 0; i < tiles.length(); i++ ){
            if( !freqMap.containsKey(tiles.charAt(i)) ){
                freqMap.put(tiles.charAt(i), 0);
            }

            freqMap.put(tiles.charAt(i), freqMap.get(tiles.charAt(i))+1 );
        }

        Map<Character, Integer> clonedMap = new HashMap<>(freqMap);
        Character[] keysArrayClone = keysArray.clone();

        int j = 0;

        while( !clonedMap.isEmpty() ){
            for( int i = tiles.length(); i > 0; i-- ){
                mult = mult * clonedMap.size();

                if( clonedMap.containsKey(keysArrayClone[j]) ){
                    clonedMap.put(keysArrayClone[j], clonedMap.get(keysArrayClone[j])-1);
                    if( clonedMap.get(keysArrayClone[j]) == 0 ) {
                        clonedMap.remove(keysArrayClone[j]);
                        j++;
                    }
                }
            }

            ps += mult;
        }

        return ps;
    }

    public int fact(int n){
        int fact = 1;

        for( int i = 1; i <= n; i++ ){
            fact = fact*i;
        }

        return fact;
    }
}
