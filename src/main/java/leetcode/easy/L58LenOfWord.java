package leetcode.easy;

//"Hello World"
//"   fly me   to   the moon  "
//"luffy is still joyboy"
//"a "
//"this is sdknfkasldf  "
//"ajkfjd   "
public class L58LenOfWord {

    public int lengthOfLastWord(String s) {

        int len = 0;

        int k = s.length()-1;

        while( k >= 0 && !isLetter(s.charAt(k)) ){
            k--;
        }

        for(int i = k; i >= 0; i--){
            if( isLetter(s.charAt(i)) ) len++;
            else break;
        }

        return len;
    }

    public boolean isLetter(char c){
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
}
