package leetcode.medium;

import java.util.*;

//"12"
//"226"
//"06"
//"11106"
//"01"
//"111106"
public class L91DecodeWays {
    int[] numDecodings;

    public int numDecodings(String s) {
        int[] arr = handle0s(s);
        numDecodings = new int[arr.length];
        Arrays.fill(numDecodings, -1);

        return arr[0] == -1? 0: numDecodings(arr, 0);
    }

    public int numDecodings(int[] arr, int start) {
        if( start == arr.length-1 ) return 1;
        if( start == arr.length ){
            return 1;
        }
        if( numDecodings[start] != -1 ) return numDecodings[start];

        int decodings = numDecodings(arr, start+1);
        if( canCombine(arr, start, start+1) == -1 ) return decodings;

        if( start < arr.length-1 ) decodings += numDecodings(arr, start+2);

        return numDecodings[start] = decodings;
    }


    public int[] handle0s(String s){
        int[] arr = new int[s.length()];
        int len = arr.length;

        for( int i = 0; i < s.length(); i++ ){
            arr[i] = s.charAt(i)-'0';
        }

        int start = 0;

        while( start < arr.length && arr[start] == 0 ) start++;

        for( int i = start+1; i < arr.length; i++ ){
            if( arr[i] == 0 && (arr[i-1] > 2 || arr[i-1] == 0) ) return new int[]{-1};
            if( arr[i] == 0 ){
                arr[i] = arr[i-1]*10+arr[i];
                arr[i-1] = -1;
                len--;
            }
        }

        int[] res = new int[len];
        int ind = 0;

        for( int i = 0; i < arr.length; i++ ){
            if( arr[i] != -1 ) res[ind++] = arr[i];
        }

        return res;
    }

    public int canCombine(int[] arr, int i, int j){
        if( arr[i] > 2 ) return -1;
        if( arr[i] == 2 && arr[j] > 6 ) return -1;
        return arr[i]*10+arr[j];
    }

    public static void main(String[] args) {
        new L91DecodeWays().run();
    }

    public void run(){
        System.out.println(numDecodings("226"));
    }

    int[] dp;
    String s;
    public int numDecodings2(String str) {
        s = str;
        dp = new int[s.length()+1];
        Arrays.fill(dp, -1);
        dp[s.length()] = 1;

        return dfs(0);
    }

    public int dfs(int i){
        // if( i >= s.length() ) return 0;
        if( dp[i] != -1 ) return dp[i];
        if( s.charAt(i) == '0' ) return 0;

        int res = dfs(i+1);
        if( i+1 < s.length() && ( s.charAt(i) == '1' ||
                (s.charAt(i) == '2' && "0123456".indexOf(s.charAt(i+1)) != -1) )
        ){
            res += dfs(i+2);
        }

        return dp[i] = res;
    }

}
