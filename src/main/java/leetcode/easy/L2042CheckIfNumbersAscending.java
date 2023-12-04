package leetcode.easy;


//"1 box has 3 blue 4 red 6 green and 12 yellow marbles"
//"hello world 5 x 5"
//"sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s"
//"1 1 1 5 4"
//"1 1 1"
//"5 4 3"
//"1 is 2"
//"3 4 5"
public class L2042CheckIfNumbersAscending {

    public static void main(String[] args) {
        new L2042CheckIfNumbersAscending().run();
    }

    public void run(){
        System.out.println(areNumbersAscending("1 box has 3 blue 4 red 6 green and 12 yellow marbles"));
    }

    public boolean areNumbersAscending(String s) {

        int oldNum = -1;

        for( int i = 0; i < s.length(); i++ ){
            if( !(s.charAt(i) >= '0' && s.charAt(i) <= '9') ) continue;

            int num = 0;
            while( i < s.length() && (s.charAt(i) >= '0' && s.charAt(i) <= '9') ){
                num = num*10+(s.charAt(i)-'0');
                i++;
            }

            if( num <= oldNum ) return false;

            oldNum = num;
        }

        return true;

    }

}
