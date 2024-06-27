package codingBlocks.hashing;

import java.util.*;

public class LongestSubstringWithKdistinctCharacters {

    public static void main(String[] args) {
        new LongestSubstringWithKdistinctCharacters().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            System.out.println(longestSubstringLen(sc.next(), sc.nextInt()));
        }
    }

    public int longestSubstringLen(String s, int k){
        int subStrLen = 0;

        Set<String> set = new HashSet<>();
        String[] strArr = s.split("");

        int pointer1 = 0;
        int pointer2 = 1;

        set.add(strArr[pointer1]);

        while( pointer1 < pointer2 && pointer2 < strArr.length ){

            if( set.size() <= k ){
                set.add(strArr[pointer2]);
                subStrLen = Math.max(subStrLen, pointer2-pointer1);

                pointer2++;
            }

            else{
                pointer1++;
                set = updateSet(strArr, pointer1, pointer2);
            }
        }

        return subStrLen;
    }

    public Set<String> updateSet(String[] strArr, int pointer1, int pointer2){
        Set<String> set = new HashSet<>();

        for( int i = pointer1; i < pointer2; i++){
            set.add(strArr[i]);
        }

        return set;
    }

}
