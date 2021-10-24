package leetcode.easy;

//"Hello how are you Contestant"
//4
//"What is the solution to this problem"
//4
//"chopper is not a tanuki"
//5
public class L1816TruncateSentence {

    public String truncateSentence(String s, int k) {

        String[] wordsArr = s.split(" ");

        StringBuilder sb = new StringBuilder();

        for( int i = 0; i < k; i++ ){
            sb.append(wordsArr[i]).append(" ");
        }

        return sb.toString().trim();
    }

}
