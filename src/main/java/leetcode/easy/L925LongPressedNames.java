package leetcode.easy;

//"alex"
//"aaleex"
//"saeed"
//"ssaaedd"
//"a"
//"lex"
//"a"
//"b"
//"a"
//"a"
//"random"
//"randomf"
//"random"
//"rrrrrrrrrrandommmmmmmmmmm"
//"rastafari"
//"rasstaafaaarrrriiiiiiiii"
public class L925LongPressedNames {

    public static void main(String[] args) {
        new L925LongPressedNames().run();
    }

    public void run(){
        System.out.println(isLongPressedName("random", "randomf"));
    }

    public boolean isLongPressedName(String name, String typed) {

        int i = 0;
        int j = 0;

        while( i < name.length() && j < typed.length() ){
            char c = name.charAt(i);
            int k = 0;
            while( i < name.length() && name.charAt(i) == c ) {
                k++;
                i++;
            }

            while( j < typed.length() && typed.charAt(j) == c ) {
                k--;
                j++;
            }

            if( k > 0 ) return false;
        }

        return i == name.length() && j == typed.length();
    }



}
