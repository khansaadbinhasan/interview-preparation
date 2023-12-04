package leetcode.easy;

//"a0b1c2"
//"leetcode"
//"1229857369"
//"kdashafkasdhflks97878675564545"
//"123abc"
//"abcd123"
//"1234abc"
//"a1"
public class L1417ReformatString {

    public String reformat(String s) {

        int[] freqArrAlphas = new int[26];
        int[] freqArrNums = new int[10];

        int alphas = 0;
        int digs = 0;

        for( int i = 0; i < s.length(); i++ ){
            if( s.charAt(i) >= 'a' && s.charAt(i) <= 'z' ){
                freqArrAlphas[s.charAt(i)-'a']++;
                alphas++;
            }

            else if( s.charAt(i) >= '0' && s.charAt(i) <= '9' ){
                freqArrNums[s.charAt(i)-'0']++;
                digs++;
            }
        }

        if( Math.abs(digs-alphas) > 1 ) return "";

        String reformat = "";

        int i = 0;
        int j = 0;
        int lastIind = 0;
        int lastJind = 0;

        if( alphas > digs ){

            char curr = 'a';

            for( int k = 0; k < freqArrAlphas.length; k++ ){
                if( freqArrAlphas[k] > 0 ){
                    curr = (char) (k + 'a');
                    lastIind = k;
                    freqArrAlphas[k]--;
                    break;
                }
            }

            reformat += String.valueOf((char) curr);
            i++;
        }

        else{
            char curr = '0';

            for( int k = lastJind; k < freqArrNums.length; k++ ){
                if( freqArrNums[k] > 0 ){
                    curr = (char) (k + '0');
                    lastJind = k;
                    freqArrNums[k]--;
                    break;
                }
            }

            reformat += String.valueOf((char) curr);
            j++;
        }

        while( i < alphas || j < digs ){
            char last = reformat.charAt(reformat.length()-1);

            if( i < alphas && !(last >= 'a' && last <= 'z') ){
                char curr = 'a';

                for( int k = lastIind; k < freqArrAlphas.length; k++ ){
                    if( freqArrAlphas[k] > 0 ){
                        curr = (char) (k + 'a');
                        lastIind = k;
                        freqArrAlphas[k]--;
                        break;
                    }
                }

                reformat += String.valueOf(curr);
                i++;
            }

            if( j < digs && !(last >= '0' && last <= '9') ){
                char curr = '0';

                for( int k = lastJind; k < freqArrNums.length; k++ ){
                    if( freqArrNums[k] > 0 ){
                        curr = (char) (k + '0');
                        lastJind = k;
                        freqArrNums[k]--;
                        break;
                    }
                }

                reformat += String.valueOf(curr);
                j++;
            }
        }

        return reformat;
    }
}
