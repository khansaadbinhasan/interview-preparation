package leetcode.easy;

import org.junit.Assert;

import java.util.*;

//"abaccb"
//[1,3,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
//"aa"
//[1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
//"aa"
//[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
//"zz"
//[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
public class L2399CheckDistance {

    public static void main(String[] args) {
        new L2399CheckDistance().run();
    }

    public void run(){
        Assert.assertTrue(checkDistances("abaccb", new int[]{1,3,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));
        Assert.assertFalse(checkDistances("aa", new int[]{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));
        Assert.assertTrue(checkDistances("zz", new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));

        System.out.println("Tests passed successfulyy");
    }

    public boolean checkDistances(String s, int[] distance) {
        int[] distanceArr = new int[26];

        int maxI = 0;

        Arrays.fill(distanceArr, -1);

        for( int i = 0; i < s.length(); i++ ){
            if( distanceArr[s.charAt(i) - 'a'] == -1 ){
                distanceArr[s.charAt(i) - 'a'] = i;
                maxI = Math.max(maxI, s.charAt(i) - 'a');
            } else{
                distanceArr[s.charAt(i) - 'a'] = i - distanceArr[s.charAt(i) - 'a'] - 1;
            }
        }

        for (int i = 0; i < distanceArr.length; i++) {
            if( distanceArr[i] == -1 )
                distanceArr[i] = 0;
        }

        for (int i = 0; i < distanceArr.length; i++) {
            if( distanceArr[i] == 0 && !s.contains(String.valueOf((char)('a' + i)))){
                continue;
            }

            if( (distance[i] != distanceArr[i]) ) {
                return false;
            }
        }

        return true;
    }
}
