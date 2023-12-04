package leetcode.easy;

//"string"
//"poiinter"
//"ai"
//"hjhghghfgi"
//"aiiiiiiiiiiiiiiii"
//"djfkladslfiiiidfjdkhfiiiiiiiopopaaioieiiaiiiaiaiaii"
//"a"
public class L2810FaultyKeyboard {
    public String finalString(String s) {

        StringBuilder sb = new StringBuilder();

        for( String k: s.split("") ){
            if( k.equals("i") ){
                sb = sb.reverse();
            }

            else{
                sb.append(k);
            }
        }

        return sb.toString();
    }
}
