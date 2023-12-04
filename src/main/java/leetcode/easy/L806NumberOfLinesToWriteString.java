package leetcode.easy;

//[10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
//"abcdefghijklmnopqrstuvwxyz"
//[4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
//"bbbcccdddaaa"
public class L806NumberOfLinesToWriteString {

    public int[] numberOfLines(int[] widths, String s) {

        int lines = 1;

        int pixels = 0;

        for( char c: s.toCharArray() ){

            if( pixels + widths[c-'a'] <= 100 )
                pixels += widths[c-'a'];

            else {
                pixels = widths[c-'a'];
                lines++;
            }
        }

        return new int[]{lines, pixels};
    }

}
