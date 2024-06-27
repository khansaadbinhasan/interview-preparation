package leetcode.medium;

//"coaching"
//"coding"
//"abcde"
//"a"
//"z"
//"abcde"
//"a"
//"a"
//"a"
//"b"
//"adsjkfhgjkadshfjkashfhasiudrweoiuryioweqyuryewouiryweqiouryuwioqeryoqwierioqweyrughasfgdsajvdbshcbdsjhfgkdshgafjds"
//"skdjlsfjkhdsfk"
public class L2486AppendCharactersToMakeStringEqual {

    public int appendCharacters(String s, String t) {

        int p1 = 0;
        int p2 = 0;

        while( p1 < s.length() && p2 < t.length() ){
            if( s.charAt(p1) == t.charAt(p2) ){
                p2++;
            }

            p1++;
        }

        return t.length()-p2;

    }

    public int appendCharacters2(String s, String t) {

        int p1 = 0;
        int p2 = 0;

        while( p1 < s.length() && p2 < t.length() ){
            if( s.charAt(p1) == t.charAt(p2) ) p2++;

            p1++;
        }

        return t.length()-p2;

    }

}
