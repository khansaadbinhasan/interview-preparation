package leetcode.medium;

//"abcde"
//"ace"
//"abc"
//"abc"
//"abc"
//"def"
//"a"
//"b"
//"a"
//"a"
//"dklfajkhowioqwow"
//"dkdoqwiqopo"
//"dklfajkdjhfkhaskjdfhkahjkfhasjkdhfjkhfjkhdsajkfhjkdsahfiueuiyruiwyuipopoqpowioqiwoqiwoqwiqowioqwiqow"
//"dkdfdfdaskjdfhkahjkfhasjkdhfjkhfjkhdsppqpqpqpqqyruiwyuipopoqpowioqiwoqiwoqwiqowioqwiqopopopo"
//"dkwow"
//"dkopo"
//"dkwowoooo"
//"dkopopopop"
public class L1143LongestCommonSubsequence {

    public static void main(String[] args) {
        new L1143LongestCommonSubsequence().run();
    }

    public void run(){
        System.out.println(longestCommonSubsequence(
                "dhfjkh",
                "hfjkh"
        ));
    }

    public int longestCommonSubsequence(String text1, String text2) {

        int[][] maxLens = new int[text1.length()+1][text2.length()+1];

        for (int i = 0; i < text1.length(); i++) {
            maxLens[i][0] = 0;
        }

        for (int j = 0; j < text2.length(); j++) {
            maxLens[0][j] = 0;
        }


        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if( text1.charAt(i) == text2.charAt(j) ) maxLens[i+1][j+1] = maxLens[i][j] + 1;
                else maxLens[i+1][j+1] = Math.max(maxLens[i+1][j], maxLens[i][j+1]);
            }
        }

        return maxLens[text1.length()][text2.length()];
    }


    public int longestCommonSubsequence2(String text1, String text2) {
        int[][] lcs = new int[text1.length()+1][text2.length()+1];

        for( int i = 0; i < lcs.length-1; i++ ){
            for( int j = 0; j < lcs[i].length-1; j++ ){
                if( text1.charAt(i)==text2.charAt(j) ) lcs[i+1][j+1] = lcs[i][j]+1;
                else lcs[i+1][j+1] = Math.max(lcs[i+1][j], lcs[i][j+1]);
            }
        }

        return lcs[text1.length()][text2.length()];
    }



    public int longestCommonSubsequence4(String text1, String text2) {
        int[][] lcs = new int[text1.length()+1][text2.length()+1];

        for( int i = 0; i < lcs.length-1; i++ ){
            for( int j = 0; j < lcs[i].length-1; j++ ){
                if( text1.charAt(i+1) == text2.charAt(j+1) ) lcs[i][j] += lcs[i+1][j+1]+1;
                else lcs[i][j] = Math.max(lcs[i][j+1], lcs[i+1][j]);
            }
        }

        return lcs[0][0];
    }


    public int longestCommonSubsequence3(String text1, String text2) {
        return Math.max(getSubstringLen(text1, text2), getSubstringLen(text2, text1));
    }

    public int getSubstringLen(String text1, String text2){
        int p1 = 0;
        int p2 = 0;
        int s = 0;

        while( p1 < text1.length() && p2 < text2.length() ){
            if( text1.charAt(p1) == text2.charAt(p2) ){
                p1++;
                s++;
            }

            p2++;
        }

        return s;
    }


    int[][] lcs;

    public int longestCommonSubsequence5(String text1, String text2) {
        lcs = new int[text1.length()][text2.length()];

        return lcs(text1, text2, 0, 0);
    }

    public int lcs(String text1, String text2, int i, int j){
        if( i >= text1.length() || j >= text2.length() ) return 0;
        if( lcs[i][j] != 0 ) return lcs[i][j];
        if( text1.charAt(i) == text2.charAt(j) ) return lcs[i][j]=lcs(text1, text2, i+1, j+1) + 1;
        return lcs[i][j]=Math.max(lcs(text1, text2, i,j+1), lcs(text1, text2, i+1,j));
    }



}
