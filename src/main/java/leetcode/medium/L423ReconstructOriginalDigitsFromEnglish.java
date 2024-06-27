package leetcode.medium;

import java.util.*;

//"owoztneoer"
//"fviefuro"
//"noe"
//"fonoenienonetwowtohtreevesensixghteiurenni"
public class L423ReconstructOriginalDigitsFromEnglish {

    public String originalDigits(String s) {
        int[] nums = new int[10];
        int[] freq = new int[26];

        for( char c: s.toCharArray() ){
            freq[c-'a']++;
        }

        List<Character> removeFirst = Arrays.asList('z','w','u','x','g');
        List<Character> removeSecond = Arrays.asList('o','f','s','h');
        List<Character> removeThird = Arrays.asList('i');

        for( char c: removeFirst ){
            if( freq[c-'a'] == 0 ) continue;
            switch( c ){
                case 'z':
                    nums[0] += freq[c-'a'];
                    remove(freq, "zero", freq[c-'a']);
                    break;
                case 'w':
                    nums[2] += freq[c-'a'];
                    remove(freq, "two", freq[c-'a']);
                    break;
                case 'u':
                    nums[4] += freq[c-'a'];
                    remove(freq, "four", freq[c-'a']);
                    break;
                case 'x':
                    nums[6] += freq[c-'a'];
                    remove(freq, "six", freq[c-'a']);
                    break;
                case 'g':
                    nums[8] += freq[c-'a'];
                    remove(freq, "eight", freq[c-'a']);
                    break;
                default: break;
            }
        }

        for( char c: removeSecond ){
            if( freq[c-'a'] == 0 ) continue;
            switch( c ){
                case 'o':
                    nums[1] += freq[c-'a'];
                    remove(freq, "one", freq[c-'a']);
                    break;
                case 'f':
                    nums[5] += freq[c-'a'];
                    remove(freq, "five", freq[c-'a']);
                    break;
                case 's':
                    nums[7] += freq[c-'a'];
                    remove(freq, "seven", freq[c-'a']);
                    break;
                case 'h':
                    nums[3] += freq[c-'a'];
                    remove(freq, "three", freq[c-'a']);
                    break;
                default: break;
            }
        }

        for( char c: removeThird ){
            if( freq[c-'a'] == 0 ) continue;
            switch( c ){
                case 'i':
                    nums[9] += freq[c-'a'];
                    remove(freq, "nine", freq[c-'a']);
                    break;
                default: break;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < nums.length; i++){
            for( int k = 0; k < nums[i]; k++ ){
                sb.append(i);
            }
        }

        return sb.toString();

    }

    public void remove(int[] freq, String num, int times){
        for( char c: num.toCharArray() ){
            freq[c-'a']-=times;
        }
    }

}
