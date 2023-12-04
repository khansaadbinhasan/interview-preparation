package leetcode.easy;

//"abc"
//"bza"
//"zjpc"
//"a"
//"z"
//"bgawq"
//"lkjdwdjkofakogfkl"
public class L1974MinTimeToType {

    public int minTimeToType(String word) {

        int time = 0;
        char curr = 'a';

        for( char c: word.toCharArray() ){
            time += minDist(curr, c) + 1;
            curr = c;
        }

        return time;
    }

    public int minDist(char a, char b){

        int diff = Math.abs(a-b);

        return Math.min(diff, 26 - diff);

    }

}
