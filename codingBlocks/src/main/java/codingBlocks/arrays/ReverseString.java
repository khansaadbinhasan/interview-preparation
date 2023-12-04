package codingBlocks.arrays;

public class ReverseString {

    public static void main(String[] args) {
        new ReverseString().run();
    }

    public void run(){
        char[] s = new char[]{'h','e','l','l','o'};

        reverseString(s);

        for( char c: s ) System.out.print(c + " ");

        System.out.println();
    }

    public void reverseString(char[] s) {

        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length-1 - i];
            s[s.length-1 - i] = temp;
        }
    }

}
