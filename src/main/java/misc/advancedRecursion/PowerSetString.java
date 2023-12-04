package misc.advancedRecursion;

public class PowerSetString {


    public static void main(String[] args) {
        new PowerSetString().run();
    }

    public void run(){
        String s = "abc";

        powerSet(s, 0, "");
    }
    
    public void powerSet(String s, int i, String cur){

        if( i == s.length() ) {
            System.out.println("string is: " + cur);
            return;
        }

        powerSet(s, i+1, cur+s.charAt(i));
        powerSet(s, i+1, cur);
    }

}
