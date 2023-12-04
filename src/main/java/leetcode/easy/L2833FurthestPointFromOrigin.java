package leetcode.easy;

//"L_RL__R"
//"_R__LL_"
//"_______"
//"LLLLLLL"
//"RRRRRRRR"
//"RRRLLLLR"
//"_"
//"R"
//"____R____RRLLLLR_____"
//"_R_L_"
public class L2833FurthestPointFromOrigin {

    public int furthestDistanceFromOrigin(String moves) {
        int numL = 0;
        int numR = 0;

        for( int i = 0; i < moves.length(); i++ ){
            if( moves.charAt(i) == 'L' ) numL++;
            else if( moves.charAt(i) == 'R' ) numR++;
        }

        return Math.abs(numL-numR)+(moves.length()-(numL+numR));
    }

}
