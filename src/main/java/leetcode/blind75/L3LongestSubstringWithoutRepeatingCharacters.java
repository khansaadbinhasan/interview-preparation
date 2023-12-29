package leetcode.blind75;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


//"abcabcbb"
//"bbbbb"
//"pwwkew"
//"abvcad"
//"abvc"
//"abvca"
//"abcbca"
//"lkokjik"
//"jfhajkldsiijdbsakfband"
//"kdsfhjkdshajfhajkldsiiuiyuyewuyruewhjdbsakfband"
//"kdsfhjkdshajfhajkldsiiuiyuyewuyruewhjdbsakfbandbcjhadhgfjsdk"
//"a"
//"bb"
//"ab"
//"abccba"
//"popoqwlian"
//""
//"dskfhkadhfk9898989JKAJKAKH "
public class L3LongestSubstringWithoutRepeatingCharacters {

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


    public static void main(String[] args) {
        new L3LongestSubstringWithoutRepeatingCharacters().run();
    }

    public void run(){
        System.out.println(lengthOfLongestSubstring23("jfhajkldsiijdbsakfband"));
    }

    public int lengthOfLongestSubstring2(String s) {

        //p1, p2
        //p1 is at 0
        //p2 iterates through the array
        //set that contains elements from p1 to p2-1, if p2 is contained in the set then substring is no longer repeated, else add p2 to the set
        //We can find max = Math.max(max, set.size());


        //0 1 2 3 4 5 6 7
        //a b c a b c b b
        //0 1 2 3 4 5
        //a b v c a d
        //0 1 2 3 4 5
        //p w w k e w

        // int maxLen = 0;//2
        // int p = 1;//4
        // Set<Character> set = new HashSet<>();//{p,w,k}

        // set.add(s.charAt(0));

        // while( p < s.length() ){//6
        //     char c = s.charAt(p);//e

        //     if( set.contains(c) ) {
        //         maxLen = Math.max(maxLen, set.size());
        //         set.remove(c);
        //     }

        //     set.add(s.charAt(p));
        //     p++;
        // }

        // return Math.max(maxLen, set.size());


        // int p1 = 0;
        // int p2 = 1;

        //0 1 2 3 4 5
        //p w w k e w

        //a b

        int maxLen = 0;//0
        Set<Character> set = new HashSet<>();

        for( int p1 = 0; p1 < s.length(); p1++ ){//0
            set = new HashSet<>();//{a,b}
            set.add(s.charAt(p1));
            for( int p2 = p1+1; p2 < s.length(); p2++ ){//1
                if( set.contains(s.charAt(p2)) ){
                    break;
                }

                set.add(s.charAt(p2));
            }

            maxLen = Math.max(maxLen, set.size());
        }

        return maxLen;
    }

    public int lengthOfLongestSubstring23(String s) {

        if( s.length() == 0 ) return 0;

        int maxLen = 0;
        int p1 = 0;
        int p2 = 1;

        int[] freq = new int[1000];

        Arrays.fill(freq, -1);

        for( int i = 0; i < s.length(); i++ ){
            if( freq[s.charAt(i)] == -1 ) freq[s.charAt(i)] = i;
        }

        String sub = s.substring(p1, p2);
        //0 1 2 3 4 5 6 7 8 9
        //j f h a j k l d s i i j d b s a k f b a n d
        s += String.valueOf((char) s.charAt(s.length()-1));

        while( p2 < s.length() ){//6
            sub = s.substring(p1, p2);//bvcad
            char c = s.charAt(p2);//d
            if( sub.contains(String.valueOf(c)) ) {
                maxLen = Math.max(maxLen, sub.length());
                p1 = freq[c]+1;
            }

            freq[c] = p2;
            p2++;
        }

        return Math.max(maxLen, sub.length());
    }

    public int lengthOfLongestSubstring24(String s) {
        Set<Character> set = new HashSet<>();

        int l = 0;
        int max = 0;

        for (int r = 0; r < s.length(); r++) {
            while( set.contains(s.charAt(r)) ){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            max = Math.max(max, r-l+1);
        }

        return max;
    }


}
