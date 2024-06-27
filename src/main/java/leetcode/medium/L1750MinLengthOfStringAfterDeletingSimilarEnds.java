package leetcode.medium;

//"ca"
//"cabaabac"
//"aabccabba"
//"abcabc"
//"a"
//"ababbabababababbbabbcbcbcbbcbcbcbbbcccaccacacacaccacacacacaccacacaaaaa"
//"abcaabcacabbcacbaacba"
//"abcaabcaccacbaacba"
//"aa"
//"bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb"
public class L1750MinLengthOfStringAfterDeletingSimilarEnds {

    public static void main(String[] args) {
        new L1750MinLengthOfStringAfterDeletingSimilarEnds().run();
    }

    public void run(){
        System.out.println(minimumLength("bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb"));
    }

    public int minimumLength(String s) {
        return delete(s).length();
    }

    public String delete(String s){
        if( s.isEmpty() ) return s;
        if( s.length() == 1 ) return s;

        char a = s.charAt(0);
        char b = s.charAt(s.length()-1);

        if( a != b ) return s;

        int p1 = 1;
        int p2 = s.length() - 2;

        while( p1 < s.length() && s.charAt(p1) == a ){
            p1++;
        }

        while( p2 >= 0 && s.charAt(p2) == b ){
            p2--;
        }

        if( p1 > p2 ) return "";

        return delete(s.substring(p1, p2+1));
    }

}
