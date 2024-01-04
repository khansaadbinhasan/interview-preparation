package leetcode.easy;

//"sadbutsad"
//"sad"
//"leetcode"
//"leeto"
public class L28FindIndexOccurenceInString {

    public int strStr(String haystack, String needle) {
        if(needle.isEmpty()) return 0;

        int p1 = 0;
        int p2 = 0;

        while( p1 < haystack.length() && p2 < needle.length() ){
            if( haystack.charAt(p1) == needle.charAt(p2) ) {
                p2++;
            }

            else {
                p2 = 0;
            }

            p1++;
        }


        if( p2 == needle.length() ) return p1 - p2;

        return -1;
    }

    public int strStr2(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public int strStr3(String haystack, String needle) {
        int p1 = 0;//10
        int p2 = 0;//4

        //sadbutsadi
        //sadi
        while( p1 < haystack.length() && p2 < needle.length() ){
            int start = p1;//3
            while( haystack.charAt(p1) == needle.charAt(p2) ) {
                p1++;
                p2++;

                if( p2 == needle.length() ) return start;
                if( p1 == haystack.length() ) return -1;
            }

            p2 = 0;
            p1=start+1;
        }

        return -1;
    }

}
