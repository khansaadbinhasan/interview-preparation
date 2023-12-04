package leetcode.medium;

import java.util.*;

//"leet**cod*e"
//"erase*****"
//"abb*cdfg*****x*"
//"a*a"
//"a*"
//"aa"
//"aaaaaaaaaab**b**b**b**b**"
public class L2390RemovingStarsFromString {

    public static void main(String[] args) {
        new L2390RemovingStarsFromString().run();
    }

    public void run(){
        System.out.println(removeStars("abb*cdfg*****x*"));
    }

    public String removeStars(String s) {
        int p = 0;

        StringBuilder sb = new StringBuilder(s);
        Set<Integer> indices = new HashSet<>();

        for( int i = 0; i < sb.length(); i++ ){

            if( sb.charAt(i) == '*' ){
                indices.add(i);

                if( sb.charAt(i-1) >= 'a' && sb.charAt(i-1) <= 'z' ){
                    p = i-1;
                }

                while( p >= 0 && indices.contains(p) ) p--;

                indices.add(p);
                p--;
            }
        }

        StringBuilder ans = new StringBuilder();

        for( int i = 0; i < sb.length(); i++ ){
            if( !indices.contains(i) ){
                ans.append(sb.charAt(i));
            }
        }

        return ans.toString();
    }
}
