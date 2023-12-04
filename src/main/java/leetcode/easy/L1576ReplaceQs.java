package leetcode.easy;

//"?zs"
//"ubv?w"
//"?"
//"ab?"
//"?abcd"
//"?a?"
//"?kldfhjahsdkf??????????dhfasfj????????????aba?????????"
//"???????????????????rhjudhyeglojude???"
public class L1576ReplaceQs {

    public String modifyString(String s) {

        StringBuilder sb = new StringBuilder("r");

        sb.append(s);
        sb.append("r");

        for( int i = 1; i < sb.length()-1; i++ ){
            if( sb.charAt(i) == '?'){
                sb.replace(i, i+1, getNextChar(sb.charAt(i-1), sb.charAt(i+1)));
            }
        }

        return sb.delete(0, 1).delete(sb.length()-1, sb.length()).toString();

    }

    public String getNextChar(char a, char b){
        char c = a;
        if( a < b ){
            c = b;
        }

        if( (a == 'a' && b == 'z') || (a == 'z' && b == 'a') ) return "r";

        if( c == 'z' ) return "a";
        else return String.valueOf((char) (c+1));
    }
}
