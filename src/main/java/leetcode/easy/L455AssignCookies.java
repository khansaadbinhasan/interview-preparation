package leetcode.easy;


import java.util.Arrays;

//[1,2,3]
//[1,1]
//[1,2]
//[1,2,3]
//[1,2,3]
//[3]
public class L455AssignCookies {

    public static void main(String[] args){
        new L455AssignCookies().run();
    }

    public void run(){
        int contentChildren = new L455AssignCookies().findContentChildren(new int[]{1, 2, 3}, new int[]{3});
//        new L455AssignCookies().findContentChildren(new int[]{1,2}, new int[]{1,2,3});

        System.out.println(contentChildren);
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int triptChildrens = 0;
        int j = 0;

        for( int i = 0; i < g.length; i++ ){
            while( j < s.length ){
                if( s[j] >= g[i] ) {
                    triptChildrens++;
                    j++;
                    break;
                }

                j++;
            }

            if( j >= s.length ) break;
        }

        return triptChildrens;
    }

}
