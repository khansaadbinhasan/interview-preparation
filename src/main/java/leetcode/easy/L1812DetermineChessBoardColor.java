package leetcode.easy;

//"a1"
//"h3"
//"c7"
public class L1812DetermineChessBoardColor {

    public boolean squareIsWhite(String coordinates) {

        char[] yx = coordinates.toCharArray();

        int y = yx[0] - '1';
        int x = yx[1] - 'a';

        if( (isEven(x) && isEven(y)) || (!isEven(x) && !isEven(y)) ) return false;

        return true;
    }

    public boolean isEven(int n){
        return n % 2 == 0;
    }

}
