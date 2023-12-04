package leetcode.easy;

//[1,0,0]
//[1,1,1,0]
//[0]
//[0,0]
//[0,0,1,0]
//[1,0]
//[1,1,1,1,1,1,1,1,0,0,0,0,1,0,0,0,0,1,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0]
//[1,1,1,1,1,1,1,1,0,0,0,0,1,0,0,0,1,1,0]
//[0,1,0]
//[1,0,0,0,1,0]
public class L717OneTwoBitChars {
    public boolean isOneBitCharacter(int[] bits) {
        for( int i = 0; i < bits.length; i++ ){
            if( bits[i] == 0 && i == bits.length-1 ) return true;

            if( bits[i] == 1 ) i++;
        }


        return false;
    }

}
