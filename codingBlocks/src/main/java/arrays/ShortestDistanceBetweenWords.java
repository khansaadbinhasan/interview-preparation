package arrays;

import java.util.*;

public class ShortestDistanceBetweenWords {

    public static void main(String[] args) {
        run();
    }

    public static void run(){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        String[] stringArr = new String[N];

        for (int i = 0; i < N; i++) {
            stringArr[i] = sc.next();
        }

        String word1 = sc.next();
        String word2 = sc.next();

        System.out.println(shortestDistanceBtwWords(stringArr, word1, word2));
//        System.out.println(shortestDistanceBtwWordsInON(stringArr, word1, word2));
    }

    public static int shortestDistanceBtwWordsInON(String[] stringArr, String word1, String word2){

        int minDist = 10000000;
        int pointer1 = 10000000;
        int pointer2 = 10000000;

        for (int i = 0; i < stringArr.length; i++) {

            if(minDist == 1)
                return minDist;

            if( stringArr[i].equals(word1) ){

                minDist = Math.min(minDist, mod(pointer2-i));

                pointer1 = i;
            }

            if( stringArr[i].equals(word2) ){

                minDist = Math.min(minDist, mod(pointer1-i));

                pointer2 = i;
            }
        }

        return minDist;
    }

    public static int shortestDistanceBtwWords(String[] stringArr, String word1, String word2){

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int i = 0; i < stringArr.length; i++) {
            if( stringArr[i].equals(word1) ){
                list1.add(i);
            }

            if( stringArr[i].equals(word2) ){
                list2.add(i);
            }
        }

        int dist = 100000000;
        
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {

                if( dist == 1 ){
                    return dist;
                }

                int tempDist = mod(list1.get(i) - list2.get(j));
                if( tempDist < dist ){
                    dist = tempDist;
                }
            }
        }

        return dist;
        
    }


    public static int mod(int num){
        if( num < 0 ){
            return -1 * num;
        }

        return num;
    }

}
