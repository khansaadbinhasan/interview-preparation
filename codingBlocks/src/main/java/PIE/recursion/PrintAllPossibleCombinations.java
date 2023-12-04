package PIE.recursion;

public class PrintAllPossibleCombinations {

    public static void main(String[] args) {
        new PrintAllPossibleCombinations().run();
    }

    public void run(){
        String s = "abc";

        powerSet(s, 0, "");
//        powerSet(s, 0);
    }

    public void powerSet(String s, int i, String curr){

        if( s.length() == i ) {
            System.out.println(curr);
            return;
        }

        powerSet(s, i+1, curr + s.charAt(i));
        powerSet(s, i+1, curr);

    }

}
