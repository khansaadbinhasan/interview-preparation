package leetcode.medium;

//"TTFF"
//2
//"TFFT"
//1
//"TTFTTFTT"
//1
//"T"
//1
//"FFF"
//1
//"FTFF"
//2
//"FTTTFFFFFTTTFFTTTTFTFTFFTTFTTTTTTF"
//3
//"FTFFTFTFTTFTTFTTFFTTFFTTTTTFTTTFTFFTTFFFFFTTTTFTTTTTTTTTFTTFFTTFTFFTTTFFFFFTTTFFTTTTFTFTFFTTFTTTTTTF"
//32
public class L2024MaximizeConfusion {

    public static void main(String[] args) {
        new L2024MaximizeConfusion().run();
    }

    public void run(){
        System.out.println(maxConsecutiveAnswers("FTTTFFFFFTTTFFTTTTFTFTFFTTFTTTTTTF", 3));
    }

    public int maxConsecutiveAnswers(String answerKey, int k) {

        int maxAns = 0;

        for( int i = 0; i < answerKey.length(); i++ ){
            int t = 0;
            int f = 0;

            for( int j = i; j < answerKey.length(); j++ ){
                if( Math.min(t, f) > k ) {

                    if( t == Math.min(t, f) ){
                        t--;
                    }
                    else{
                        f--;
                    }

                    break;
                }

                if( answerKey.charAt(j) == 'T' ) t++;
                else f++;
            }

            if( Math.min(t, f) > k ) {

                if( t == Math.min(t, f) ){
                    t--;
                }
                else{
                    f--;
                }
            }

            if( Math.min(t, f) <= k ){
                maxAns = Math.max(maxAns, t+f);
            }
        }

        return maxAns;

    }

}
