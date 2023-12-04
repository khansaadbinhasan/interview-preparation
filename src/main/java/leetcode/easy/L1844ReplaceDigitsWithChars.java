package leetcode.easy;

//"a1c1e1"
//"a1b2c3d4e"

public class L1844ReplaceDigitsWithChars {

    public String replaceDigits(String s) {

        char[] alphas = s.toCharArray();

        for( int i = 0; i < alphas.length - 1; i+=2 ){
            alphas[i+1] = shift(alphas[i], alphas[i+1] -'0');
        }

        return String.valueOf(alphas);
    }

    public char shift(char c, int i){
        return (char) (c+i);
    }

}
