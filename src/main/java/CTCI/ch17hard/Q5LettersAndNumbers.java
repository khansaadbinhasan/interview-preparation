package CTCI.ch17hard;

import java.util.HashMap;
import java.util.Map;

public class Q5LettersAndNumbers {


    public static void main(String[] args) {
        new Q5LettersAndNumbers().run();
    }

    public void run(){
        System.out.println(maxLettersAndNumbers(new char[]{'a','1','b','0'}));
        System.out.println(maxLettersAndNumbers(new char[]{'a','1', 'a', 'a', 'a', '1', '1', '1', 'a', '1', 'a', 'a', '1', '1', 'a', 'a', 'a', 'a', 'a', 'a'}));
    }

    private int maxLettersAndNumbers(char[] lettersAndNumbers) {
        int max = 0;
        int num = 0;

        Map<Integer, int[]> map = new HashMap<>();

        map.put(0, new int[]{-1,-2});

        for (int i = 0; i < lettersAndNumbers.length; i++) {
            if( !Character.isDigit(lettersAndNumbers[i]) ) num++;
            else num--;

            if( !map.containsKey(num) ) map.put(num, new int[]{i,i-1});
            else {
                int[] indices = map.get(num);
                indices[1] = i;
            }
        }

        for( int key: map.keySet() ){
            int[] indices = map.get(key);
            max = Math.max(indices[1]-indices[0], max);
        }


        return max;
    }

}
