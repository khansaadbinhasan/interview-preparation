package leetcode.easy;

//"10#11#12"
//"1326#"
//"25#"
//"12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"
public class L1309DecryptStringFromAlphaMapping {

    public String freqAlphabets(String s) {

        StringBuilder res = new StringBuilder();

        for( int i = s.length()-1; i >= 0; i-- ){


            if(s.charAt(i) == '#'){
                res.append((char)('a' + Integer.valueOf(s.substring(i-2, i)) - 1));
                i -= 2;
            }

            else{
                res.append((char)('a' + s.charAt(i) - '1'));
            }
        }

        return res.reverse().toString();
    }

}
