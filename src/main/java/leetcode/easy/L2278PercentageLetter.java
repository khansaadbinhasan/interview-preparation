package leetcode.easy;

//"foobar"
//"o"
//"jjjj"
//"k"
//"jjjj"
//"j"
//"a"
//"b"
//"a"
//"a"
public class L2278PercentageLetter {

    public static void main(String[] args) {
        new L2278PercentageLetter().run();
    }

    public void run(){
        System.out.println(percentageLetter("foobar",'o'));
    }

    public int percentageLetter(String s, char letter) {
        int times = 0;
        for( int i = 0; i < s.length(); i++ ){
            times += ((s.charAt(i)==letter)?1:0);
        }
        return (times*100) / s.length();
    }
}
