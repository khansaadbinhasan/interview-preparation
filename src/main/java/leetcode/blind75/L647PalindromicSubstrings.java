package leetcode.blind75;

import java.util.HashSet;
import java.util.Set;

//"abc"
//"aaa"
//"popo"
//"dsklfjadks"
//"lalalallalalal"
//"dasklfhjkadshkjfhasdfhjadshaosh"
//"popopopopopopppppoooppopop"
//"ooioioioioioioioi"
public class L647PalindromicSubstrings {

    public static void main(String[] args) {
        new L647PalindromicSubstrings().run();
    }

    public void run(){
        System.out.println(countSubstrings("aaa"));
    }


    public int countSubstrings(String s) {

        Set<int[]> palSet = new HashSet<>();
        int n = s.length();

        for( int i = 0; i < n; i++ ){

            int p1 = i;
            int p2 = i;

            while( checkBoundaries(p1, p2, n) && s.charAt(i) == s.charAt(p2) ){
                palSet.add(new int[]{p1, p2});
                p2++;
            }

            while( checkBoundaries(p1, p2, n) && s.charAt(p1) == s.charAt(i) ){
                palSet.add(new int[]{p1, p2});
                p1--;
            }

            if( p1 == i ) p1 = i-1;
            if( p2 == i ) p2 = i+1;

            while( checkBoundaries(p1, p2, n) ){

                if( checkBoundaries(p1, p2, n) && s.charAt(p1) == s.charAt(p2) ){
                    palSet.add(new int[]{p1, p2});
                    p1--;
                    p2++;
                }

                else break;
            }
        }

        return palSet.size();

    }

    public boolean checkBoundaries(int p1, int p2, int n){
        return p1 >= 0 && p2 < n;
    }

    public int countSubstrings2(String s) {

        int n = s.length();
        int count = 0;

        //odd
        for( int i = 0; i < n; i++ ){
            int p1 = i;
            int p2 = i;

            while( checkBoundaries(p1, p2, n) && s.charAt(p1) == s.charAt(p2) ){
                p1--;
                p2++;
                count++;
            }
        }


        //even
        for( int i = 1; i < n; i++ ){
            int p1 = i-1;
            int p2 = i;

            while( checkBoundaries(p1, p2, n) && s.charAt(p1) == s.charAt(p2) ){
                p1--;
                p2++;
                count++;
            }
        }

        return count;
    }

}
