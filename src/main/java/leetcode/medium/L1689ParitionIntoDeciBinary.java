package leetcode.medium;

//"32"
//"82734"
//"27346209830709182346"
//"1"
//"23232323284093258093485094328507342657863247856984376598236458473658923654857623498576345876325894564327856387265784365879324658932657832645897364586349875632487"
//"9"
//"5"
public class L1689ParitionIntoDeciBinary {

    public int minPartitions(String n) {
        int max = 0;

        for( int i = 0; i < n.length(); i++ ){
            max = Math.max( max, n.charAt(i)-'0' );
        }

        return max;
    }
}
