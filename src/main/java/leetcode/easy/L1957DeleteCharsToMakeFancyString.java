package leetcode.easy;

//"leeetcode"
//"aaabaaaa"
//"aab"
//"aaaaaaaaaaaaaa"
//"a"
//"ababababbbbbbbbbbbbbbaaaaaaaa"
//"sjkljslkhjkhdkjhdjkhaaaaaaaaaaaafffffffssssssssssssssssss"
//"kljlkhkkkkkkkkkkkkkkssssssssssppppppppaaaaa"
public class L1957DeleteCharsToMakeFancyString {

    public String makeFancyString(String s) {

        int count = 1;
        StringBuilder sb = new StringBuilder();

        sb.append((char)s.charAt(0));

        for( int i = 1; i < s.length(); i++ ){
            if( s.charAt(i) == s.charAt(i-1) ) count++;
            else count = 1;

            if( count <= 2 ) sb.append((char)s.charAt(i));
        }

        return sb.toString();
    }
}
