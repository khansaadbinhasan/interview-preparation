package codingBlocks.hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class LongestSubstringWithoutRepetition {

    public static void main(String[] args) {
        new LongestSubstringWithoutRepetition().run();
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            System.out.println(lengthOfLongestSubstring(sc.next()));
        }
    }

    public int lengthOfLongestSubstring(String s) {

        if(s.length() == 0) return 0;

        int maxLen = 0;
        int pointer1 = 0;
        int pointer2 = 1;

        while( pointer1 < s.length() && pointer2 <= s.length() ){

            String currStr = s.substring(pointer1, pointer2);

            if( !isRepeatedChars(currStr) ){
                pointer2++;
                if( currStr.length() > maxLen ) maxLen = currStr.length();
            }

            else pointer1++;
        }

        return maxLen;
    }

    public boolean isRepeatedChars(String str){
        return str.length() != new HashSet<>(Arrays.asList(str.split(""))).size();
    }
}
