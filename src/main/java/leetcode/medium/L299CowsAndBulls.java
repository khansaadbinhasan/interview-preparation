package leetcode.medium;

//"1807"
//"7810"
//"1123"
//"0111"
//"0000"
//"1111"
//"0000"
//"0000"
//"12347856490"
//"09090800000"
//"1"
//"1"
//"0"
//"1"
public class L299CowsAndBulls {

    public static void main(String[] args) {
        new L299CowsAndBulls().run();
    }

    public void run(){
        System.out.println(getHint("1807","7810"));
    }

    public String getHint(String secret, String guess) {

        int[] freqSecret = new int[10];
        int[] freqGuess = new int[10];
        int bulls = 0;
        int cows = 0;

        for( int i = 0; i < secret.length(); i++ ){
            if( secret.charAt(i) == guess.charAt(i) ) bulls++;
            else {
                freqSecret[secret.charAt(i)-'0']++;
                freqGuess[guess.charAt(i)-'0']++;
            }
        }

        for( int i = 0; i < freqSecret.length; i++ ){
            cows += Math.min(freqSecret[i], freqGuess[i]);
        }

        return bulls + "A" + cows + "B";

    }
}
