package leetcode.medium;

//"cdbcbbaaabab"
//4
//5
//"aabbaaxybbaabb"
//5
//4
public class L1717MaxScoreFromRemovingSubstring {

    public static void main(String[] args) {
        new L1717MaxScoreFromRemovingSubstring().run();
    }

    public void run(){
        System.out.println(maximumGain("aabbaaxybbaabb", 123, 3495));
    }

    public int maximumGain(String s, int x, int y) {
        int gain = 0;

        while( !s.isEmpty() ){
            int sLenOrig = s.length();
            int sLen = s.length();

            if( y > x ){
                s = s.replaceAll("ba","");
                gain += ((sLen-s.length())/2)*y;

                sLen = s.length();

                s = s.replaceAll("ab","");
                gain += ((sLen-s.length())/2)*x;
            }

            else{
                s = s.replaceAll("ab","");
                gain += ((sLen-s.length())/2)*x;

                sLen = s.length();

                s = s.replaceAll("ba","");
                gain += ((sLen-s.length())/2)*y;
            }

            if( sLenOrig == s.length() ){
                break;
            }
        }

        return gain;
    }

}
