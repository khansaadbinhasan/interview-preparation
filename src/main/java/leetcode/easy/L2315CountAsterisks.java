package leetcode.easy;

//"l|*e*et|c**o|*de|"
//"iamprogrammer"
//"yo|uar|e**|b|e***au|tifu|l"
public class L2315CountAsterisks {
    public int countAsterisks(String s) {

        int totalAsterisks = 0;

        char[] asteriskArr = s.toCharArray();

        for( int i = 0; i < asteriskArr.length; i++ ){
            if( asteriskArr[i] == '|' ){
                asteriskArr[i++] = 'r';

                while( i < asteriskArr.length-1 && asteriskArr[i] != '|' ){
                    asteriskArr[i++] = 'r';
                }
            }
        }

        for( int i = 0; i < asteriskArr.length; i++ ){
            if( asteriskArr[i] == '*' ){
                totalAsterisks++;
            }
        }

        return totalAsterisks;
    }

    public static void main(String[] args){
        int abcc = new L2315CountAsterisks().countAsterisks("l|*e*et|c**o|*de|");

        System.out.println(abcc);
    }

}
