package leetcode.medium;

//"xx"
//"yy"
//"xy"
//"yx"
//"xx"
//"xy"
//"xxxxxxxxxxxxyyyyyyyyyyyyyyy"
//"xxyyyyyxxxxxxxxxxyyyyyyyyyy"
//"xyxyxyxyxyxyxyxyxyxyxyxyxyxy"
//"xyxyxyxyxyxyxyxyxyxyxyxyxyxy"
public class L1247MinSwapsToEqualizeStrings {

    public static void main(String[] args) {
        new L1247MinSwapsToEqualizeStrings().run();
    }

    public void run(){
        System.out.println(minimumSwap("xx", "yy"));
    }

    public int minimumSwap(String s1, String s2) {
        int xCount = 0;
        int yCount = 0;

        String s12 = s1+s2;

        for( int i = 0; i < s12.length(); i++ ){
            if( s12.charAt(i) == 'x' ) xCount++;
            else yCount++;
        }

        if( (xCount % 2 != 0) || (yCount % 2 != 0) ) return -1;

        int count = 0;

        for( int i = 0; i < s1.length(); i++ ){
            int oldI = i;
            while( i < s1.length() && s1.charAt(i) == s2.charAt(i) ) i++;
            if( i >= s1.length() ) break;

            String str1 = String.valueOf(s1.charAt(i));
            String str2 = String.valueOf(s2.charAt(i));

            i++;
            while( i < s1.length() && s1.charAt(i) == s2.charAt(i) ) i++;
            if( i >= s1.length() ) break;

            str1 += String.valueOf(s1.charAt(i));
            str2 += String.valueOf(s2.charAt(i));

            if( (str1.equals("xx") && str2.equals("yy")) || (str2.equals("xx") && str1.equals("yy")) ) count++;
            else if( (str1.equals("xy") && str2.equals("yx")) || (str2.equals("xy") && str1.equals("yx")) ) count+=2;

            if( i != oldI ) i--;
        }

        return count;

    }

}
